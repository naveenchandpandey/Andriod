package com.example.voteapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity{
	SQLiteDatabase db;
	public final String stau="1";
	String s1,s2;
	String[] s=new String[10];
	//String[] p=new String[10];
	TextView ageh,nameh,genderh,uidh,statush,addressh,assemblyh,votehh;
	Button voteh;
	@Override
	protected void onCreate(Bundle f) {
		// TODO Auto-generated method stub
		super.onCreate(f);
		setContentView(R.layout.home);
		ageh=(TextView) findViewById(R.id.ageh);
		nameh=(TextView) findViewById(R.id.nameh);
		genderh=(TextView) findViewById(R.id.genderh);
		uidh=(TextView) findViewById(R.id.uidh);
		statush=(TextView) findViewById(R.id.statush);
		addressh=(TextView) findViewById(R.id.addressh);
		assemblyh=(TextView) findViewById(R.id.assemblyh);
		votehh=(TextView) findViewById(R.id.votehhh);
		voteh=(Button) findViewById(R.id.voteh);
		db=openOrCreateDatabase("votedatabase", Context.MODE_PRIVATE, null);
		
		Intent i=getIntent();
		f=i.getExtras();
		s[0]=f.getString("a");
		s[1]=f.getString("b");
		s[2]=f.getString("c");
		s[3]=f.getString("d");
		s[4]=f.getString("e");
		s[5]=f.getString("f");
		s[6]=f.getString("g");
		s[7]=f.getString("h");
		s[8]=f.getString("j");
		
		uidh.setText(s[0]);
		nameh.setText(s[1]);
		ageh.setText(s[4]);
		genderh.setText(s[5]);
		
		addressh.setText(s[7]);
		assemblyh.setText(s[8]);
		Cursor c=db.rawQuery("select status,vote from details where uid='"+s[0]+"'", null);
		if(c.moveToNext())
		{
			
			s1=c.getString(0);
			s2=c.getString(1);
			
		}
		statush.setText(s1);
		votehh.setText(s2);
		if(Integer.parseInt(s1)==1){
			voteh.setClickable(false);
		}
			

	}
	public void votehh(View v) {

		Intent i=new Intent(this,Vote.class);

		i.putExtra("key", s[0]);
		startActivity(i);
	}

}
