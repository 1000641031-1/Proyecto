package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class mostrar extends AppCompatActivity {
    ListView lvMostrar;
    ArrayList<String> listar= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        lvMostrar=(ListView) findViewById((R.id.lvMostrar));
        registroSQLite reg = new registroSQLite(this);
        SQLiteDatabase registroSQLite= reg.getWritableDatabase();

        Cursor fila = registroSQLite.rawQuery("select * from usuarios", null);
        if(fila.moveToFirst()){
            do{
                listar.add("Cédula:"+ fila.getString(0) + ", Nombre:" + fila.getString(1)+ ", Teléfono:" + fila.getString(2)+
                        ", Dirección: " + fila.getString(3)+ ", Correo:" + fila.getString(4)+ ", Contraseña:"
                        + fila.getString(5) + " Rol: " + fila.getString(6));
            }while(fila.moveToNext());
        }
        registroSQLite.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listar);
        lvMostrar.setAdapter(adapter);

    }
    }
