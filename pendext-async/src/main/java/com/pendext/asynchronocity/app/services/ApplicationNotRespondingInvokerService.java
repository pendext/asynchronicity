package com.pendext.asynchronocity.app.services;

import android.util.Log;
import org.joda.time.DateTime;

public class ApplicationNotRespondingInvokerService {
    private static final String TAG = "ANRInvokerService";
    public void invokeApplicationNotResponding() {
        try {
            Log.i(TAG, "Invoking long running process at " + new DateTime().toString());
            Thread.sleep(10000);
            Log.i(TAG, "Completing long running process at " + new DateTime().toString());
        } catch (InterruptedException e) {}
    }
}
