package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.andev.tudor.javajoker.JavaJoker;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.jokeviews.JokeActivity;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private final String JOKE_TAG = "joke";

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new EndpointAsyncTask(){
            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        }.execute(MainActivity.this);

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

    public void tellJoke(View view) {
        JavaJoker javaJoker = new JavaJoker();

        Intent i = new Intent(this, JokeActivity.class);
        i.putExtra(JOKE_TAG, javaJoker.getJoke());

        startActivity(i);

        //Toast.makeText(this, javaJoker.getJoke(), Toast.LENGTH_SHORT).show();
    }

//    class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
//
//        MyApi myApi = null;
//
//        private Context mContext;
//
//        public EndpointAsyncTask() {
//            //mContext= context;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//        }
//
//        @Override
//        protected String doInBackground(Context... params) {
//
//            if (myApi == null) {
//                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        .setRootUrl("https://joke-teller-209814.appspot.com/_ah/api/")
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
//                                request.setDisableGZipContent(true);
//                            }
//                        })
//                        ;
//                myApi = builder.build();
//            }
//
//            mContext = params[0];
//
//            try {
//                return myApi.sayHi().execute().getData();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return e.getMessage();
//            }
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            Toast.makeText(mContext, s, Toast.LENGTH_LONG).show();
//        }
//    }


}
