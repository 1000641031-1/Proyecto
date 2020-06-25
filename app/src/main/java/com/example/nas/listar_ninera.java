package com.example.nas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nas.adaptadores.AdaptadorSolicitudes;
import com.example.nas.entidades.solicitudNinera;

import java.util.ArrayList;

public class listar_ninera extends AppCompatActivity {

    RecyclerView lista_solicitud;
    ArrayList<solicitudNinera>solicitudNineraArrayList;
    registroSQLite db;

    private AdaptadorSolicitudes adaptadorSolicitudes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ninera);

        lista_solicitud = findViewById(R.id.lista_solicitud);
        solicitudNineraArrayList = new ArrayList<>();
        db = new registroSQLite(this);

        lista_solicitud.setLayoutManager(new LinearLayoutManager(this));
        adaptadorSolicitudes = new AdaptadorSolicitudes(solicitudNineraArrayList);
        mostrarSolicitudes();
        lista_solicitud.setAdapter(adaptadorSolicitudes);
    }

    private void mostrarSolicitudes(){
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        solicitudNinera solicitud = null;

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from tbl_solicitud", null);
        while (cursor.moveToNext()){
            solicitud = new solicitudNinera();
            solicitud.setCantidad_solicitud(cursor.getInt(1));
            solicitud.setHora_solicitud(cursor.getString(2));
            solicitud.setPrecio_solicitud(cursor.getInt(3));
            solicitud.setEspecificar_solicitud(cursor.getString(4));
            solicitudNineraArrayList.add(solicitud);
        }
    }
}
