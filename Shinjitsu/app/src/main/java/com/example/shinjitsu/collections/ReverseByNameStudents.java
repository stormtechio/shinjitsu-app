package com.example.shinjitsu.collections;

import com.example.shinjitsu.entities.StudentEntity;

import java.util.Comparator;

public class ReverseByNameStudents implements Comparator<StudentEntity> {
    @Override
    public int compare(StudentEntity studentEntity, StudentEntity t1) {
        return t1.getName().compareTo(studentEntity.getName());
    }
}
