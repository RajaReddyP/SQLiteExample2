package com.polamr.sqliteexample;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Rajareddy on 04/12/15.
 */
public class MyAdapter extends CursorAdapter {

    public MyAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.TODO_SUBJECT)));

        TextView tv2 = (TextView) view.findViewById(R.id.textView2);
        tv2.setText(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.TODO_DESC)));

        TextView tv3 = (TextView) view.findViewById(R.id.textView3);
        tv3.setText(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.TODO_SUMMARY)));
    }
}
