package com.example.nas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nas.adaptadores.AdaptadorReserva;
import com.example.nas.entidades.solicitudReserva;

import java.util.ArrayList;

public class listar_reserva extends AppCompatActivity {

    RecyclerView listar_Reserva;
    ArrayList<solicitudReserva> solicitudReservaArrayList;
    registroSQLite db;

    private AdaptadorReserva adaptadorReserva;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_reserva);
    listar_Reserva = findViewById(R.id.listar_Reserva);
    solicitudReservaArrayList = new ArrayList<>();
    db = new registroSQLite(this);

    listar_Reserva.setLayoutManager(new LinearLayoutManager(this));
    adaptadorReserva = new AdaptadorReserva(solicitudReservaArrayList);
    mostrarReservas();
    listar_Reserva.setAdapter(adaptadorReserva);
}

    private void mostrarReservas(){
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        solicitudReserva reserva = null;

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from tbl_reserva", null);
        while (cursor.moveToNext()){
            reserva = new solicitudReserva();
            reserva.setCantidad_reservar(cursor.getInt(1));
            reserva.setnumero_horas(cursor.getInt(2));
            reserva.setPrecio_reservar(cursor.getInt(3));
            reserva.setHora_reservar(cursor.getString(4));
            reserva.setFecha_reservar(cursor.getString(5));

            solicitudReservaArrayList.add(reserva);
        }
    }
}
