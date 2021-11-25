package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Bienvenidas extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private ProgressBar barradeprogreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        barradeprogreso= (ProgressBar) findViewById(R.id.Pb1);
        mAuth=FirebaseAuth.getInstance();

    }
    public void env_login(View vista){
        Intent irlogin= new Intent(this, Logins.class);
        startActivity(irlogin);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user= mAuth.getCurrentUser();
        if (user==null){
            startActivity(new Intent(this,Logins.class));
        }else{
            startActivity(new Intent(this,Mapa_principal.class));
        }
    }
}