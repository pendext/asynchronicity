package com.pendext.asynchronocity.app.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;
import org.joda.time.LocalTime;

public class BasicAsyncTask extends AsyncTask<String, Integer, String> {

    private TextView textViewForFinalUpdate;
    private TextView textViewForProgressUpdate;
    private String startTime;
    private String endTime;

    public BasicAsyncTask(TextView textViewForFinalUpdate, TextView textViewForProgressUpdate) {
        this.textViewForFinalUpdate = textViewForFinalUpdate;
        this.textViewForProgressUpdate = textViewForProgressUpdate;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            this.startTime = params[0];
            long initialTime = 1;
            int seconds = 0;
            while (initialTime < 20000) {
                publishProgress(seconds);
                seconds += 1;
                initialTime += 1000;
                Thread.sleep(1000);
            }
            this.endTime = new LocalTime().toString("hh:mm:ss");
        } catch (InterruptedException e) {
            // Something should be caught here
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... secondsPassed) {
        Integer seconds = secondsPassed[0];
        textViewForProgressUpdate.setText(seconds + " seconds have passed since invoking the async task.");
    }

    @Override
    protected void onPostExecute(String result) {
        String text = "The async task began a long running task at " + startTime +
                            " and completed the task at " + endTime;
        textViewForFinalUpdate.setText(text);
    }

}
