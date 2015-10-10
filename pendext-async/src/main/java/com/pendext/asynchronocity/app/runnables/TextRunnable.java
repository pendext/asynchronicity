package com.pendext.asynchronocity.app.runnables;

import com.pendext.asynchronocity.app.services.ViewTextPopulator;

public class TextRunnable implements Runnable {

    private ViewTextPopulator viewTextPopulator;
    private String textToPopulate;

    public TextRunnable(ViewTextPopulator viewTextPopulator, String textToPopulate) {
        this.textToPopulate = textToPopulate;
        this.viewTextPopulator = viewTextPopulator;
    }

    @Override
    public void run() {
        viewTextPopulator.populateTextWithSimulatedWait(textToPopulate, 10000);
    }
}
