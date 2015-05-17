package com.example.parsedemo;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
			Intent i = new Intent(MainActivity.this, LoginSingupActivity.class);
			startActivity(i);
			finish();
		} else {
			ParseUser currentUser = ParseUser.getCurrentUser();
			if (currentUser != null) {
				Intent i = new Intent(MainActivity.this, WellcomeActivity.class);
				startActivity(i);
				finish();
			} else {
				Intent i = new Intent(MainActivity.this,
						LoginSingupActivity.class);
				startActivity(i);
				finish();
			}
		}
	}

}
