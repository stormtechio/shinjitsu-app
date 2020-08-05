package com.example.shinjitsu.interfaces;

import com.example.shinjitsu.entities.StudentEntity;
import com.example.shinjitsu.repository.StudentRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("students")
    Call<List<StudentEntity>> getStudents();
    @GET("students/{id}")
    Call<List<StudentEntity>> getStudentById(@Path("id") int studentId);

}
