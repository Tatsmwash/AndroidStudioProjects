package com.example.tats.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class TitleScreen extends AppCompatActivity implements View.OnClickListener {

    Button startButton;
    Spinner storySpinner;
    int selectedStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(this);

        storySpinner = (Spinner) findViewById(R.id.story_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.story_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        storySpinner.setAdapter(adapter);
        storySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedStory = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    /* When the button on the title screen is pressed, the game activity is created and shown. */
    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(getApplicationContext(),InputScreen.class);
        i.putExtra("selected_story", selectedStory);
        startActivity(i);
    }
}