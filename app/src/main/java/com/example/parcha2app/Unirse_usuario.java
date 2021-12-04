package com.example.parcha2app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Unirse_usuario extends AppCompatActivity {

    private DatabaseReference Actividadesref, Unirseref;
    private ArrayAdapter<String> adaptador;
    private ListView listViewActividades;
    Actividades actividad;

    ArrayList<String> actividades_array, id_array;
    String consulta_str;

    String idusuario,idactividad,idusuario2;

    private TextView tw1_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unirse_usuario);
        actividad=new Actividades();
        Actividadesref= FirebaseDatabase.getInstance().getReference("Actividades");

        listViewActividades = (ListView) findViewById(R.id.listviewact);
         tw1_txt=(TextView)findViewById(R.id.tw1);

        listViewActividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //consulta_str=listViewActividades.getItemAtPosition(position).toString();
                consulta_str=id_array.get(position);
            }
        });


    }

    public void cargar(View vista) {

        Actividadesref.child("actividades").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                actividades_array = new ArrayList<>();
                id_array=new ArrayList<>();
                for(DataSnapshot ds : snapshot.getChildren()) {

                    //actividades_array.add(ds.getValue().toString());
                    actividad=ds.getValue(Actividades.class);
                    actividades_array.add(actividad.getNombre_actividad().toString());
                    id_array.add(actividad.getFirebaseid());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void mostrar(View vista)
    {
        //actividades_array.get(0).toString().split(",");

        adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,actividades_array);
        listViewActividades.setAdapter(adaptador);
    }

    public void unir_usuario(View vista)
    {
        if(!consulta_str.isEmpty())
        {
            Actividadesref.child("actividades").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    //idactividad=snapshot.child(consulta_str).child("idactividad").getValue().toString();

                   idusuario2=snapshot.child(consulta_str).child("idusuario").getValue().toString();
                    tw1_txt.setText("El grupo probando"+idusuario2);
                   // idusuario="diego";
                    //idactividad="123";

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    public void crear_unirse(View vista)
    {
        Unirseref=FirebaseDatabase.getInstance().getReference("Unirse");
        String id= Unirseref.push().getKey();
        Unirse u_a=new Unirse(id,idusuario2,"456",0,0,0,0);
        Unirseref.child("u_a").child(id).setValue(u_a);
        Toast.makeText(this,"Informacion registrada",Toast.LENGTH_LONG).show();

    }

}