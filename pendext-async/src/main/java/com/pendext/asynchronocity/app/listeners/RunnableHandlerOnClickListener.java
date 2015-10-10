package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class RunnableHandlerOnClickListener implements OnClickListener {

    private TextView textView;

    public RunnableHandlerOnClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        
    }
}
