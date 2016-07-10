package com.example.ratingapp;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class RatedPeople extends Activity {

    ListView lv;
    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rated_people);


        lv=(ListView) findViewById(R.id.lvpeople);

        SQLiteDatabase sq=openOrCreateDatabase("Rating",2,null);
        Cursor cs=sq.rawQuery("SELECT * FROM `people`",null);
        cs.moveToFirst();
        while(cs.moveToNext())
        {
            String ss=cs.getString(0);
            int sss=cs.getInt(1);
            String as=Integer.toString(sss);
            ss=ss+"\t"+as;
            al.add(ss);
        }
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(ad);
    }



}
