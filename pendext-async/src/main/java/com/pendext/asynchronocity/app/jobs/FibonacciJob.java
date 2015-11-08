package com.pendext.asynchronocity.app.jobs;

import com.path.android.jobqueue.*;
import com.pendext.asynchronocity.app.events.FibonacciEvent;
import com.pendext.asynchronocity.app.singleton.EventBusSingleton;
import de.greenrobot.event.EventBus;

public class FibonacciJob extends Job {

    private int newNumberInSequence;

    private EventBus eventBus;

    public FibonacciJob(int priority, int previousNumber, int previousPreviousNumber) {
        super(new Params(priority));
        this.newNumberInSequence = previousNumber + previousPreviousNumber;
        eventBus = EventBusSingleton.getEventBus();
    }

    @Override
    public void onAdded() { }

    @Override
    public void onRun() throws Throwable {
        Thread.sleep(5000); //Long running operation would go here
        eventBus.post(new FibonacciEvent(newNumberInSequence));
    }

    @Override
    protected void onCancel() { }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
