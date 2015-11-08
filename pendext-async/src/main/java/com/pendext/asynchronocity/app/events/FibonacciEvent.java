package com.pendext.asynchronocity.app.events;

public class FibonacciEvent {

    private int nextNumberInSequence;

    public FibonacciEvent(int nextNumberInSequence) {
        this.nextNumberInSequence = nextNumberInSequence;
    }

    public int getNextNumberInSequence() {
        return nextNumberInSequence;
    }
}
