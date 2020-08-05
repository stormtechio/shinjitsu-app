package com.example.shinjitsu.interfaces;

import com.example.shinjitsu.repository.StudentRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("students/{student}/repos")
    Call<List<StudentRepository>> listRepos(@Path("student") String student);
}
