package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nas.entidades.Nineras;

public class mostrar_ninera extends AppCompatActivity {

    TextView nombreNinera,direccionNinera,telefonoNinera,descripcionNinera;

    String id;
    Nineras nineras;
    registroSQLite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ninera);

        db = new registroSQLite(this);

        nombreNinera = findViewById(R.id.Nombre_ninera);
        direccionNinera = findViewById(R.id.direccion_ninera);
        telefonoNinera = findViewById(R.id.Telefono_ninera);
        descripcionNinera = findViewById(R.id.Descripcion_ninera);
        Intent idNinera = getIntent();
        id = idNinera.getStringExtra("idNinera");

        mostrarDatos();

    }
    public void solicitarNinera(View view){
        Intent solicitarNinera= new Intent(this, solicitarninera.class);
        startActivity(solicitarNinera);
    }

    private void mostrarDatos() {
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        nineras = null;

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from usuarios where Cedula = '" + id + "'", null);
        while (cursor.moveToNext()) {
            nineras = new Nineras();
            nineras.setNombre(cursor.getString(1));
            nineras.setTelefono(cursor.getString(2));
            nineras.setDireccion(cursor.getString(3));
            nineras.setCorreo(cursor.getString(4));
            nineras.setRol(cursor.getString(6));
            nineras.setDescripcion(cursor.getString(7));
            nombreNinera.setText("Nombre: "+nineras.getNombre());
            direccionNinera.setText("Dirección: "+nineras.getDireccion());
            telefonoNinera.setText("Teléfono: "+nineras.getTelefono());
            descripcionNinera.setText("Descripción:"+nineras.getDescripcion());
        }
    }

}
