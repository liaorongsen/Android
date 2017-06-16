package com.lrs.viewandutil.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wb-lrs192703 on 2017/6/15.
 */

public class SQLiteDateBaseHelper extends SQLiteOpenHelper {

    private static SQLiteDateBaseHelper mHelper;
    private static final String TABLE_STEP_NAME = "step_count_per_day";

    private static final String db_name = "Test";

    public static synchronized SQLiteDateBaseHelper getInstance(Context appContext) {
        if (mHelper == null) {
            mHelper = new SQLiteDateBaseHelper(appContext);
        }
        return mHelper;
    }


    private SQLiteDateBaseHelper(Context context) {
        super(context, db_name, null, 1);
    }

    private static final String SQL_CREATE_TABLE_STEP = "CREATE TABLE " + TABLE_STEP_NAME + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "count VARCHAR, " +
            "date VARCHAR" +
            ")";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_STEP);//建表
    }


    public boolean add(StepData d) {
        SQLiteDatabase mSQLiteDatabase = mHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("count", d.getCount());
        cv.put("date", d.getDate());
        return mSQLiteDatabase.insert(TABLE_STEP_NAME, null, cv) != -1;
    }


    private static final String SQL_QUERY_ALL = "";

    public boolean queryAll() {
        SQLiteDatabase mSQLiteDatabase = mHelper.getWritableDatabase();
        //  mSQLiteDatabase.query()
        return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

