package com.example.parcha2app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {
    private EditText nombretxt, apellidotxt, emailtxt, contrasenatxt;

    private Spinner edadtxt;
    private DatabaseReference Usuario;
    Button registrar;
    TextView mostrar;
    private FirebaseAuth mAuth;
    private RadioButton r1, r2, r3;
    private CheckBox checkBox;
    private static final String TAG = "EmailPassword";
    boolean autorizacion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Usuario = FirebaseDatabase.getInstance().getReference("USuario");
        setContentView(R.layout.activity_registro);
        nombretxt = (EditText) findViewById(R.id.txtnombre);
        apellidotxt = (EditText) findViewById(R.id.txtapellido);
        emailtxt = (EditText) findViewById(R.id.txtcorreo);
        contrasenatxt = (EditText) findViewById(R.id.editTextcont);
        mostrar = (TextView) findViewById(R.id.textView9);
        registrar = (Button) findViewById(R.id.button2);
        edadtxt = (Spinner) findViewById((R.id.spinneredad));
        String[] menu = {"15-20 años", "20-30 años", "30-40 años", "40-50 años", ">50 años"};
        ArrayAdapter<String> menu_adap = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, menu);
        edadtxt.setAdapter(menu_adap);
        mAuth = FirebaseAuth.getInstance();
        String seleccion = edadtxt.getSelectedItem().toString();
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

    }

    public void registrar(View vista) {
        String nombrestr = nombretxt.getText().toString();
        String apellidostr = apellidotxt.getText().toString();
        String emailstr = emailtxt.getText().toString();
        String seleccion_edad = edadtxt.getSelectedItem().toString();
        String genero;
        String contrasenastr = contrasenatxt.getText().toString();
        if (r1.isChecked() == true) {
            genero = "masculino";
        } else {
            if (r2.isChecked() == true) {
                genero = "femenino";
            } else {
                genero = "otro";
            }
        }
        if (checkBox.isChecked() == true) {
            autorizacion = true;
        }
        if (!nombrestr.isEmpty() && !apellidostr.isEmpty() && !emailstr.isEmpty()) {
            String id = Usuario.push().getKey();
            Usuario usur = new Usuario(id, "1", emailstr, seleccion_edad, nombrestr, apellidostr, genero, autorizacion);
            Usuario.child("usuarios").child(id).setValue(usur);
            Toast.makeText(this, "Informacion registrada", Toast.LENGTH_LONG).show();
            registrar2(emailstr, contrasenastr);
        } else {
            Toast.makeText(this, "Debe introducir la información", Toast.LENGTH_LONG).show();
        }
    }


    public void registrar2(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }

    private void reload() {
    }


}
