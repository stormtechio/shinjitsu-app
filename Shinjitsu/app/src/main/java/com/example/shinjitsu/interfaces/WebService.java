package com.example.shinjitsu.interfaces;

import com.example.shinjitsu.entities.StudentEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("person")
    Call<List<StudentEntity>> getStudents();
    @GET("person/{id}")
    Call<List<StudentEntity>> getStudentById(@Path("id") int studentId);

}
