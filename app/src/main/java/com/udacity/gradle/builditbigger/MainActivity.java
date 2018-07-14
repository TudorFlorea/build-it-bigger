package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.jokeviews.JokeActivity;



public class MainActivity extends AppCompatActivity {

    private Button mJokeButton;
    private ProgressBar mProgressBar;

    private final String JOKE_TAG = "joke";

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mJokeButton = findViewById(R.id.tell_joke_btn);
        mProgressBar = findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    new EndpointAsyncTask(){

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            mProgressBar.setVisibility(View.VISIBLE);
                            mJokeButton.setVisibility(View.GONE);
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(MainActivity.this, JokeActivity.class);
                            i.putExtra(JOKE_TAG, s);

                            startActivity(i);

                            mProgressBar.setVisibility(View.GONE);
                            mJokeButton.setVisibility(View.VISIBLE);

                        }
                    }.execute(MainActivity.this);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
