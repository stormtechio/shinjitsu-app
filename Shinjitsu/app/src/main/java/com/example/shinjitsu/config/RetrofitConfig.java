package com.example.shinjitsu.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public static final String BASE_URL = "http://localhost:5000/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

//    GitHubService service = retrofit.create(GitHubService.class);

//    Call<List<StudentRepository>> repos = service.listRepos("octocat");
}
