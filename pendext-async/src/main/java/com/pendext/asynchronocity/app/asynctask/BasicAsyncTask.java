package com.pendext.asynchronocity.app.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;
import org.joda.time.LocalTime;

public class BasicAsyncTask extends AsyncTask<String, Integer, String> {

    private TextView textView;
    private String startTime;
    private String endTime;

    public BasicAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            this.startTime = params[0];
            Thread.sleep(20000);
            this.endTime = new LocalTime().toString("hh:mm:ss");

        } catch (InterruptedException e) {}
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
    }

    @Override
    protected void onPostExecute(String result) {
        String text = "The async task began a long running task at " + startTime +
                            " and completed the task at " + endTime;
        textView.setText(text);
    }

}
