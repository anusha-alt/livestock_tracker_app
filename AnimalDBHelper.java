package com.example.at_lab_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AnimalDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "animals.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "animal";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_SPECIES = "species";
    public static final String COL_AGE = "age";
    public static final String COL_DESC = "description";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_SPECIES + " TEXT," +
                    COL_AGE + " INTEGER," +
                    COL_DESC + " TEXT)";

    public AnimalDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Simple upgrade policy: drop and recreate
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

