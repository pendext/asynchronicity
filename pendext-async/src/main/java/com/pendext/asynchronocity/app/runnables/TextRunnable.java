package com.pendext.asynchronocity.app.runnables;

import com.pendext.asynchronocity.app.services.RunOnUiThreadViewTextPopulator;

public class TextRunnable implements Runnable {

    private RunOnUiThreadViewTextPopulator runOnUiThreadViewTextPopulator;
    private String textToPopulate;

    public TextRunnable(RunOnUiThreadViewTextPopulator runOnUiThreadViewTextPopulator, String textToPopulate) {
        this.textToPopulate = textToPopulate;
        this.runOnUiThreadViewTextPopulator = runOnUiThreadViewTextPopulator;
    }

    @Override
    public void run() {
        runOnUiThreadViewTextPopulator.populateTextWithSimulatedWait(textToPopulate, 10000);
    }
}
