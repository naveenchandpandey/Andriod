package com.example.voteapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void already(View v) {
		Intent i=new Intent(this,Login.class);
		startActivity(i);
	}
	public void newone(View v) {
		Intent i=new Intent(this,Register.class);
		startActivity(i);
	}

}
