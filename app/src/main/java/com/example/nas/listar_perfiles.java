package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nas.adaptadores.AdaptadorNineras;
import com.example.nas.adaptadores.AdaptadorSolicitudes;
import com.example.nas.entidades.Nineras;
import com.example.nas.entidades.solicitudNinera;

import java.util.ArrayList;

public class listar_perfiles extends AppCompatActivity {

    RecyclerView listarNinera;
    /*Se crea el recyclearview  y se le asigna un nombre*/
    ArrayList<Nineras> ninerasArrayList;
    /*Se crea una array  y se le asigna un nombre*/
    registroSQLite db;
    /*Se llama la actividad registro que es donde estan los registros para listar niñeras*/
    Nineras nineras;
    /*Se crea una variable y se le asigna un nombre*/
    private AdaptadorNineras adaptadorNineras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_perfiles);

        listarNinera = findViewById(R.id.listarNineras);
        ninerasArrayList = new ArrayList<>();
        db = new registroSQLite(this);

        listarNinera.setLayoutManager(new LinearLayoutManager(this));
        /*Se compara los adaptadores y dice que crea un listar  */
        adaptadorNineras = new AdaptadorNineras(ninerasArrayList);
        /*Se muestran los datos pero por el momento son vacios*/
        mostrarNineras();
        /*Se hace el evento click para poder entrar a cada tarjeta del perfil*/
        adaptadorNineras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNinera =  ninerasArrayList.get(listarNinera.getChildAdapterPosition(view)).getCedula();
                Intent enviarId = new Intent(listar_perfiles.this,mostrar_ninera.class);
                enviarId.putExtra("idNinera",idNinera);
                startActivity(enviarId);
            }
        });
        listarNinera.setAdapter(adaptadorNineras);
    }

    private void mostrarNineras() {
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
         nineras = null;

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from usuarios where rol = 'niñera'", null);
        /*Se traen los datos de la tabla niñera*/
        while (cursor.moveToNext()) {
            /*Se hace la comparacion de los que estan en la base de datos con los campos que estan en la tarjeta */
            nineras = new Nineras();
            nineras.setCedula(cursor.getString(0));
            nineras.setNombre(cursor.getString(1));
            nineras.setDireccion(cursor.getString(3));
            ninerasArrayList.add(nineras);
        }
    }
}
