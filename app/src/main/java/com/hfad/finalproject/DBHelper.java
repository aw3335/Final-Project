package com.hfad.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Class DBHelper allows the program to run SQL Lite
 */
public class DBHelper extends SQLiteOpenHelper {

    //The Database file name
    private static final String DB_NAME = "highscore.db";
    //What version of the DB
    private static final int DB_VERSION = 1;

    /**
     * Constructor that call parent Constructor Connecting to SQL Database
     */
    public DBHelper(Context context)
    {
        super(context, DB_NAME,null, DB_VERSION );
    }

    /**
     * OnCreate creates the table for the program to use
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(DBContract.UserEntry.CREATE_EMP_TABLE_CMD);
        db.execSQL(DBContract.UserEntry.CREATE_EMP_TABLE_CMD);
    }

    /**
     * Takes in the database and drops the table, then creates a new one
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.UserEntry.DROP_EMP_TABLE_CMD);
        onCreate(db);
    }

    /**
     * When called gathers parameters and inserts them into the table with the
     * appropiate names and values
     * @param name The name of the winning player
     * @param game The game they played
     * @param score The score of that game
     */
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

    /**
     * When called takes the id of the entry needing to be deleted and runs
     * the correct SQL Statement to delete it from the table.
     * @param id The id of the element that should be deleted
     */
    public void deleteEntry(long id)
    {
        //Sql Code to delete an entry from the table;
        @SuppressLint("DefaultLocale") String insertString = String.format("delete from %s where %s = %d",
                DBContract.UserEntry.TABLE_NAME, DBContract.UserEntry.COLUMN_ID, id);

        System.out.println("Saving: " + insertString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertString); //for writing

        db.close();
    }

    /**
     * When called, the function will Select all the entries from the table and return
     * them into an ArrayList of Entries
     * @return
     */
    public ArrayList<Entry> fetchAllEntries()
    {
        ArrayList<Entry> allEntries = new ArrayList<Entry>();

        //SQL Statement is created
        String insertString = String.format("Select * from %s", DBContract.UserEntry.TABLE_NAME);

        //Print out to check if statement is correct
        System.out.println("Fetching All: " + insertString);

        //Creates a readable database that can be called
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

        //Close the cursor and database
        cursor.close();
        db.close();

        //Return the new ArrayList of entries
        return allEntries;

    }
}
