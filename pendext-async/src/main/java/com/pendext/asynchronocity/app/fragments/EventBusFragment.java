package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.path.android.jobqueue.JobManager;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.events.FibonacciEvent;
import com.pendext.asynchronocity.app.listeners.*;
import com.pendext.asynchronocity.app.singleton.EventBusSingleton;
import de.greenrobot.event.EventBus;

import java.util.*;

public class EventBusFragment extends Fragment {

    private JobManager jobManager;
    private EventBus eventBus;
    private List<Integer> numbers;
    private TextView fibonocciTextView;
    private Context context;
    private static final String INITIAL_SEQUENCE = "0";

    public EventBusFragment() {
        numbers = new ArrayList<>();
        numbers.add(0, 0);
        numbers.add(0, 1);
        eventBus = EventBusSingleton.getEventBus();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    public void setUpJobManager(Context context) {
        this.context = context;
        jobManager = new JobManager(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_bus_example, container, false);

        Button uiWorkButton = (Button) rootView.findViewById(R.id.event_bus_ui_work);
        Button invokeBackgroundButton = (Button) rootView.findViewById(R.id.event_bus_invoke_button);

        invokeBackgroundButton.setOnClickListener(new StartEventOnClickListener(jobManager, numbers));
        uiWorkButton.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));

        fibonocciTextView = (TextView) rootView.findViewById(R.id.event_bus_fibonacci);
        fibonocciTextView.setText(INITIAL_SEQUENCE);
        return rootView;
    }

    public void onEventMainThread(FibonacciEvent event) {
        String sequence = fibonocciTextView.getText().toString();
        int nextNumberInSequence = event.getNextNumberInSequence();
        sequence += ", " + nextNumberInSequence;
        fibonocciTextView.setText(sequence);
        numbers.add(nextNumberInSequence);
    }

}
