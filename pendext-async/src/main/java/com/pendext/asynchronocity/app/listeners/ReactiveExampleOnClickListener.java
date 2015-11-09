package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ReactiveExampleOnClickListener implements OnClickListener {

    private TextView textView;

    public ReactiveExampleOnClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        textView.setText("welp!");
    }
}
