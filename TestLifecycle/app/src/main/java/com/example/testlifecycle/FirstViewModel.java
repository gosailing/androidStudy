package com.example.testlifecycle;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class FirstViewModel extends ViewModel {

    public ObservableField<String> title = new ObservableField<>("default value");

}
