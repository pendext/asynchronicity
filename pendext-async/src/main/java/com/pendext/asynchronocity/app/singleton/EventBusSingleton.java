package com.pendext.asynchronocity.app.singleton;

import de.greenrobot.event.EventBus;

public class EventBusSingleton {

    private static EventBus eventBus;

    public static EventBus getEventBus() {
        if (eventBus == null) {
            eventBus = new EventBus();
            return eventBus;
        } else {
            return eventBus;
        }
    }
}
