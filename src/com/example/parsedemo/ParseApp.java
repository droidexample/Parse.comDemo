package com.example.parsedemo;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

import android.app.Application;

public class ParseApp extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, "hfwrxmtjs6mkPIEPsbLE1WgNZG4suPrLyWpi2Xmh",
				"DxZO2KhltO7mQ6mAgMFS5tSV0C4HdEQM53NDZWCO");
		ParseUser.enableAutomaticUser();
		ParseACL defAcl = new ParseACL();

		defAcl.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defAcl, true);
	}
}
