package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.*;

public class RunnableHandlerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thread_runnable_handler_example, container, false);
        Button applicationNotRespondingButton = (Button) rootView.findViewById(R.id.tr_button);
        TextView textViewToPopulateOnClick = (TextView) rootView.findViewById(R.id.runnable_text1);
        applicationNotRespondingButton.setOnClickListener(new RunnableHandlerOnClickListener(textViewToPopulateOnClick, getActivity()));
        return rootView;
    }
}
