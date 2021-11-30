package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Logins extends AppCompatActivity {

    //variables
    private EditText Emailtxt;
    private TextInputLayout txtpassword;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //asignamos objetos a las variables
        Emailtxt=(EditText) findViewById(R.id.txtcorreo);
        //txtpassword=findViewById(R.id.EtPassword);
    }

    public void env_registro(View vista){
        Intent irregistro= new Intent(this, Registro.class);
        startActivity(irregistro);
    }
    public void env_olvido(View vista){
        Intent irolvido= new Intent(this, Olvido.class);
        startActivity(irolvido);
    }
    public void env_maps(View vista){
        Intent irmaps= new Intent(this, MapaCrearActividad.class);
        startActivity(irmaps);
    }
}