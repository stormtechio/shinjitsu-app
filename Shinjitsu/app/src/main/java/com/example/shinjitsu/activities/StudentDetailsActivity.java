package com.example.shinjitsu.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shinjitsu.R;
import com.example.shinjitsu.entities.StudentEntity;

import java.io.Serializable;

public class StudentDetailsActivity extends AppCompatActivity implements Serializable {

    private StudentEntity studentEntity;
    private static final String STUDENTS = "students";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        studentEntity = (StudentEntity) getIntent().getSerializableExtra(STUDENTS);

    }
}
