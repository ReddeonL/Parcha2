package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Bienvenidas extends AppCompatActivity {


    //private ProgressBar barradeprogreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        //barradeprogreso= (ProgressBar) findViewById(R.id.Pb1);
        Toast.makeText(this, "bienvenido", Toast.LENGTH_LONG).show();

    }
    public void env_login(View vista){
        Intent irlogin= new Intent(this, Logins.class);
        startActivity(irlogin);
    }


}