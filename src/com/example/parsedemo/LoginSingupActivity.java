package com.example.parsedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginSingupActivity extends Activity {

	Button loginButton, signupButton;

	String usernametxt, passwordtxt;
	EditText password, username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_singup);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);

		loginButton = (Button) findViewById(R.id.login);
		signupButton = (Button) findViewById(R.id.signup);

		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				usernametxt = username.getText().toString();
				passwordtxt = password.getText().toString();

				ParseUser.logInInBackground(usernametxt, passwordtxt,
						new LogInCallback() {

							@Override
							public void done(ParseUser user, ParseException e) {
								if (user != null) {
									Intent intent = new Intent(
											LoginSingupActivity.this,
											WellcomeActivity.class);
									startActivity(intent);
									finish();
								} else {
									Toast.makeText(
											getApplicationContext(),
											"this user doesn't exist, please signup!	",
											Toast.LENGTH_LONG).show();
								}
							}
						});
			}
		});

		signupButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				usernametxt = username.getText().toString();
				passwordtxt = password.getText().toString();

				if (usernametxt.equals("") && passwordtxt.equals("")) {
					Toast.makeText(getApplicationContext(),
							"please complete the sign up form ",
							Toast.LENGTH_LONG).show();
				} else {
					ParseUser user = new ParseUser();
					user.setUsername(usernametxt);
					user.setPassword(passwordtxt);
					user.signUpInBackground(new SignUpCallback() {

						@Override
						public void done(ParseException e) {
							if (e == null) {
								Toast.makeText(getApplicationContext(),
										"sucessfully sign up!",
										Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(getApplicationContext(),
										"Sign up error", Toast.LENGTH_LONG)
										.show();
							}
						}
					});
				}
			}
		});
	}

}
