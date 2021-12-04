package com.example.quadram.ui.topfree;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.quadram.R;
import com.example.quadram.aplicacion;
import com.example.quadram.databinding.FragmentTopfreeBinding;
import com.example.quadram.databinding.FragmentTopfreeBinding;

import org.json.JSONObject;

import java.util.ArrayList;

public class TopfreeFragment extends Fragment {

    private TopfreeViewModel topfreeViewModel;
    private FragmentTopfreeBinding binding;

    private RecyclerView RecyclerView;
    private aplicacion Aplicacion;
    private ArrayList<aplicacion> lista;
    private RequestQueue RequestQueue;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topfreeViewModel =
                new ViewModelProvider(this).get(TopfreeViewModel.class);

        binding = FragmentTopfreeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView = root.findViewById(R.id.recyclerView);
        RecyclerView.setHasFixedSize(true);
        RecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        lista = new ArrayList<>();

        RequestQueue = Volley.newRequestQueue(root.getContext());

        parseJSON();






        topfreeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void parseJSON(){
        String URL = "https://itunes.apple.com/es/rss/topfreeapplications/limit=10/json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}