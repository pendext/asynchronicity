package com.pendext.asynchronocity.app.services;

import android.util.Log;

public class ApplicationNotRespondingInvokerService {
    private static final String TAG = "ANRInvokerService";
    public void invokeApplicationNotResponding() {
        try {
            Log.i(TAG, "Invoking long running process at " + System.currentTimeMillis());
            Thread.sleep(10000);
            Log.i(TAG, "Completing long running process at " + System.currentTimeMillis());
        } catch (InterruptedException e) {}
    }
}
