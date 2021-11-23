package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Mapa_principal extends AppCompatActivity {
    public int userIcon,actividadIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_principal);
        getpermiso();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.opciones,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getItemId();
        if(id==R.id.item1){
            Toast.makeText(this,"usted selecciono la opcion 1", Toast.LENGTH_SHORT).show();
            //aca poner la redireccion a crear actividad
            //Intent iropcion1= new Intent(this, Opcion1Actvity.class);
            //startActivity(iropcion1);
        }
        if(id==R.id.item2){
            Toast.makeText(this,"usted selecciono la opcion 2", Toast.LENGTH_SHORT).show();
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