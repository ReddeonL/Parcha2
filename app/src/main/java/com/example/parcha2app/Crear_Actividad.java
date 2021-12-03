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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Crear_Actividad extends AppCompatActivity implements View.OnClickListener {
//variables para base de datos
    private DatabaseReference Actividades;
    public EditText idactividad_txt, nombreactividad_txt, descripcion_txt, num_part_txt,creador_txt;

    //variables para widgets de fecha y hora

    Button bfecha,bhora;
    EditText efecha,ehora;
    private int dia,mes,anho,hora,minutos;
    private TextView suscorrdenadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_actividad);
        Actividades= FirebaseDatabase.getInstance().getReference("Actividades");
        //para los botones de hora y fecha
        bfecha=(Button)findViewById(R.id.btnfecha);
        bhora=(Button)findViewById(R.id.btnhora);
        efecha=(EditText) findViewById(R.id.txtfecha);
        ehora=(EditText) findViewById(R.id.txthora);
        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
        // para las coordenadas importadas del mapa
        suscorrdenadas=(TextView) findViewById(R.id.tvcoordenadas);
        Double latitud_importado =getIntent().getDoubleExtra("latitud",0);
        Double longitud_importado =getIntent().getDoubleExtra("longitud",0);
        suscorrdenadas.setText("sus coordenadas son "+latitud_importado+"latitud "+longitud_importado+" longitud");
        //para tomar datos
        nombreactividad_txt=(EditText)findViewById(R.id.et_nombreactividad);
        descripcion_txt=(EditText)findViewById(R.id.txtdescripcion);
        creador_txt=(EditText)findViewById(R.id.et_creador);
        num_part_txt=(EditText) findViewById(R.id.etnoparticipant);
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
//para registrar actividad
    public void registraractividad(View vista){

        String nombre_actividad=nombreactividad_txt.getText().toString();
        String desc=descripcion_txt.getText().toString();
        String nombre=creador_txt.getText().toString();
        int num_part=Integer.parseInt(num_part_txt.getText().toString());
        //dividir fecha
        String fechaentera =efecha.getText().toString();
        String[] fechaDividida = fechaentera.split("/");
        int year = Integer.parseInt(fechaDividida[2]);
        int month = Integer.parseInt(fechaDividida[1]);
        int day = Integer.parseInt(fechaDividida[0]);
        String horeentera=ehora.getText().toString();
        String[] horadividida = horeentera.split(":");
        int hora1=Integer.parseInt(horadividida[0]);
        int min1=Integer.parseInt(horadividida[1]);

        double lat=getIntent().getDoubleExtra("latitud",0);
        double lon=getIntent().getDoubleExtra("longitud",0);


        if (!nombre_actividad.isEmpty() && !desc.isEmpty() && !String.valueOf(num_part).isEmpty())
        {
            String id=Actividades.push().getKey();
            Actividades actividadesi= new Actividades
                    (id,num_part, lat,lon, nombre_actividad,
                            desc, nombre,year, month, day,hora1, min1);
            Actividades.child("actividades").child(id).setValue(actividadesi);
            Toast.makeText(this,"Actividad creada",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"Debe introducir toda la informacion",Toast.LENGTH_LONG).show();
        }


    }
}