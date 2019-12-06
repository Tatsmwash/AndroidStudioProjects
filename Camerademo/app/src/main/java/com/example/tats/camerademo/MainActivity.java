package com.example.tats.camerademo;
import java.io.File;
import java.lang.*;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.*;
public class MainActivity extends AppCompatActivity {
    private String text;
    private String text2;
    //private Image img;
private String  img;
    private File f;
    TextView textView;
    TextView textView1;
    ImageView previewThumbnail;
    Uri s;
    Bitmap bitmap;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       text = getIntent().getStringExtra(Cam.EXTRA_NAME);
        text2= getIntent().getStringExtra(Cam.EXTRA_EMAIL);


        textView = (TextView)findViewById(R.id.textView);
        textView1 = (TextView)findViewById(R.id.textView1);

        textView.setText("Name: " + text );
        textView1.setText( " Number: " + text2);
        imageView=(ImageView)findViewById(R.id.imageView);
        int resourceId = getIntent().getIntExtra("USE_A_CONSTANT_HERE_AS_KEY",R.drawable.downs);

       imageView.setImageResource(resourceId);
    }
}
