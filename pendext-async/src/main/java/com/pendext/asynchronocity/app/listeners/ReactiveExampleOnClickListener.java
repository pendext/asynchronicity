package com.pendext.asynchronocity.app.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import org.joda.time.*;
import rx.*;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ReactiveExampleOnClickListener implements OnClickListener {

    private TextView textView;

    public ReactiveExampleOnClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        String invokedTime = new LocalTime().toString("hh:mm:ss");
        textView.setText("This is the initial button press at " + invokedTime);
        Subscription subscription = makeLongRunningCall()
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<String>() {
                                        @Override
                                        public void onCompleted() {
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                        }

                                        @Override
                                        public void onNext(String s) {
                                            textView.setText("The long running operation ended at " + s);
                                        }
                                    });
    }

    public Observable<String> makeLongRunningCall() {
        return Observable.just("").map(new Func1<String, String>() {
            @Override
            public String call(String aString) {
                String invokedTime = null;
                try {
                    Thread.sleep(5000);
                    invokedTime = new LocalTime().toString("hh:mm:ss");
                } catch (InterruptedException e) {}
                return invokedTime;
            }
        });
    }
}
