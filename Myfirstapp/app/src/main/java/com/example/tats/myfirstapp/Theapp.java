package com.example.tats.myfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.webkit.*;
import android.app.*;
import android.graphics.*;

public class Theapp extends AppCompatActivity {
    //Button b1;
    //EditText ed1,ed2;
    // TextView tx1;
    // int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theapp);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        Button b1 = (Button) findViewById(R.id.button);
        //EditText ed1=(EditText)findViewById(R.id.username);
        //EditText ed2=(EditText)findViewById(R.id.password);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
    }


    public void login(View views) {
        Button b1 = (Button) findViewById(R.id.button);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            int counter = 3;
            counter--;
            if (counter == 0) {
                b1.setEnabled(false);
            }
        }
    }
}


