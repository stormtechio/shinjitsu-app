package com.example.shinjitsu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shinjitsu.fragments.PaymentsFragment;
import com.example.shinjitsu.fragments.StudentFragment;
import com.google.android.material.navigation.NavigationView;

public class InitialActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        // Criando apenas uma instancia de um gerenciador de fragmentos
        fragmentManager = getSupportFragmentManager();

        drawerLayout = (DrawerLayout)findViewById(R.id.activity_initial);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Para cada seleção, cria-se uma nova transação;
                fragmentTransaction = fragmentManager.beginTransaction();

                switch(id)
                {
                    case R.id.student:

                        // Instanciação de algum fragmento
                        StudentFragment studentFragment = new StudentFragment();
                        // A transação troca (replace) o fragmento, o primeiro parâmetro é o container, nessa caso o container é o FrameLayout
                        fragmentTransaction.replace(R.id.content_fragments, studentFragment);
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.payment:
                        // Instanciação de algum fragmento
                        PaymentsFragment paymentsFragment = new PaymentsFragment();
                        // A transação troca (replace) o fragmento, o primeiro parâmetro é o container, nessa caso o container é o FrameLayout
                        fragmentTransaction.replace(R.id.content_fragments, paymentsFragment);
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.option:
                        Toast.makeText(getApplicationContext(), "Opções",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    default:
                        return true;
                }

                // Pilha de execução dos fragments, nesse caso,por padrão usa-se o null
                fragmentTransaction.addToBackStack(null);
                // Commita a transação
                fragmentTransaction.commit();

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
