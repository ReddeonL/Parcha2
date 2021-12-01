package com.example.parcha2app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Logins extends AppCompatActivity {

    //variables
    private EditText Emailtxt, etpasswordsign;

    private Button btnLogin;
    private FirebaseAuth mAuth2;
    private static final String TAG="tester";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //asignamos objetos a las variables
        Emailtxt=(EditText) findViewById(R.id.EtEmail);
        etpasswordsign=findViewById(R.id.EtPassword);
        btnLogin=(Button)findViewById(R.id.btningrese);

        mAuth2=FirebaseAuth.getInstance();


    }
    @Override
    public void onStart() {
        super.onStart();
        //Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth2.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
    public void ingresa2(View view){

        mAuth2.signInWithEmailAndPassword(Emailtxt.getText().toString(), etpasswordsign.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth2.getCurrentUser();
                            updateUI(user);
                            Emailtxt.setText("");
                            etpasswordsign.setText("");
                            Toast.makeText(Logins.this, "Bienvenido!!!",
                                    Toast.LENGTH_SHORT).show();
                            Intent irmaps= new Intent(Logins.this, MapaCrearActividad  .class);
                            startActivity(irmaps);

                        } else {
                            // If sign in fails, display a message to the user.
                           // Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Logins.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });

    }



    private void reload() { }


    private void updateUI(FirebaseUser user) {

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
        Intent irmaps= new Intent(this, MapaCrearActividad  .class);
        startActivity(irmaps);

    }
}