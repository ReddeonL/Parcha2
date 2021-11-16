package com.example.parcha2app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class Olvido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvido);
    }


    public void restaurar(View vista){



        //mensaje de restaurar
        Toast toast2 =
                Toast.makeText(getApplicationContext(),
                        "Contraseña restaurada exitosamente", Toast.LENGTH_SHORT);

        toast2.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);

        toast2.show();
    }

}