package com.example.shinjitsu.models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shinjitsu.config.RequestSingleton;
import com.example.shinjitsu.entities.StudentEntity;

public class StudentModel {

    private Context context;

   public StudentModel(Context context){
        this.context = context;
    }

    public void createStudent(StudentEntity studentEntity){

        RequestQueue requestQueue = RequestSingleton.getInstance(this.context).getRequestQueue();
        requestQueue.start();

        String url ="http://www.example.com";

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        RequestSingleton.getInstance(this.context).addToRequestQueue(stringRequest);
    }
    public void updateStudent(StudentEntity studentEntity){

        RequestQueue requestQueue = RequestSingleton.getInstance(this.context).getRequestQueue();
        requestQueue.start();

        String url ="http://www.example.com";

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        RequestSingleton.getInstance(this.context).addToRequestQueue(stringRequest);

    }
    public void deleteStudent(int id){

        RequestQueue requestQueue = RequestSingleton.getInstance(this.context).getRequestQueue();
        requestQueue.start();

        String url ="http://www.example.com";

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        RequestSingleton.getInstance(this.context).addToRequestQueue(stringRequest);

    }
    public void readStudent(StudentEntity studentEntity){

        RequestQueue requestQueue = RequestSingleton.getInstance(this.context).getRequestQueue();
        requestQueue.start();

        String url ="http://www.example.com";

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        RequestSingleton.getInstance(this.context).addToRequestQueue(stringRequest);

    }
}
