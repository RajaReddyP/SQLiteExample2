package com.polamr.sqliteexample;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    SQLController sql;
    final String[] from = new String[] { SQLiteHelper._ID,
            SQLiteHelper.TODO_SUBJECT, SQLiteHelper.TODO_DESC };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sql = new SQLController(MainActivity.this);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sql.insert("first 11111 ", "second 1111", "third 4444");
            }
        });

        Cursor cursor = sql.fetch();
        if(cursor != null)
        LogUtils.show("count : "+cursor.getCount());

        ListView list = (ListView) findViewById(R.id.listView);
        //SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.layout, cursor, from,new int[] { R.id.textView, R.id.textView2 }, 0);
        MyAdapter adapter = new MyAdapter(this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        list.setAdapter(adapter);
    }
}
