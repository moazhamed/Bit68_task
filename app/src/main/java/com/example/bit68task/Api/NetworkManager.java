package com.example.bit68task.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static Retrofit retrofitInstance;

    private static Retrofit getInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl("https://5bcce576cf2e850013874767.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;

    }


    public static ApiInterface getApi(){
        ApiInterface apiInterface = getInstance().create(ApiInterface.class);
        return apiInterface;
    }

}
