package com.example.parcha2app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaCrearActividad extends AppCompatActivity implements GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, OnMapReadyCallback {

    private TextView txtgetcoordinadas;
    private double Latitud;
    private double Longitud;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_crear_actividad);
        getpermiso();
        //para interactuar con el mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //para centrar mapa
       // fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        txtgetcoordinadas = (TextView) findViewById(R.id.tvcoordenadas2);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        googleMap.setMyLocationEnabled(true);



       // LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 17);
        //googleMap.animateCamera(cameraUpdate);

        googleMap.setOnMapClickListener(this);
        googleMap.setOnMapLongClickListener(this);


    }



    @Override
    public void onMapClick(@NonNull LatLng punto) {
        txtgetcoordinadas.setText("Punto marcado=" + punto.latitude);
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(punto.latitude, punto.longitude)).title("manten pulsado para crear actividad").visible(true);


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
