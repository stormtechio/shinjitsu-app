package com.example.shinjitsu.repository.RemoteDataSource;

import com.example.shinjitsu.entities.StudentEntity;

import java.util.List;

public abstract class StudentRemoteDataSource {

    private List<StudentEntity> studentEntityList;
    //private StudentEntity studentEntity;

    public StudentEntity addStudent(StudentEntity studentEntity){

        studentEntityList.add(studentEntity);

        return studentEntity;
    }

    public StudentEntity updateStudent(StudentEntity studentEntity){

        for (StudentEntity s: studentEntityList) {
           if(s.getId() == studentEntity.getId()){
               s = studentEntity;
               return s;
           }
        }

        return null;
    }

    public StudentEntity removeStudent(StudentEntity studentEntity){

        studentEntityList.remove(studentEntity);

        return studentEntity;
    }

    public StudentEntity getStudent(StudentEntity studentEntity){

        for (StudentEntity s: studentEntityList) {
            if(s.equals(studentEntity)){
                return studentEntity;
            }
        }

        return null;
    }
}
