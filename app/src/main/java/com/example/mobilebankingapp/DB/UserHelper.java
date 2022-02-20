package com.example.mobilebankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserTDone.UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 2;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserTDone.UserEntry.TABLE_NAME + " ("
                + UserTDone.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserTDone.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserTDone.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserTDone.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserTDone.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserTDone.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Aman Kumar', 'amankumar@gmail.com','9584','7017040235', 35000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Anmol Singh', 'anmol@gmail.com','7258','9995641238', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Anurag Sharma', 'anurag@gmail.com','1956','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Kartik Joshi', 'kartik@gmail.com','8052','7995640038', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Sudha Joshi', 'sudha@gmail.com','5669','8099648962', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Payal Verma', 'payal@gmail.com','9985','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yash Pratap', 'yash@gmail.com','1207','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Khushi Jain', 'khushi@gmail.com','4522','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ritik Sharma', 'ritik@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Patidar', 'rohit@gmail.com','5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Virat Sharma', 'virat@gmail.com','2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hitish Kumar', 'hitish@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Naveen Chaturvedi', 'naveen@gmail.com','5566','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Gauri Parashar', 'gauri@gmail.com','2236','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Farhan Khan', 'farhan@gmail.com','6692','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserTDone.UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserTDone.UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserTDone.UserEntry.TABLE_NAME + " where " +
                UserTDone.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserTDone.UserEntry.TABLE_NAME + " set " + UserTDone.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserTDone.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
