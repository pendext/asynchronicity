package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.ApplicationNotRespondingOnClickListener;

public class ApplicationNotRespondingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.application_not_responding_example, container, false);
        Button applicationNotRespondingButton = (Button) rootView.findViewById(R.id.anr_button);
        applicationNotRespondingButton.setOnClickListener(new ApplicationNotRespondingOnClickListener());
        return rootView;
    }
}
