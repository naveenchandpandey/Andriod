package com.example.voteapp;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends Activity{
	SQLiteDatabase db;
	Button b;
	
	EditText n,u,p,t,add,assem;
	RadioGroup rg;
	String gndr="male";
	String token,uid,un;
	Random rand=new Random();
	int a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		b=(Button) findViewById(R.id.reg);
		n=(EditText) findViewById(R.id.nme);
		u=(EditText) findViewById(R.id.uname);
		p=(EditText) findViewById(R.id.pass);
		t=(EditText) findViewById(R.id.age);
		add=(EditText) findViewById(R.id.addl);
		assem=(EditText) findViewById(R.id.asembl);
		rg=(RadioGroup) findViewById(R.id.radioGroup1);
		
		a=rand.nextInt();
		un=u.getText().toString();
		uid=un+a;
		db=openOrCreateDatabase("votedatabase", Context.MODE_PRIVATE, null);
		try{
			db.execSQL("create table details(uid varchar(30) primary key,name varchar(30),uname varchar(30),upass varchar(10),age varchar(10),gndr varchar(10),status varchar(10),address varchar(30),assembly varchar(10),vote varchar(10));");
		Toast.makeText(this, "table created", Toast.LENGTH_LONG).show();
		}
		catch(Exception e){
		}
		
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				
				if(arg1==R.id.Male)
					gndr="male";
				else
					gndr="female";
			}
		});
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String nm=n.getText().toString();
				String unm=u.getText().toString();
				String ps=p.getText().toString();
				String age=t.getText().toString();
				String addre=add.getText().toString();
				String assemb=assem.getText().toString();
				String vote="No One";
				String sta="0";
				
				db.execSQL("insert into details values('"+uid+"','"+nm+"','"+unm+"','"+ps+"','"+age+"','"+gndr+"','"+sta+"','"+addre+"','"+assemb+"','"+vote+"')");
				Toast.makeText(Register.this, "record inserted", Toast.LENGTH_LONG).show();
				Intent i=new Intent(Register.this,Login.class);
				startActivity(i);
			}
		});
	}

}
