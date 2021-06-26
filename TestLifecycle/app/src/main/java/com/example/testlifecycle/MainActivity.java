package com.example.testlifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment =
                (FirstFragment) getSupportFragmentManager().findFragmentByTag(FirstFragment.class.getName());
        if (firstFragment == null) {
            firstFragment = FirstFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), R.id.fragment_content, firstFragment, FirstFragment.class.getName());
        }

    }
}