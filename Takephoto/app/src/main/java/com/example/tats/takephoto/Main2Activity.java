package com.example.tats.takephoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.widget.RatingBar.*;
import android.content.DialogInterface.*;
import android.view.*;
import java.util.*;
public class Main2Activity extends AppCompatActivity  {
    ImageView imageView;
    private RatingBar ratingBar;
    private Button btnSubmit;
    String rate;
//    String[] mTestArray;
    TextView textView;
//    private int position;
//private ListView list;
     //String[] names_1 = {"McDonald's", "Subway", "Pizza Hut", "Burger King"};
  //  String[] img_1   = {"mcd", "mcd", "mcd", "mcd"};
   // private Activity context;
 //String[] players;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addListenerOnRatingBar();

            imageView=(ImageView) findViewById(R.id.imageView);

            int resourceId = getIntent().getIntExtra("tats", R.drawable.downs);

            imageView.setImageResource(resourceId);


        }


    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,boolean from) {rate=String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), rate, Toast.LENGTH_LONG).show();

            }
        });}




           public void onClick(View v) {
               Intent intent = new Intent(Main2Activity.this, photo.class);
              // intent.putExtra("score",String.valueOf(ratingBar.getRating()));
               Toast.makeText(getApplicationContext(),"You rated them: "+ rate, Toast.LENGTH_LONG).show();
               //Toast.makeText(getApplicationContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
               startActivity(intent);
           }


}
