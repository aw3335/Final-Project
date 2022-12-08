package com.hfad.finalproject;

import android.provider.BaseColumns;

public class DBContract {

    class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "HighScore";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_GAME = "game";
        public static final String COLUMN_SCORE = "score";

        //Implementing basecolumns forces us to implement this line of code
        public static final String COLUMN_ID = _ID;

        public static final String CREATE_EMP_TABLE_CMD = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_GAME +" TEXT NOT NULL,"
                + COLUMN_SCORE +" INTEGER NOT NULL)";

        public static final String DROP_EMP_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
