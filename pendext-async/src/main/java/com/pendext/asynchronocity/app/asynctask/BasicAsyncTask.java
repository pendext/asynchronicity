package com.pendext.asynchronocity.app.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

public class BasicAsyncTask extends AsyncTask<String, Integer, String> {

    private TextView textView;

    public BasicAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
    }

    @Override
    protected void onPostExecute(String result) {
    }

}
