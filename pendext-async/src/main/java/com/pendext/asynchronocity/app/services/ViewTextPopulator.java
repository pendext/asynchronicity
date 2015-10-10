package com.pendext.asynchronocity.app.services;

import android.app.Activity;
import android.widget.TextView;

public class ViewTextPopulator {

    Activity activity;
    TextView viewToPopulateTextFor;

    public ViewTextPopulator(Activity activity, TextView viewToPopulateTextFor ) {
        this.activity = activity;
        this.viewToPopulateTextFor = viewToPopulateTextFor ;
    }

    public void populateTextWithSimulatedWait(final String text, long simulatedWaitTimeInMillis) {
        try {
            Thread.sleep(simulatedWaitTimeInMillis);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    viewToPopulateTextFor.setText(text);
                }
            });
        } catch (InterruptedException e) {}
    }

}
