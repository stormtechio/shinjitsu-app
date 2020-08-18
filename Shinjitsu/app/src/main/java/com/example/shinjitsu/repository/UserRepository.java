package com.example.shinjitsu.repository;

import com.example.shinjitsu.entities.UserEntity;
import com.example.shinjitsu.repository.RemoteDataSource.UserRemoteDataSource;

import java.io.IOException;
import java.util.List;

public class UserRepository {

    private UserRemoteDataSource userRemoteDataSource;

    public UserRepository(){

        this.userRemoteDataSource = new UserRemoteDataSource();

    }
    public List<UserEntity> login() throws IOException {



        return this.userRemoteDataSource.login();
    }
}
