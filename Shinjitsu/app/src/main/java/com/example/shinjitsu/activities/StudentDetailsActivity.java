package com.example.shinjitsu.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shinjitsu.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class StudentDetailsActivity extends AppCompatActivity implements Serializable {


    private static final String STUDENTS = "students";
    String studentEntity;
    JSONObject student;
    TextView name;
    TextView age;
    TextView responsible;
    TextView street;
    TextView neighborhood;
    TextView city;
    TextView state;
    TextView number;
    TextView complement;
    TextView cellphone;
    TextView email;
    TextView phone;
    TextView disease;
    TextView chronicDisease;
    TextView surgery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        studentEntity =  getIntent().getStringExtra(STUDENTS);

        findView();

        try {

            student = new JSONObject(studentEntity);

            name.append(student.getString("name"));
            age.append(student.getString("age"));
            responsible.append(student.getString("responsible"));
            street.append(student.getString("street"));
            neighborhood.append(student.getString("neighborhood"));
            city.append(student.getString("city"));
            state.append(student.getString("state"));
            number.append(student.getString("number"));
            complement.append(student.getString("complement"));
            cellphone.append(student.getString("cellphone"));
            email.append(student.getString("email"));
            phone.append(student.getString("phone"));

            if(student.getString("disease").equals("true")){
                disease.append("Sim");
            }
            if(student.getString("disease").equals("false")){
                disease.append("Não");
            }

            if(student.getString("chronicDisease").equals("true")){
                chronicDisease.append("Sim");
            }
            if(student.getString("chronicDisease").equals("false")){
                chronicDisease.append("Não");
            }

            if(student.getString("surgery").equals("true")){
                surgery.append("Sim");
            }
            if(student.getString("surgery").equals("false")){
                surgery.append("Não");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void findView(){

        name = findViewById(R.id.textview_student_name);
        age = findViewById(R.id.textview_student_age);
        responsible = findViewById(R.id.textview_student_responsible);
        street = findViewById(R.id.textview_student_street);
        neighborhood = findViewById(R.id.textview_student_neighborhood);
        city = findViewById(R.id.textview_student_city);
        state = findViewById(R.id.textview_student_state);
        number = findViewById(R.id.textview_student_number);
        complement = findViewById(R.id.textview_student_complement);
        cellphone = findViewById(R.id.textview_student_cellphone);
        email = findViewById(R.id.textview_student_email);
        phone = findViewById(R.id.textview_student_phone);
        disease = findViewById(R.id.textview_student_disease);
        chronicDisease = findViewById(R.id.textview_student_chronic_disease);
        surgery = findViewById(R.id.textview_student_surgery);

    }

}
