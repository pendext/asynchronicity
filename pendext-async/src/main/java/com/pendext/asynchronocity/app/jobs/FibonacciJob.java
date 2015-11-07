package com.pendext.asynchronocity.app.jobs;

import com.path.android.jobqueue.*;

public class FibonacciJob extends Job {

    private int previousNumber;
    private int previousPreviousNumber;

    public FibonacciJob(int priority, int previousNumber) {
        super(new Params(priority));
        this.previousNumber = previousNumber;
    }

    @Override
    public void onAdded() { }

    @Override
    public void onRun() throws Throwable {
        System.out.println("Job invoked!");
    }

    @Override
    protected void onCancel() { }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
