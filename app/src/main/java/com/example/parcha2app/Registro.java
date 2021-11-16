package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText nombretxt,apellidotxt,emailtxt;
    private Spinner edadtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombretxt=(EditText) findViewById(R.id.txtnombre);
        apellidotxt=(EditText)  findViewById(R.id.txtapellido);
        emailtxt=(EditText) findViewById(R.id.txtcorreo);
        edadtxt=(Spinner)  findViewById((R.id.spinneredad));
        String [] menu={"15-20 años","20-30 años","30-40 años","40-50 años",">50 años"};
        ArrayAdapter <String> menu_adap=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,menu);
        edadtxt.setAdapter(menu_adap);
    }
    public void registrar(View vista){
        String nombrestr=nombretxt.getText().toString();
        String apellidostr=apellidotxt.getText().toString();
        String emailstr=emailtxt.getText().toString();




        //mensaje de registro
        Toast toast2 =
                Toast.makeText(getApplicationContext(),
                        "Usuario registrado exitosamente", Toast.LENGTH_SHORT);

        toast2.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);

        toast2.show();
    }
}