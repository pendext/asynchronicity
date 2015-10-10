package com.pendext.asynchronocity.app.listeners;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.pendext.asynchronocity.app.runnables.TextRunnable;
import com.pendext.asynchronocity.app.services.ViewTextPopulator;

public class RunnableHandlerOnClickListener implements OnClickListener {

    private TextView textView;
    private Activity activity;

    public RunnableHandlerOnClickListener(TextView textView, Activity activity) {
        this.activity = activity;
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        new Thread(new TextRunnable(new ViewTextPopulator(activity, textView), "Text created in the RunnableHandlerOnClickListener")).start();
    }
}
