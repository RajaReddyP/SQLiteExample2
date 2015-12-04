package com.polamr.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Rajareddy on 04/12/15.
 */
public class SQLController {
    private SQLiteHelper dbHelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLController(Context c) {
        ourcontext = c;
        dbHelper = new SQLiteHelper(ourcontext);
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc, String thn) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(SQLiteHelper.TODO_SUBJECT, name);
        contentValue.put(SQLiteHelper.TODO_DESC, desc);
        contentValue.put(SQLiteHelper.TODO_SUMMARY, thn);
        database.insert(SQLiteHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { SQLiteHelper._ID, SQLiteHelper.TODO_SUBJECT,
                SQLiteHelper.TODO_DESC, SQLiteHelper.TODO_SUMMARY };
        Cursor cursor = database.query(SQLiteHelper.TABLE_NAME, columns, null,
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.TODO_SUBJECT, name);
        contentValues.put(SQLiteHelper.TODO_DESC, desc);
        int i = database.update(SQLiteHelper.TABLE_NAME, contentValues,
                SQLiteHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(SQLiteHelper.TABLE_NAME, SQLiteHelper._ID + "=" + _id, null);
    }
}
