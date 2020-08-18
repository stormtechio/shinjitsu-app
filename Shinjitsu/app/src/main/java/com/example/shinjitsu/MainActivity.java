package com.example.shinjitsu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shinjitsu.activities.UserRegister;
import com.example.shinjitsu.entities.UserEntity;
import com.example.shinjitsu.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText editTextUser;
    EditText editTextPassword;
    String user;
    String password;
    Button buttonLogin;
    Intent intent;
    Toast toast;
    Button buttonRegister;
    UserRepository userRepository = new UserRepository();
    List<UserEntity> users = new ArrayList<>();


    UserEntity userEntity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        editTextUser = (EditText) findViewById(R.id.edit_text_user);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        buttonLogin = (Button) findViewById(R.id.button_login);
        buttonRegister = (Button) findViewById(R.id.button_register);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                user = editTextUser.getText().toString();
                password = editTextPassword.getText().toString();


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {

                            users = userRepository.login();

                            for (UserEntity u: users) {

                                if(user.equals(u.getUserName()) && password.equals(u.getPassword())){

                                    toast = Toast.makeText(getApplicationContext(), "Okay", Toast.LENGTH_SHORT);
                                    intent = new Intent(getApplicationContext(), InitialActivity.class);
                                    startActivity(intent);

                                }else{

                                    toast = Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos", Toast.LENGTH_SHORT);
                                    toast.show();
                                }

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();



//                if(user.equals("ayrton") && password.equals("123")){
//
//                    intent = new Intent(getApplicationContext(), InitialActivity.class);
//                    startActivity(intent);
//
//                }else{
//
//                    toast = Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
                    }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(getApplicationContext(), UserRegister.class);
                startActivity(intent);
            }
        });

    }
}
