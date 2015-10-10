package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ButtonForShowingUIThreadIsActiveOnClickListener implements OnClickListener {

    private String textToShowInToast;

    public ButtonForShowingUIThreadIsActiveOnClickListener(String textToShowInToast) {
        this.textToShowInToast = textToShowInToast;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), textToShowInToast, Toast.LENGTH_SHORT).show();
    }
}
