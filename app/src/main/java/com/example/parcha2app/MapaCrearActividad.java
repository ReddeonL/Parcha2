package com.example.parcha2app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MapaCrearActividad extends AppCompatActivity implements GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, OnMapReadyCallback {

    private TextView txtgetcoordinadas;
    private double Latitud;
    private double Longitud;

   // private GoogleMap googleMap;

    //para vincular la base de datos
    private DatabaseReference Actividades;
    //public Coordenadas(Double lato,Double lango){}





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_crear_actividad);
        getpermiso();
        //para interactuar con el mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        txtgetcoordinadas = (TextView) findViewById(R.id.tvcoordenadas2);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        googleMap.setMyLocationEnabled(true);

        //para centrar mapa en colombia

        LatLngBounds colombiaBounds = new LatLngBounds(
                new LatLng(-4.115425,-79.478871), // SW bounds
                new LatLng(12.476578, -67.675660)  // NE bounds
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colombiaBounds.getCenter(), 5));


        googleMap.setOnMapClickListener(this);
        Double Latitud2=getIntent().getDoubleExtra("latitud2",0);
        Double Longitud2=getIntent().getDoubleExtra("longitud2",0);
        LatLng punto2= new LatLng(Latitud2,Longitud2);
        googleMap.addMarker(new MarkerOptions().position(punto2).title("presione sostenido para crear su actividad"));
        googleMap.setOnMapLongClickListener(this);

//carge de coordenadas a partir de base de datos
/*
        Actividades.child("actividades").addChildEventListener(new ChildEventListener(){

            @Override
            public void onChildAdded( DataSnapshot snapshot,String prevChildKey) {
                coordenadas =snapshot.getValue(Double.class);
                Double longo=snapshot.child(consulta_str).child("precio").getValue().toString();
                tv_resultado_txt.setText("el codigo corresponde a un"+descripcion+"con un precio de "+precio);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //googleMap.setOnMarkerClickListener();
        */

    }


    @Override
    public void onMapClick(@NonNull LatLng punto) {

        Double Latitud2=punto.latitude;
        Double Longitud2=punto.longitude;
        txtgetcoordinadas.setText("Coordenadas seleccionadas="+punto.latitude+" , "+punto.longitude);

        Intent dato_salida2=new Intent(this,MapaCrearActividad.class);
        dato_salida2.putExtra("latitud2",Latitud2);
        dato_salida2.putExtra("longitud2",Longitud2);
        startActivity(dato_salida2);

    }

    @Override
    public void onMapLongClick(@NonNull LatLng punto) {
        txtgetcoordinadas.setText("Punto, presionado=" + punto);
        //pasar lass coordenadas al formulario
        Intent dato_salida=new Intent(this,Crear_Actividad.class);
        Latitud=punto.latitude;
        Longitud=punto.longitude;
        dato_salida.putExtra("latitud",Latitud);
        dato_salida.putExtra("longitud",Longitud);
        startActivity(dato_salida);
    }

    //opciones del menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.opciones,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getItemId();
        if(id==R.id.item1){
            //Toast.makeText(this,"usted selecciono la opcion 1", Toast.LENGTH_SHORT).show();
            //aca poner la redireccion a crear actividad
            Intent iropcion1= new Intent(this, Crear_Actividad.class);
            startActivity(iropcion1);
        }
        if(id==R.id.item2){
            //Toast.makeText(this,"usted selecciono la opcion 2", Toast.LENGTH_SHORT).show();
            //aca poner la redireccion a unirse actividad
            Intent iropcion2= new Intent(this, Unirse.class);
            startActivity(iropcion2);
        }
        if(id==R.id.item3){
            //Toast.makeText(this,"usted selecciono la opcion 3", Toast.LENGTH_SHORT).show();
            Intent iropcion3= new Intent(this, Acercade.class);
            startActivity(iropcion3);
        }
        return super.onOptionsItemSelected(item);
    }

    //permiso de gps
    private void getpermiso(){
        int permiso= ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permiso== PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){

            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }

        }

    }



}
