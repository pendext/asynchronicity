package com.pendext.asynchronocity.app.listeners;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.pendext.asynchronocity.app.runnables.TextRunnable;
import com.pendext.asynchronocity.app.services.ViewTextPopulator;
import org.joda.time.*;

public class RunnableExampleOnClickListener implements OnClickListener {

    private TextView textView;
    private Activity activity;

    public RunnableExampleOnClickListener(TextView textView, Activity activity) {
        this.activity = activity;
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        String invokedTime = new LocalTime().toString("hh:mm:ss");
        new Thread(new TextRunnable(new ViewTextPopulator(activity, textView), "This text came from a background thread, invoked at: " + invokedTime)).start();
    }
}
