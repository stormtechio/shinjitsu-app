package com.example.shinjitsu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        getSupportActionBar().hide();

        editTextUser = (EditText) findViewById(R.id.edit_text_user);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        buttonLogin = (Button) findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                user = editTextUser.getText().toString();
                password = editTextPassword.getText().toString();

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
