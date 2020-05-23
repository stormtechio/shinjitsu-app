package com.example.shinjitsu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class InitialActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);



//        InitialFragment fragment = new InitialFragment();
//        fragmentTransaction.add(R.id.fragment1, fragment);
//        fragmentTransaction.commit();

//        InitialFragment fragment2 = new InitialFragment();
//        fragmentTransaction.add(R.id.fragment2, fragment2);
//        fragmentTransaction.commit();

        drawerLayout = (DrawerLayout)findViewById(R.id.activity_initial);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.Open, R.string.Close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.student:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        InitialFragment fragment = new InitialFragment();
                        fragmentTransaction.add(R.id.fragment1, fragment);
                        fragmentTransaction.commit();
//                        intent = new Intent(getApplicationContext(), StudentActivity.class);
//                        startActivity(intent);
                        break;
                    case R.id.payment:
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        InitialFragment fragment2 = new InitialFragment();
                        fragmentTransaction2.add(R.id.fragment2, fragment2);
                        fragmentTransaction2.commit();
//                        intent = new Intent(getApplicationContext(), PaymentActivity.class);
//                        startActivity(intent);
                        break;
                    case R.id.option:
                        Toast.makeText(getApplicationContext(), "Opções",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }

                return true;

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
