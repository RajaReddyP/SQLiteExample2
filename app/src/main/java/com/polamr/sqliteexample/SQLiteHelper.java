package com.polamr.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rajareddy on 04/12/15.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    //name
    public static final String TABLE_NAME = "RAJAS";

    // table columns
    public static final String _ID = "_id";
    public static final String TODO_SUBJECT = "subject";
    public static final String TODO_DESC = "description";
    public static final String TODO_SUMMARY = "summary";
    public static final String TODO_DELETE = "delete";

    // Database Information
    static final String DB_NAME = "JAVATECHIG_TODOS.DB";

    // database version
    static final int DB_VERSION = 4;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TODO_SUBJECT + " TEXT NOT NULL, "
            + TODO_DELETE + "INTEGER"
            + TODO_DESC + " TEXT);";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogUtils.show("onUpgrade : oldVersion : "+oldVersion+" newVersion : "+newVersion);
        if(oldVersion < newVersion) {
            db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD "+TODO_SUMMARY +" new_column TEXT");
        }
    }
}
