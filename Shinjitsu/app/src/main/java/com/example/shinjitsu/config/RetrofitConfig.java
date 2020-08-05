package com.example.shinjitsu.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static final String PROTOCOL = "http";
    private static final String DOMAIN = "127.0.0.1"; // localhost
    private static final String PORT = "8080"; // Porta rodando no servidor

    private static final String BASE_URL = PROTOCOL + "://" + DOMAIN + ":" + PORT + "/";

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
