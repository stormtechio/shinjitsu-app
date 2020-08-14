package com.example.shinjitsu.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static final String PROTOCOL = "http";
    private static final String DOMAIN = "192.168.1.17"; // localhost
    private static final String PORT = "5000"; // Porta rodando no servidor

    private static final String BASE_URL = PROTOCOL + "://" + DOMAIN + ":" + PORT + "/";
//    private static final String BASE_URL = "http://localhost:5000/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }

        return retrofit;

    }

}
