package com.example.tats.potatohead;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.*;

public class Head extends AppCompatActivity {
    ImageView body,hat,shoes,ears,arms,eyebrows,eyes,glasses,noses,mustache,mouth;
    CheckBox  hats,ear,armsz,shoe,eyebrow,eye,glass,nose,mustach,mouths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        body = (ImageView) findViewById(R.id.imageView);
        shoes=(ImageView)findViewById(R.id.imageView11);
         hat=(ImageView)findViewById(R.id.imageView2);
         ears=(ImageView)findViewById(R.id.imageView3);
        arms=(ImageView)findViewById(R.id.imageView4);
         eyebrows=(ImageView)findViewById(R.id.imageView5);
         eyes=(ImageView)findViewById(R.id.imageView6);
         glasses=(ImageView)findViewById(R.id.imageView7);
         noses=(ImageView)findViewById(R.id.imageView8);
         mustache=(ImageView)findViewById(R.id.imageView9);
         mouth=(ImageView)findViewById(R.id.imageView10);

        hats=(CheckBox)findViewById(R.id.checkBox);
         ear=(CheckBox)findViewById(R.id.checkBox2);
        armsz=(CheckBox)findViewById(R.id.checkBox3);
         eyebrow=(CheckBox)findViewById(R.id.checkBox4);
          eye=(CheckBox)findViewById(R.id.checkBox5);
         glass=(CheckBox)findViewById(R.id.checkBox6);
          nose=(CheckBox)findViewById(R.id.checkBox7);
         mustach=(CheckBox)findViewById(R.id.checkBox8);
          mouths=(CheckBox)findViewById(R.id.checkBox9);
         shoe=(CheckBox)findViewById(R.id.checkBox10);



    }
//    ImageView    body = (ImageView) findViewById(R.id.imageView);
//
//    ImageView shoes=(ImageView)findViewById(R.id.imageView11);
//     hat=(ImageView)findViewById(R.id.imageView2);
//    ImageView ears=(ImageView)findViewById(R.id.imageView3);
//    ImageView arms=(ImageView)findViewById(R.id.imageView4);
//    ImageView eyebrows=(ImageView)findViewById(R.id.imageView5);
//    ImageView eyes=(ImageView)findViewById(R.id.imageView6);
//    ImageView glasses=(ImageView)findViewById(R.id.imageView7);
//    ImageView noses=(ImageView)findViewById(R.id.imageView8);
//    ImageView mustache=(ImageView)findViewById(R.id.imageView9);
//    ImageView mouth=(ImageView)findViewById(R.id.imageView10);
//
//   CheckBox  hats=(CheckBox)findViewById(R.id.checkBox);
//   CheckBox ear=(CheckBox)findViewById(R.id.checkBox2);
//    CheckBox  armsz=(CheckBox)findViewById(R.id.checkBox3);
//    CheckBox eyebrow=(CheckBox)findViewById(R.id.checkBox4);
//    CheckBox  eye=(CheckBox)findViewById(R.id.checkBox5);
//    CheckBox glass=(CheckBox)findViewById(R.id.checkBox6);
//    CheckBox  nose=(CheckBox)findViewById(R.id.checkBox7);
//    CheckBox mustach=(CheckBox)findViewById(R.id.checkBox8);
//    CheckBox  mouths=(CheckBox)findViewById(R.id.checkBox9);
//    CheckBox shoe=(CheckBox)findViewById(R.id.checkBox10);

    public void onClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        //if (checked == R.id.checkBox )
        switch(view.getId()) {
            case R.id.checkBox:
                if (checked) {
                   // hats.setChecked(false);
                    hat.setVisibility(View.VISIBLE);
                    //hat.setImageResource(R.drawable.hat);
                } else {
                    hat.setVisibility(View.INVISIBLE);//hats.setChecked(true);

                }
                break;

                case R.id.checkBox2:

                if (checked) {
                   // eye.setChecked(false);
                    eyes.setVisibility(View.VISIBLE);
                    //ears.setImageResource(R.drawable.ears);
                } else {
                    //eye.setChecked(true);
                    eyes.setVisibility(View.INVISIBLE);

                }
            break;
            case R.id.checkBox3:
                if (checked) {

                    eyebrows.setVisibility(View.VISIBLE);
                } else {
                    eyebrows.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox4:

                if (checked) {
                    glasses.setVisibility(View.VISIBLE);
                } else {
                    glasses.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox5:
                if (checked) {
                    noses.setVisibility(View.VISIBLE);
                } else {
                    noses.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox6:
                if (checked) {
                    mouth.setVisibility(View.VISIBLE);
                } else {
                    mouth.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox7:
                if (checked) {
                    mustache.setVisibility(View.VISIBLE);
                } else {
                    mustache.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox8:
                if (checked) {
                    ears.setVisibility(View.VISIBLE);
                } else {
                    ears.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox9:
                if (checked) {
                    arms.setVisibility(View.VISIBLE);
                } else {
                    arms.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox10:
                if (checked) {
                    shoes.setVisibility(View.VISIBLE);
                } else {
                    shoes.setVisibility(View.INVISIBLE);
                }break;

        }
    }


    }