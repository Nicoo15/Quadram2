package com.example.quadram;

import com.example.quadram.recyclerfree.Adapter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioPedimosAplicacion {
    @GET("topfreeapplications/limit=10/json")//
    Call<JSONResponse> cogerData();
}



