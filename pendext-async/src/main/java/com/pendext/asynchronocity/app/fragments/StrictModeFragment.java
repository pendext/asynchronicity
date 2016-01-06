package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.*;
import android.view.*;
import android.widget.Button;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.listeners.StrictModeInvokeNetworkAccessListener;

public class StrictModeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.strict_mode_example, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyFlashScreen()
                .build();
        StrictMode.setThreadPolicy(policy);

        Button button = (Button) rootView.findViewById(R.id.strict_invoke_button);
        button.setOnClickListener(new StrictModeInvokeNetworkAccessListener());

        return rootView;
    }
}
