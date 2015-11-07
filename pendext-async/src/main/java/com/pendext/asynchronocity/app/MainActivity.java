package com.pendext.asynchronocity.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.pendext.asynchronocity.app.db.ASqliteOpenHelper;
import com.pendext.asynchronocity.app.fragments.ApplicationNotRespondingFragment;
import com.pendext.asynchronocity.app.listeners.ExampleSpinnerListener;


public class MainActivity extends Activity {

    private Spinner exampleSpinner;

    private String[] list = new String[] {
            "Application Not Responding Example",
            "Runnable Example",
            "Async Task Example",
            "Loader Example",
            "Job Queue/Event Bus Example"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleSpinner = (Spinner) findViewById(R.id.example_spinner);

        ArrayAdapter<String> exampleSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        exampleSpinner.setAdapter(exampleSpinnerAdapter);
        exampleSpinner.setOnItemSelectedListener(new ExampleSpinnerListener(getFragmentManager(), getApplicationContext()));

        ASqliteOpenHelper aSqliteOpenHelper = new ASqliteOpenHelper(this);
        aSqliteOpenHelper.onCreate(aSqliteOpenHelper.getWritableDatabase());

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ApplicationNotRespondingFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
