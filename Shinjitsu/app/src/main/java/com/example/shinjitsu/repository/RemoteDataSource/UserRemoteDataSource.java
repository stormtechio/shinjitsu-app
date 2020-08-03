package com.example.shinjitsu.repository.RemoteDataSource;

import com.example.shinjitsu.entities.UserEntity;

import java.util.List;

public abstract class UserRemoteDataSource {

    private List<UserEntity> userEntityList;

    public UserEntity addUser(UserEntity userEntity){

       userEntityList.add(userEntity);

        return userEntity;
    }

    public UserEntity updateUser(UserEntity userEntity){

        for (UserEntity u: userEntityList) {
            if(u.getId() == userEntity.getId()){
                u = userEntity;
                return u;
            }
        }

        return null;
    }

    public UserEntity removeUser(UserEntity userEntity){

        userEntityList.remove(userEntity);

        return userEntity;
    }

    public UserEntity getUser(UserEntity userEntity){

        for (UserEntity u: userEntityList) {
            if(u.equals(userEntity)){
                return userEntity;
            }
        }

        return null;
    }
}
