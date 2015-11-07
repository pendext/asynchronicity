package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.*;

public class RunnableFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thread_runnable_example, container, false);

        Button applicationNotRespondingButton = (Button) rootView.findViewById(R.id.tr_button);
        Button buttonForShowingUIThreadResponse = (Button) rootView.findViewById(R.id.event_bus_ui_work);

        TextView textViewToPopulateOnClick = (TextView) rootView.findViewById(R.id.runnable_text1);

        applicationNotRespondingButton.setOnClickListener(new RunnableExampleOnClickListener(textViewToPopulateOnClick, getActivity()));
        buttonForShowingUIThreadResponse.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));
        return rootView;
    }
}
