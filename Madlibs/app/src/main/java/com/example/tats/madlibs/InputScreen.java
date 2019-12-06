package com.example.tats.madlibs;


import android.content.Intent;
import android.content.SharedPreferences;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;

import java.util.Random;
import java.util.Set;


public class InputScreen extends AppCompatActivity {

    final static int SIMPLE = R.raw.madlib0_simple;
    final static int TARZAN = R.raw.madlib1_tarzan;
    final static int UNIVERSITY = R.raw.madlib2_university;
    final static int CLOTHES = R.raw.madlib3_clothes;
    final static int DANCE = R.raw.madlib4_dance;

    public static final String PLACEHOLDER_LIST_FILE = "placeholder_file";
    public static final String STORY_NUMBER_FILE = "story_number_file";


    Button submitButton;
    Story story;
    EditText placeholder;
    TextView wordsLeftText;
    Set<String> placeholderList;
    int storyIndex = 0;
    int Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);
        //getRandomStoryIndex();

        // Restore preferences
        SharedPreferences placeholderSettings = getSharedPreferences(PLACEHOLDER_LIST_FILE, 0);
        placeholderList = placeholderSettings.getStringSet("placeholders", null);
        if(placeholderList == null)
        {
            placeholderList = new HashSet<>();
        }

        SharedPreferences storyNumberSettings = getSharedPreferences(STORY_NUMBER_FILE, 0);
        //gte vLUE FROM INTENT INT I="selected_story" ...AFTER STORYINDEX=I;
        storyIndex = storyNumberSettings.getInt("story_number", 404);
        storyIndex = 404; // Used to test spinner

        if(storyIndex == 404) {
            storyIndex = getIntent().getIntExtra("selected_story", 404);
        }

        InputStream is;
        is = this.getResources().openRawResource(getStoryNumber(storyIndex));
        story = new Story(is);

        for(String currentPlaceholder : placeholderList)
        {
            story.fillInPlaceholder(currentPlaceholder);
        }

        wordsLeftText = (TextView) findViewById(R.id.words_left);
        Count = story.getPlaceholderRemainingCount();
        wordsLeftText.setText("Words left: " + Integer.toString(Count));

        placeholder = (EditText)findViewById(R.id.placeholder_field);
        String currentPlaceholder = story.getNextPlaceholder();
        placeholder.setHint("submit a " + currentPlaceholder);



        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placeholderUserText = placeholder.getText().toString();
                if(!placeholderUserText.equals("") && !placeholderList.contains(placeholderUserText)) {
                    story.fillInPlaceholder(placeholderUserText);
                    placeholderList.add(placeholderUserText);
                    placeholder.setText("");
                    Count = story.getPlaceholderRemainingCount();
                    wordsLeftText.setText("Words left: " + Integer.toString(Count));

                    String currentPlaceholder = story.getNextPlaceholder();
                    placeholder.setHint("submit an " + currentPlaceholder);

                    if(Count == 0) {
                        placeholderList.clear();
                        storyIndex = 404;
                        Intent i = new Intent(getApplicationContext(), StoryScreen.class);
                        i.putExtra("finished_story", story.toString());
                        startActivity(i);
                    }
                } else {
                    Toast errorEmptyField = Toast.makeText(getApplicationContext(), "The field is empty or you already entered this, try again.",
                            Toast.LENGTH_LONG);
                    errorEmptyField.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                    errorEmptyField.show();
                }
            }
        });


    }

    protected void onStop() {
        super.onStop();

        SharedPreferences placeholderSettings = getSharedPreferences(PLACEHOLDER_LIST_FILE, 0);
        SharedPreferences.Editor editor1 = placeholderSettings.edit();
        editor1.putStringSet("placeholders", placeholderList);
        editor1.apply();

        SharedPreferences storyNumberSettings = getSharedPreferences(STORY_NUMBER_FILE, 0);
        SharedPreferences.Editor editor2 = storyNumberSettings.edit();
        editor2.putInt("story_number", storyIndex);
        editor2.apply();
    }


    // Not useful anymore with the spinner
    private int getRandomStoryIndex() {
        File storyDirectory = new File("../../res/");
        final int directorySize = storyDirectory.listFiles().length;
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(directorySize);
    }

    private int getStoryNumber(int storyIndex) {
        switch (storyIndex) {
            case 0:
                return SIMPLE;
            case 1:
                return TARZAN;
            case 2:
                return UNIVERSITY;
            case 3:
                return CLOTHES;
            case 4:
                return DANCE;
            default:
                return 404;
        }
    }
}