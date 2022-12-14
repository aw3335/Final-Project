package com.hfad.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "highscore.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context)
    {
        super(context, DB_NAME,null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(DBContract.UserEntry.CREATE_EMP_TABLE_CMD);
        db.execSQL(DBContract.UserEntry.CREATE_EMP_TABLE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.UserEntry.DROP_EMP_TABLE_CMD);
        onCreate(db);
    }


    public void saveEntry(String name, String game, int score)
    {
        //insert into employee(name, dob, designation) values ('Angel', 10000000 , 'SQL Programmer');
        @SuppressLint("DefaultLocale") String insertString = String.format("insert into %s(%s, %s, %s) " +
                        "values ('%s', '%s' , %d);", DBContract.UserEntry.TABLE_NAME,
                DBContract.UserEntry.COLUMN_NAME,DBContract.UserEntry.COLUMN_GAME, DBContract.UserEntry.COLUMN_SCORE,
                name, game, score);

        System.out.println("Saving: " + insertString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertString); //for writing

        db.close();
    }

    public void deleteEntry(long id)
    {
        //insert into employee(name, dob, designation) values ('Angel', 10000000 , 'SQL Programmer');
        @SuppressLint("DefaultLocale") String insertString = String.format("delete from %s where %s = %d);",
                DBContract.UserEntry.TABLE_NAME, DBContract.UserEntry.COLUMN_ID, id);

        System.out.println("Saving: " + insertString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertString); //for writing

        db.close();
    }

    //NEED TO CHANGE TO ENTRY
    public ArrayList<Entry> fetchAllEntries()
    {
        ArrayList<Entry> allEntries = new ArrayList<Entry>();

        String insertString = String.format("Select * from %s", DBContract.UserEntry.TABLE_NAME);

        System.out.println("Fetching All: " + insertString);

        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor starts at the -1th position
        Cursor cursor = db.rawQuery(insertString, null);

        //Get the positions of your cols
        int idPos = cursor.getColumnIndex(DBContract.UserEntry.COLUMN_ID);
        int namePos = cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME);
        int gamePos = cursor.getColumnIndex(DBContract.UserEntry.COLUMN_GAME);
        int scorePos = cursor.getColumnIndex(DBContract.UserEntry.COLUMN_SCORE);


        //Use positions to request the values in the columns
        while(cursor.moveToNext())
        {
            long id = cursor.getLong(idPos);
            int score = cursor.getInt(scorePos);
            String name = cursor.getString(namePos);
            String game = cursor.getString(gamePos);
            allEntries.add(new Entry(id, name, game, score));
        }

        cursor.close();
        db.close();

        return allEntries;

    }
}
