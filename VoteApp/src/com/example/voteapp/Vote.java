package com.example.voteapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Vote extends Activity{
	
	SQLiteDatabase db;
	Button sp,bsp,bjp,cpm,ncp,congress;
	String votev="",uidv;
	
	@Override
	protected void onCreate(Bundle f) {
		// TODO Auto-generated method stub
		super.onCreate(f);
		setContentView(R.layout.vote);
		sp=(Button) findViewById(R.id.spv);
		bsp=(Button) findViewById(R.id.bspv);
		bjp=(Button) findViewById(R.id.bjpv);
		cpm=(Button) findViewById(R.id.cpmv);
		ncp=(Button) findViewById(R.id.ncpv);
		congress=(Button) findViewById(R.id.congressv);
		Intent i=getIntent();
		f=i.getExtras();
		uidv=f.getString("key");
		db=openOrCreateDatabase("votedatabase", Context.MODE_PRIVATE, null);
		
		sp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				votev="sp";
				Toast.makeText(Vote.this, "Thanks for voting"+" "+votev, Toast.LENGTH_LONG).show();
				clickfalse();
				update();
				intention();

			}
		});
		bsp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				votev="bsp";
				Toast.makeText(Vote.this, "Thanks for voting"+" "+votev, Toast.LENGTH_LONG).show();
				clickfalse();
				update();
				intention();
				
			}
		});
		bjp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				votev="bjp";
				Toast.makeText(Vote.this, "Thanks for voting"+" "+votev, Toast.LENGTH_LONG).show();
				clickfalse();
				update();
				intention();
			}
		});
		cpm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				votev="cpm";
				Toast.makeText(Vote.this, "Thanks for voting"+" "+votev, Toast.LENGTH_LONG).show();
				clickfalse();
				update();
				intention();
			}
		});
		ncp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				votev="ncp";
				Toast.makeText(Vote.this, "Thanks for voting"+" "+votev, Toast.LENGTH_LONG).show();
				clickfalse();
				update();
				intention();
			}
		});
		congress.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				votev="congress";
				Toast.makeText(Vote.this, "Thanks for voting"+" "+votev, Toast.LENGTH_LONG).show();
				clickfalse();
				update();
				intention();
				
			}
		});
		
		
	
		
			
		
		
		
		
	}
	public void clickfalse() {
		sp.setClickable(false);
		bsp.setClickable(false);
		bjp.setClickable(false);
		cpm.setClickable(false);
		ncp.setClickable(false);
		congress.setClickable(false);
	}
	public void update() {
		db.execSQL("update details set status='"+1+"' where uid='"+uidv+"'");
		db.execSQL("update details set vote='"+votev+"' where uid='"+uidv+"'");
	}
	public void intention() {
		Intent gh=new Intent(Vote.this,Login.class);
				startActivity(gh);
	}

}
