package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class Crear_Actividad extends AppCompatActivity implements View.OnClickListener {
    //variables para widgets de fecha y hora
    Button bfecha,bhora;
    EditText efecha,ehora;
    private int dia,mes,anho,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_actividad);
        bfecha=(Button)findViewById(R.id.btnfecha);
        bhora=(Button)findViewById(R.id.btnhora);
        efecha=(EditText) findViewById(R.id.txtfecha);
        ehora=(EditText) findViewById(R.id.txthora);
        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
    }

    //metodos para witget de fecha y hora

    @Override
    public void onClick(View v) {
        if (v==bfecha){
            final Calendar c=Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            anho=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    efecha.setText(dayOfMonth+"/"+month+"/"+year);
                }
            },dia,mes,anho);
            datePickerDialog.show();

        }
        if(v==bhora){
            final Calendar c=Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    ehora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,true);
            timePickerDialog.show();

        }
    }

    public void env_maps2(View vista){
        Intent irmaps2= new Intent(this, MapaCrearActividad.class);
        startActivity(irmaps2);
    }
}