package com.pendext.asynchronocity.app.listeners;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.squareup.okhttp.*;

import java.io.IOException;

public class StrictModeInvokeNetworkAccessListener implements OnClickListener {

    @Override
    public void onClick(View v) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.example.com")
                .build();

        try {
            Log.i("StrictModeInvoke", "http request");
            client.newCall(request).execute();
        } catch (IOException e) {
        }
    }
}
