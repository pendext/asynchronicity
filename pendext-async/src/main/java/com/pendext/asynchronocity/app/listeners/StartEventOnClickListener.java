package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import com.path.android.jobqueue.JobManager;
import com.pendext.asynchronocity.app.jobs.FibonacciJob;

import java.util.List;

public class StartEventOnClickListener implements OnClickListener {

    JobManager jobManager;
    private List<Integer> numbers;

    public StartEventOnClickListener(JobManager jobManager, List<Integer> numbers) {
        this.jobManager = jobManager;
        this.numbers = numbers;
    }

    @Override
    public void onClick(View v) {
        jobManager.addJob(new FibonacciJob(0, getPreviousNumber(), getPreviousPreviousNumber()));
    }

    private int getPreviousNumber() {
        int size = numbers.size();
        return numbers.get(size - 1);
    }

    private int getPreviousPreviousNumber() {
        int size = numbers.size();
        return numbers.get(size - 2);
    }
}
