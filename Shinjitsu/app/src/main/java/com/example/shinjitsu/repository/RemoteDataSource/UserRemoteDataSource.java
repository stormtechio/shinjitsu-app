package com.example.shinjitsu.repository.RemoteDataSource;

import com.example.shinjitsu.config.RetrofitConfig;
import com.example.shinjitsu.entities.UserEntity;
import com.example.shinjitsu.interfaces.WebService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public  class UserRemoteDataSource {

    private WebService webService;
    private List<UserEntity> users;
    private UserEntity userEntity;

    public UserRemoteDataSource(){
        Retrofit retrofit = RetrofitConfig.getRetrofit();
        this.webService = retrofit.create(WebService.class);
    }

    public List<UserEntity> login() throws IOException {
        Call<List<UserEntity>> usersCall = webService.login(userEntity);

        users = usersCall.execute().body();


        return users;
    }

}
