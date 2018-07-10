package com.udacity.gradle.jokeviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private final String JOKE_TAG = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = findViewById(R.id.joke_tv);

        Intent jokeIntent = getIntent();

        if (jokeIntent.hasExtra(JOKE_TAG)) {
            String joke = jokeIntent.getStringExtra(JOKE_TAG);
            jokeTextView.setText(joke);
        } else {
            jokeTextView.setText("No joke to display");
        }



    }
}
