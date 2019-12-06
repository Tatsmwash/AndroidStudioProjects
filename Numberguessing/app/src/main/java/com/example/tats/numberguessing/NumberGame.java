package com.example.tats.numberguessing;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.*;

import java.util.Random;

public class NumberGame extends AppCompatActivity {

    static int count =0,num1=0,num2=0;
    public TextView point;

    public Button myButton2,myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);


    }

    public void random(){
        Random random =new Random();
        num1=random.nextInt(10000)+1;
        num2=random.nextInt(10000)+1;
    }

    public void clickMe(View view){
        int buttonclicked = view.getId();

        if (buttonclicked == R.id.button )
            if (num1 > num2){
                count++; point.setText(count);
                Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show();
                count--; point.setText(count);
            }
        if (buttonclicked ==R.id.button2 )
            if (num2 > num1){
                Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show();
            }
        point = (TextView) findViewById(R.id.textView3);
       // point.setText("Point:" + count );
        //generate number\
        random();
        myButton=(Button)findViewById(R.id.button);
        myButton.setText(num1);
        myButton2=(Button)findViewById(R.id.button2);
        myButton2.setText(num2);
    }
}
