package com.example.shinjitsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class InitialActivity extends AppCompatActivity {

   // Toolbar toolbar;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
       // setSupportActionBar(toolbar);
    }
}
