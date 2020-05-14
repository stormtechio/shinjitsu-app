package com.example.shinjitsu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;


public class InitialActivity extends AppCompatActivity {

   // Toolbar toolbar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }
}
