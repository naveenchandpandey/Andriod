package com.example.voteapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

public class Login extends Activity {
	String un,ps;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9;
	SQLiteDatabase db;
	Button b1;
	EditText u,p;
	TextView res;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		u=(EditText) findViewById(R.id.editText1);
		p=(EditText) findViewById(R.id.editText2);
		b1=(Button) findViewById(R.id.login);
		res=(TextView) findViewById(R.id.textView2);
		
		
		db=openOrCreateDatabase("votedatabase", Context.MODE_PRIVATE, null);
		try{
			db.execSQL("create table details(uid varchar(30) primary key,name varchar(30),uname varchar(30),upass varchar(10),age varchar(10),gndr varchar(10),status varchar(10),address varchar(30),assembly varchar(10),vote varchar(10));");
		
		Toast.makeText(this, "table created", Toast.LENGTH_LONG).show();
		}
		catch(Exception e){
		
		}
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				un=u.getText().toString();
				ps=p.getText().toString();
				
				Cursor c=db.rawQuery("select * from details where uname='"+un+"' and upass='"+ps+"'", null);
				if(c.moveToNext())
				{
					
					s1=c.getString(0);
					s2=c.getString(1);
					s3=c.getString(2);
					s4=c.getString(3);
					s5=c.getString(4);
					s6=c.getString(5);
					s7=c.getString(6);
					s8=c.getString(7);
					s9=c.getString(8);
					Toast.makeText(Login.this,"user"+" "+s1, Toast.LENGTH_LONG).show();
					Intent i=new Intent(Login.this,Home.class);
					
					i.putExtra("a", s1);
					i.putExtra("b", s2);
					i.putExtra("c", s3);
					i.putExtra("d", s4);
					i.putExtra("e", s5);
					i.putExtra("f", s6);
					i.putExtra("g", s7);
					i.putExtra("h", s8);
					i.putExtra("j", s9);
					startActivity(i);
				}
				else
				{
					res.setText("Invalid Username password");
					
				}
			}
		});
		
	}

	
}


