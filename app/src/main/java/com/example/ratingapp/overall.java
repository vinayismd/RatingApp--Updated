package com.example.ratingapp;

import java.util.ArrayList;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class overall extends Activity implements OnClickListener {

	RatingBar ratingbar;
	Button submit;
	TextView  main, lpeople;
	EditText etname;
	float value, voverall;
    SQLiteDatabase sql;
	TextView lv;
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.overall);

		ratingbar = (RatingBar) findViewById(R.id.ratingBar1);
		submit = (Button) findViewById(R.id.bsubmit);
		etname = (EditText) findViewById(R.id.etname);
        main = (TextView) findViewById(R.id.tvmain);
        lpeople = (TextView) findViewById(R.id.tvratedlist);
		

		Intent i = getIntent();

	   value = i.getFloatExtra("av", voverall);


		ratingbar.setRating(value / 2);

		submit.setOnClickListener(this);
        lpeople.setOnClickListener(this);
        main.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.bsubmit:
		
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "Average value:" + value,
					Toast.LENGTH_SHORT).show();

            SQLiteDatabase sq=openOrCreateDatabase("Rating",2,null);

            String tq="CREATE TABLE IF NOT EXIST people(name VARCHAR(20),rating VARCHAR(20);";
            try{
                sq.execSQL(tq);
               // Toast.makeText(this, "Table Created !!!",Toast.LENGTH_SHORT).show();
            }
            catch(Exception e)
            {

            }



            try{
             // String iq="insert into people values('\"+name+\"','\"+val+\"')";
                String val = Float.toString(value);
                String name = etname.getText().toString();
                String iq ="INSERT INTO `people` VALUES ('"+name+"' , '"+val+"')";
                sq.execSQL(iq);
                Toast.makeText(getApplicationContext() , "Inserted" , Toast.LENGTH_SHORT).show();

            }
            catch (Exception e) {
                Toast.makeText(this, ""+e,Toast.LENGTH_SHORT).show();
            }
			

		   break;
		
		case R.id.tvmain:
		{
			
			Intent i = new Intent(overall.this ,MainActivity.class);
			startActivity(i);
		} break;
			
		case R.id.tvratedlist:
		{
            Intent i = new Intent(overall.this ,RatedPeople.class);
            startActivity(i);

		} break;
		    
		
		}
		
	}
}


