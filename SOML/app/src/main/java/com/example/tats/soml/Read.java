package com.example.tats.soml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.*;

import android.content.*;

public class Read extends AppCompatActivity {
TextView text;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

    text= (TextView)findViewById(R.id.textView5);
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.tarzan));
            String allText = "";
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                allText += line;

            }
            text.setText(allText);
            scan.close();

    }


}
