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
//        users = (List<UserEntity>) usersCall.request().body();





//        usersCall.enqueue(new Callback<List<UserEntity>>() {
//           @Override
//            public void onResponse(Call<List<UserEntity>> call, Response<List<UserEntity>> response) {
//                users = response.body();
//
////                userEntity = (UserEntity) response.body();
////
////                userEntity.getUserName();
////                userEntity.getPassword();
//
//                if(!response.isSuccessful()){
//                    Log.e("deeeeeeyy", "certo");
//                }
//           }
//            @Override
//            public void onFailure(Call<List<UserEntity>> call, Throwable t) {
//                Log.e("eeeeee", t.getLocalizedMessage());
//            }
//       });



        return users;
    }








}
