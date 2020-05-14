package com.example.shinjitsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editTextUser;
    EditText editTextPassword;
    String user;
    String password;
    Button buttonLogin;
    Intent intent;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = (EditText) findViewById(R.id.textInputEditUser);
        editTextPassword = (EditText) findViewById(R.id.textInputEditPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                user = editTextUser.getText().toString();
                password = editTextPassword.getText().toString();

//                Log.e("OOOOOOIIIII",user);
//                Log.e("OOOOOOIIIII",password);

                if(user.equals("ayrton") && password.equals("123")){

                    intent = new Intent(getApplicationContext(), InitialActivity.class);
                    startActivity(intent);
                }else{

                    toast = Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });










    }
}
