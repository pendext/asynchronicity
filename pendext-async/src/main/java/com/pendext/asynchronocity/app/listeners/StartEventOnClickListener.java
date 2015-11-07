package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import com.path.android.jobqueue.JobManager;
import com.pendext.asynchronocity.app.jobs.FibonacciJob;

public class StartEventOnClickListener implements OnClickListener {

    JobManager jobManager;

    public StartEventOnClickListener(JobManager jobManager) {
        this.jobManager = jobManager;
    }

    @Override
    public void onClick(View v) {
        jobManager.addJob(new FibonacciJob(0, 0));
    }
}
