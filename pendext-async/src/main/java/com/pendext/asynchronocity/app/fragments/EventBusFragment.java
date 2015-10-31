package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import com.pendext.asynchronocity.app.R;

public class EventBusFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_bus_example, container, false);

        Button uiWorkButton = (Button) rootView.findViewById(R.id.loader_ui_work);

        return rootView;
    }
}
