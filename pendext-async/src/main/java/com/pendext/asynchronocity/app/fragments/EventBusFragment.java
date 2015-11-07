package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.ButtonForShowingUIThreadIsActiveOnClickListener;

public class EventBusFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_bus_example, container, false);

        Button uiWorkButton = (Button) rootView.findViewById(R.id.event_bus_ui_work);
        uiWorkButton.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));

        return rootView;
    }
}
