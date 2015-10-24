package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.pendext.asynchronocity.app.asynctask.BasicAsyncTask;
import org.joda.time.LocalTime;

public class AsyncTaskExampleOnClickListener implements OnClickListener {

    private BasicAsyncTask basicAsyncTask;
    private TextView textViewForFinalUpdate;
    private TextView textViewForProgressUpdate;

    public AsyncTaskExampleOnClickListener(TextView textViewForFinalUpdate, TextView textViewForProgressUpdate) {
        this.textViewForFinalUpdate = textViewForFinalUpdate;
        this.textViewForProgressUpdate = textViewForProgressUpdate;
    }

    @Override
    public void onClick(View v) {
        textViewForFinalUpdate.setText("");
        textViewForProgressUpdate.setText("");
        String startTime = new LocalTime().toString("hh:mm:ss");
        basicAsyncTask = new BasicAsyncTask(textViewForFinalUpdate, textViewForProgressUpdate);
        basicAsyncTask.execute(startTime);
    }
}
