package com.example.tats.guessing;

import android.support.v7.app.AppCompatActivity;
//import android.support.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.util.Random;
import android.media.MediaPlayer;

public class NumberGuessing extends AppCompatActivity {
    MediaPlayer mp;
 static int score =0,num1=0,num2=0;
    public TextView point;

    public Button myButton2,myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guessing);
        myButton=(Button)findViewById(R.id.button);

        myButton2=(Button)findViewById(R.id.button2);
        point = (TextView) findViewById(R.id.textView4);
    }

    public void random(){
        Random random =new Random();
        num1=random.nextInt(100)+1;
        num2=random.nextInt(100)+1;

     myButton=(Button)findViewById(R.id.button);
       myButton.setText("Points :" +num1);
       myButton2=(Button)findViewById(R.id.button2);
      myButton2.setText("Points :" +num2);

    }

    public void clickMe(View views){
        int buttonclicked = views.getId();

        if (buttonclicked == R.id.button )
          if (num1 > num2){

              Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
              ++score;
              point.setText("Points :" + score);
          }else{
              Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show();
              --score;
              point.setText("Points :" +score);
           }
        random();
        myButton=(Button)findViewById(R.id.button);
        myButton.setText("" + num1);

       mp = MediaPlayer.create(this, R.raw.door);
        mp.start();

        myButton2=(Button)findViewById(R.id.button2);
        myButton2.setText("" +num2);
        point = (TextView) findViewById(R.id.textView4);
        point.setText("Points :" +score );
     if (buttonclicked == R.id.button2 )
         if (num2 > num1){
             Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
             ++score;
             point.setText("Points :"+score);
          }else{
              Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show();
             --score;
             point.setText("Points :"+score);
          }

        //generate number\
        random();
        myButton=(Button)findViewById(R.id.button);
        myButton.setText("" +num1);
        myButton2=(Button)findViewById(R.id.button2);
        myButton2.setText("" + num2);
        point = (TextView) findViewById(R.id.textView4);
        point.setText("Points :" +score );
   }
//public void button2_click (View view){
//    myButton = (Button) findViewById(R.id.button);
//    btn2 = (Button)findViewById(R.id.button2);
//
//    TextView point = (TextView) findViewById(R.id.textView4);
//    point.setText("Point:" + count );
//    int buttonclicked = view.getId(),num1=0,num2=0;
//
//    if (buttonclicked == R.id.button )
//        if (num1 > num2){
//            count++; point.setText(count);
//            Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show();
//            count--; point.setText(count);
//        }
//    if (buttonclicked ==R.id.button2 )
//        if (num2 > num1){
//            Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show();
//        }
//}


}

