package com.example.quadram.ui.toppaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quadram.recyclerfree.Adapter;
import com.example.quadram.R;
import com.example.quadram.ServicioPedimosAplicacion;
import com.example.quadram.recyclerfree.aplicacion;
import com.example.quadram.databinding.FragmentToppaidBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TopPaidFragment extends Fragment {

    private TopPaidViewModel topPaidViewModel;
    private FragmentToppaidBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topPaidViewModel =
                new ViewModelProvider(this).get(TopPaidViewModel.class);

        binding = FragmentToppaidBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
        @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }
    }
