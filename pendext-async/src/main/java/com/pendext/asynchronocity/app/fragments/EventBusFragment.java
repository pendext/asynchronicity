package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import com.path.android.jobqueue.JobManager;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.*;

public class EventBusFragment extends Fragment {

    private JobManager jobManager;

    public EventBusFragment(Context context) {
        jobManager = new JobManager(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_bus_example, container, false);

        Button uiWorkButton = (Button) rootView.findViewById(R.id.event_bus_ui_work);
        Button invokeBackgroundButton = (Button) rootView.findViewById(R.id.event_bus_invoke_button);

        invokeBackgroundButton.setOnClickListener(new StartEventOnClickListener(jobManager));
        uiWorkButton.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));

        return rootView;
    }
}
