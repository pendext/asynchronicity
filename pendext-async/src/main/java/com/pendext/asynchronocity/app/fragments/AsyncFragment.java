package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.*;

public class AsyncFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.async_example, container, false);

        Button buttonForShowingUIThreadResponse = (Button) rootView.findViewById(R.id.as_text2);
        Button buttonForInvokingAsyncTask = (Button) rootView.findViewById(R.id.as_button);
        TextView textViewForFinalUpdate = (TextView) rootView.findViewById(R.id.as_text1);
        TextView textViewForProgressUpdate = (TextView) rootView.findViewById(R.id.as_progress);

        buttonForInvokingAsyncTask.setOnClickListener(new AsyncTaskExampleOnClickListener(textViewForFinalUpdate, textViewForProgressUpdate));
        buttonForShowingUIThreadResponse.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));

        return rootView;
    }
}
