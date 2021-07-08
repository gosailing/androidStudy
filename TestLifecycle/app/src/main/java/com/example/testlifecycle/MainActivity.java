package com.example.testlifecycle;

import android.os.PersistableBundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "YH---" + "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate savedInstanceState = " + savedInstanceState);

        FirstFragment firstFragment =
                (FirstFragment) getSupportFragmentManager().findFragmentByTag(FirstFragment.class.getName());
        Log.d(TAG, "onCreate firstFragment = " + firstFragment);

        if (firstFragment == null) {
            firstFragment = FirstFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), R.id.fragment_content, firstFragment, FirstFragment.class.getName());
        }

    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState = " + savedInstanceState);

    }

    @Override protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState = " + outState);

    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
}