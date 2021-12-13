package com.example.quadram.ui.topfree;

import android.drm.DrmConvertedStatus;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.example.quadram.JSONResponse;
import com.example.quadram.recyclerfree.Adapter;
import com.example.quadram.R;
import com.example.quadram.ServicioPedimosAplicacion;
import com.example.quadram.recyclerfree.aplicacion;
import com.example.quadram.databinding.FragmentTopfreeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopfreeFragment extends Fragment {

    private TopfreeViewModel topfreeViewModel;
    private FragmentTopfreeBinding binding;
    private RecyclerView recyclerView;
    private aplicacion Aplicacion;
    private List<aplicacion> lista;
    private RequestQueue RequestQueue;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topfreeViewModel =
                new ViewModelProvider(this).get(TopfreeViewModel.class);

        binding = FragmentTopfreeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recycler = root.findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/es/rss/")//topfreeapplications/limit=10/json
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioPedimosAplicacion servicio = retrofit.create(ServicioPedimosAplicacion.class);


        Call<JSONResponse> llamada = servicio.cogerData();
        llamada.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                lista = new ArrayList<>(Arrays.asList(jsonResponse.getFeed()));
                PutDataIntoRecyclerView(lista);


            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
            }
        });


        topfreeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void PutDataIntoRecyclerView(List<aplicacion> lista) {
        Adapter adaptery = new Adapter(this.getContext(), lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adaptery);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
/*
 //moving though the array
            for(int i = 0; i < entryArray.length(); i++){
                //getting all objects in array
                JSONObject entryObjects = entryArray.getJSONObject(i);
                //taking objects with needed key
                JSONObject nameObject = entryObjects.getJSONObject("im:name");
                //getting string name
                String name = nameObject.getString("label");
                //putting data into ContentValues - name and id (for making a numbers
                // next to records in ListView)
                cv.put(DB.COL_NAME, name);
                cv.put(DB.COL_ID, i+1);
                mDB.insert(cv);
                //just controlling in log
                Log.d(LOG, "" + name);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
 */