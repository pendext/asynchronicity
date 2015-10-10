package com.pendext.asynchronocity.app.services;

import android.widget.TextView;

public class ViewTextPopulator {

    TextView viewToPopulateTextFor;

    public ViewTextPopulator(TextView viewToPopulateTextFor ) {
        this.viewToPopulateTextFor = viewToPopulateTextFor ;
    }

    public void populateTextWithSimulatedWait(String text, long simulatedWaitTimeInMillis) {
        try {
            Thread.sleep(simulatedWaitTimeInMillis);
            viewToPopulateTextFor.setText(text);
        } catch (InterruptedException e) {}
    }

}
