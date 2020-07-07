package com.example.shinjitsu.collections;

import com.example.shinjitsu.entities.StudentEntity;

import java.util.Comparator;

public class SortByNameStudents implements Comparator<StudentEntity> {
    @Override
    public int compare(StudentEntity studentEntity, StudentEntity t1) {
        return studentEntity.getName().compareTo(t1.getName());
    }
}
