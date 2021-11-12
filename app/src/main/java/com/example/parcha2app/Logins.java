package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Logins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        Intent irmaps= new Intent(this, MapsActivity.class);
        startActivity(irmaps);
    }
}