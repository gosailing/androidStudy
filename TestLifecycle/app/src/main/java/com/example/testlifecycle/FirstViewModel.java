package com.example.testlifecycle;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class FirstViewModel extends ViewModel implements LifecycleObserver {

    public static final String TAG = "YH---" + "FirstViewModel";

    public ObservableField<String> title = new ObservableField<>("default value");

    public FirstViewModel() {
        Log.d(TAG, "constructor");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void testOnCreate() {
        Log.d(TAG, "testOnCreate");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void testOnResume() {
        Log.d(TAG, "testOnResume");

    }

    @Override protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared");

    }
}
