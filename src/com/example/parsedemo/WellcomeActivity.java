package com.example.parsedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class WellcomeActivity extends Activity {

	TextView txtUser;
	Button logout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wellcome);

		ParseUser currentUser = ParseUser.getCurrentUser();

		String struser = currentUser.getUsername().toString();

		txtUser = (TextView) findViewById(R.id.txtuser);
		txtUser.setText("you are login in as" + struser);

		logout = (Button) findViewById(R.id.logout);
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ParseUser.logOut();
				finish();
			}
		});
	}

}
