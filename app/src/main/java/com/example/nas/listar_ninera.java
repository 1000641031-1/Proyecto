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
    /*Se crea el recyclearview  y se le asigna un nombre*/
    RecyclerView lista_solicitud;
    /*Se crea una array  y se le asigna un nombre*/
    ArrayList<solicitudNinera>solicitudNineraArrayList;
    /*Se llama la actividad registro que es donde estan los registros para listar niñeras*/
    registroSQLite db;
    /*Se crea una variable y se le asigna un nombre*/
    private AdaptadorSolicitudes adaptadorSolicitudes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ninera);

        lista_solicitud = findViewById(R.id.lista_solicitud);
        solicitudNineraArrayList = new ArrayList<>();
        db = new registroSQLite(this);

        lista_solicitud.setLayoutManager(new LinearLayoutManager(this));
        /*Se compara los adaptadores y dice que crea una nueva solicitud con la array */
        adaptadorSolicitudes = new AdaptadorSolicitudes(solicitudNineraArrayList);
        /*Se muestran los datos pero por el momento son vacios*/
        mostrarSolicitudes();
        /*Se listan las solicitudes dentro de la tarjeta designada*/
        lista_solicitud.setAdapter(adaptadorSolicitudes);
    }
    /*Se trae la clase  para mostrar los datos  */
    private void mostrarSolicitudes(){
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        solicitudNinera solicitud = null;


        Cursor cursor = sqLiteDatabase.rawQuery("Select * from tbl_solicitud", null);
        /*Se traen los datos de la tabla solicitud*/
        while (cursor.moveToNext()){
            /*Se hace la comparacion de los que estan en la base de datos con los campos que estan en la tarjeta */
            solicitud = new solicitudNinera();
            solicitud.setCantidad_solicitud(cursor.getInt(1));
            solicitud.setHora_solicitud(cursor.getString(2));
            solicitud.setPrecio_solicitud(cursor.getInt(3));
            solicitud.setEspecificar_solicitud(cursor.getString(4));
            solicitudNineraArrayList.add(solicitud);
        }
    }
}
