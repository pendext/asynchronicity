package com.pendext.asynchronocity.app.services;

import android.app.Activity;
import android.widget.TextView;
import org.joda.time.LocalTime;

public class RunOnUiThreadViewTextPopulator {

    Activity activity;
    TextView viewToPopulateTextFor;

    public RunOnUiThreadViewTextPopulator(Activity activity, TextView viewToPopulateTextFor) {
        this.activity = activity;
        this.viewToPopulateTextFor = viewToPopulateTextFor;
    }

    public void populateTextWithSimulatedWait(final String text, long simulatedWaitTimeInMillis) {
        try {
            Thread.sleep(simulatedWaitTimeInMillis);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String invokedTime = new LocalTime().toString("hh:mm:ss");
                    String textToPopulate = text + " and completed at " + invokedTime;
                    viewToPopulateTextFor.setText(textToPopulate);
                }
            });
        } catch (InterruptedException e) {}
    }

}
