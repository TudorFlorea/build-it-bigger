package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {

    MyApi myApi = null;

    private Context mContext;

    public EndpointAsyncTask() {
        //mContext= context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Context... params) {

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://joke-teller-209814.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    })
                    ;
            myApi = builder.build();
        }

        mContext = params[0];

        try {
            return myApi.sayHi().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

//    @Override
//    protected void onPostExecute(String s) {
//        //Toast.makeText(mContext, s, Toast.LENGTH_LONG).show();
//    }
}