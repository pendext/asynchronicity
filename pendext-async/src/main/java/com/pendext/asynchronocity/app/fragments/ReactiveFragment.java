package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.*;

public class ReactiveFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.reactive_example, container, false);
        TextView textViewToUpdate = (TextView) rootView.findViewById(R.id.reactive_text1);
        Button uiWorkButton = (Button) rootView.findViewById(R.id.reactive_ui_work);
        Button exampleButton = (Button) rootView.findViewById(R.id.reactive_invoke_button);
        exampleButton.setOnClickListener(new ReactiveExampleOnClickListener(textViewToUpdate));
        uiWorkButton.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));
        return rootView;
    }
}
