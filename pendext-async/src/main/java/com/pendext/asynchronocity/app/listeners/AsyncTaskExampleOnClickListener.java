package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.pendext.asynchronocity.app.asynctask.BasicAsyncTask;
import org.joda.time.LocalTime;

public class AsyncTaskExampleOnClickListener implements OnClickListener {

    private BasicAsyncTask basicAsyncTask;

    public AsyncTaskExampleOnClickListener(TextView textView) {
        basicAsyncTask = new BasicAsyncTask(textView);
    }

    @Override
    public void onClick(View v) {
        String startTime = new LocalTime().toString("hh:mm:ss");
        basicAsyncTask.execute(startTime);
    }
}
