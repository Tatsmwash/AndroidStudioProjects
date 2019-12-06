package com.example.tats.spinner;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Tnmt extends Activity implements OnItemSelectedListener{
    private TypedArray imgs;
    private ImageView image;
    private Spinner spinners;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tnmt);
        imgs = getResources().obtainTypedArray(R.array.pics);
        // Spinner element
         spinners = (Spinner) findViewById(R.id.spinner);
        image = (ImageView) findViewById(R.id.imageView);
        // Spinner click listener
        spinners.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Image1");
        categories.add("Image2");
        categories.add("Image3");
        categories.add("Image4");
        categories.add("Image5");
        categories.add("Image6");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinners.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        image.setImageResource(imgs.getResourceId(spinners.getSelectedItemPosition(), 0));
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), " " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}