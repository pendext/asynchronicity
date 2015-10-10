package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import com.pendext.asynchronocity.app.services.ApplicationNotRespondingInvokerService;

public class ApplicationNotRespondingOnClickListener implements OnClickListener {

    private ApplicationNotRespondingInvokerService applicationNotRespondingInvokerService;

    public ApplicationNotRespondingOnClickListener() {
        this.applicationNotRespondingInvokerService = new ApplicationNotRespondingInvokerService();
    }

    @Override
    public void onClick(View v) {
        applicationNotRespondingInvokerService.invokeApplicationNotResponding();
    }
}
