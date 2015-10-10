package com.pendext.asynchronocity.app.listeners;

import android.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.fragments.*;

public class ExampleSpinnerListener implements OnItemSelectedListener {

    private FragmentManager fragmentManager;

    public ExampleSpinnerListener(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.container, new ApplicationNotRespondingFragment()).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.container, new AsyncFragment()).commit();
                break;
            case 2:
                fragmentManager.beginTransaction().replace(R.id.container, new LoaderFragment()).commit();
                break;
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}
