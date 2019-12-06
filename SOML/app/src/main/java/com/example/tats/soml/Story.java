package com.example.tats.soml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.Intent;
public class Story extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        btn=(Button)findViewById(R.id.button);
    }
    public void Start(View view){
        Intent i = new Intent(Story.this,Words.class);
         startActivity(i);

    }
}
