package com.example.tats.takephoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;

import android.widget.*;

import java.io.*;



public class photo extends AppCompatActivity {
ImageButton ross,rachel,joey,phoebe,chandler,monica;
//    TextView rosse,rachele,joeye,phoebee,chandlere,monicae;
    int selected=0;
    String score="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        rachel = (ImageButton) findViewById(R.id.imageButton);
        ross = (ImageButton) findViewById(R.id.imageButton2);
        monica = (ImageButton) findViewById(R.id.imageButton3);
        chandler = (ImageButton) findViewById(R.id.imageButton4);
        phoebe = (ImageButton) findViewById(R.id.imageButton5);
        joey = (ImageButton) findViewById(R.id.imageButton6);
        //text=(TextView)findViewById(R.id.textView);
//        rachele=(TextView)findViewById(R.id.textView2);
//        rosse=(TextView)findViewById(R.id.textView3);
//        monicae=(TextView)findViewById(R.id.textView4);
//        chandlere=(TextView)findViewById(R.id.textView5);
//        phoebee=(TextView)findViewById(R.id.textView6);
//        joeye=(TextView)findViewById(R.id.textView7);
        //rachele=(TextView)findViewById(R.id.textView2);

       rachel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
               Intent intent = new Intent(photo.this, Main2Activity.class);
               intent.putExtra("tats", R.drawable.downloa);
//                    selected=1;
                        startActivity(intent);

//              rating(selected);
           }
        });
        ross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(photo.this, Main2Activity.class);
                intent.putExtra("image", R.drawable.ross);
               // selected=2;
               // intent.putExtra("selected", selected);
                startActivity(intent);
                //rating(selected);
            }
        });
        monica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(photo.this, Main2Activity.class);
                intent.putExtra("image", R.drawable.image);

                startActivity(intent);

            }
        });
        chandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(photo.this, Main2Activity.class);
                intent.putExtra("image", R.drawable.im);


                startActivity(intent);

            }
        });
        phoebe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(photo.this, Main2Activity.class);
                intent.putExtra("image", R.drawable.imag);

                startActivity(intent);

            }
        });
        joey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(photo.this, Main2Activity.class);
                intent.putExtra("image", R.drawable.ima);

                startActivity(intent);

            }
        });
    }

//    public void rating(int r) {
//       Bundle extras =getIntent().getExtras();
//       if(extras!=null){
//            selected = extras.getInt("select");
//           score = extras.getString("score");
//           switch (selected){
//               case 1:rachele.setText("Rachel Has"+score); break;
//               case 2:rosse.setText("Ross Has" + score); break;
//               case 3:monicae.setText("Monica Has"+ score); break;
//               case 4:chandlere.setText("Chandler Has"+score); break;
//             case 5:phoebee.setText("Phoebe Has"+score); break;
//             case 6: joeye.setText("Phoebe Has"+score);break;
//           }
//        }
//        else{}
//    }


                }

