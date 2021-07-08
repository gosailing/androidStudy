package com.example.testlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.example.testlifecycle.databinding.FirstFragmentMainBinding;
import androidx.lifecycle.ViewModelProviders;

public class FirstFragment extends Fragment {

    public static final String TAG = "YH---" + "FirstFragment";

    public static FirstFragment newInstance() {
        Log.d(TAG, "newInstance");
        return new FirstFragment();
    }

    public FirstFragment() {
        Log.d(TAG, "constructor");

    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

    }

    @Override public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");

    }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        FirstFragmentMainBinding binding = FirstFragmentMainBinding.inflate(inflater, container, false);
        FirstViewModel viewModel = ViewModelProviders.of(getActivity()).get(FirstViewModel.class);
        binding.setViewModel(viewModel);
        getLifecycle().addObserver(viewModel);
        return binding.getRoot();
    }

    @Override public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");

    }

    @Override public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");

    }

    @Override public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
}
