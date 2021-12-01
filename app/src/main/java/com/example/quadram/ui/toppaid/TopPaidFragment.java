package com.example.quadram.ui.toppaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quadram.databinding.FragmentToppaidBinding;


public class TopPaidFragment extends Fragment {

    private TopPaidViewModel topPaidViewModel;
    private FragmentToppaidBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topPaidViewModel =
                new ViewModelProvider(this).get(TopPaidViewModel.class);

        binding = FragmentToppaidBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        topPaidViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}