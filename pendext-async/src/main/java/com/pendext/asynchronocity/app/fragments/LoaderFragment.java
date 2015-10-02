package com.pendext.asynchronocity.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import com.pendext.asynchronocity.app.R;

public class LoaderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.loader_fragment, container, false);
        return rootView;
    }
}
