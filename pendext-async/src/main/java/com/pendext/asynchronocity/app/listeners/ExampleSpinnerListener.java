package com.pendext.asynchronocity.app.listeners;

import android.app.FragmentManager;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.fragments.*;

public class ExampleSpinnerListener implements OnItemSelectedListener {

    private FragmentManager fragmentManager;
    private Context context;

    public ExampleSpinnerListener(FragmentManager fragmentManager, Context context) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.container, new ApplicationNotRespondingFragment()).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.container, new RunnableFragment()).commit();
                break;
            case 2:
                fragmentManager.beginTransaction().replace(R.id.container, new AsyncFragment()).commit();
                break;
            case 3:
                fragmentManager.beginTransaction().replace(R.id.container, new LoaderFragment()).commit();
                break;
            case 4:
                EventBusFragment eventBusFragment = new EventBusFragment();
                eventBusFragment.setUpJobManager(context);
                fragmentManager.beginTransaction().replace(R.id.container, eventBusFragment).commit();
                break;
            case 5:
                ReactiveFragment reactiveFragment = new ReactiveFragment();
                fragmentManager.beginTransaction().replace(R.id.container, reactiveFragment).commit();
                break;
            case 6:
                StrictModeFragment strictModeFragment = new StrictModeFragment();
                fragmentManager.beginTransaction().replace(R.id.container, strictModeFragment).commit();
                break;
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}
