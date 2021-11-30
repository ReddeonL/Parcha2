package com.example.parcha2app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Olvido extends AppCompatActivity {
    Button btn_recuperar2;
    EditText emailrecupText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvido);
        btn_recuperar2=(Button) findViewById(R.id.btn_recuperar);
        emailrecupText=(EditText) findViewById(R.id.editTextTextEmailAddress3);
        btn_recuperar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }
    public void validar()
    {
        String correo=emailrecupText.getText().toString().trim();
        if(correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches())
        {
            emailrecupText.setError("Correo inválido "+correo);
            return;
        }
        enviarcorreo(correo);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(Olvido.this,Logins.class);
        startActivity(i);
        finish();
    }
    public void enviarcorreo(String correo2)
    {
        FirebaseAuth mAuth3=FirebaseAuth.getInstance();
        String correoelectron=correo2;

        mAuth3.sendPasswordResetEmail(correoelectron).
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Olvido.this,"Correo enviado",Toast.LENGTH_LONG).show();
                            Intent i2= new Intent(Olvido.this,Logins.class);
                            startActivity(i2);
                            finish();
                        }else
                        {
                            Toast.makeText(Olvido.this,"Correo inválido",Toast.LENGTH_LONG).show();
                        }
                    }
                });

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