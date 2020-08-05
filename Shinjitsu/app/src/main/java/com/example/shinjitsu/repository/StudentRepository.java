package com.example.shinjitsu.repository;

import android.util.Log;

import com.example.shinjitsu.entities.StudentEntity;
import com.example.shinjitsu.repository.RemoteDataSource.StudentRemoteDataSource;

import java.io.IOException;
import java.util.List;

public class StudentRepository {

    private StudentRemoteDataSource studentRemoteDataSource;

    public StudentRepository(){
        this.studentRemoteDataSource = new StudentRemoteDataSource();
    }

    public List<StudentEntity> getStudents() throws IOException {

        return this.studentRemoteDataSource.getStudents();
    }

}
