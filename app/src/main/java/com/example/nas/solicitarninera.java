package com.example.nas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class solicitarninera extends AppCompatActivity {
    SQLiteDatabase.CursorFactory factory;

    private EditText ed_Cantidad, ed_Horas, ed_Tiemposugerido, ed_Recomendacion;
    /*Se crean las variables para realizar algunas validaciones*/
    int MenosNinos=4;
    int MasNinos=1;
    int MenosHoras=1;
    int Precio=10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitarninera);
        /*Lo que el usuario ponga el las variables de texto tambien quedan en los EditText */
        ed_Cantidad = (EditText) findViewById(R.id.txtCantidad);
        ed_Horas = (EditText) findViewById(R.id.txtHoras);
        ed_Tiemposugerido = (EditText) findViewById(R.id.txtPreciosugerido);
        ed_Recomendacion = (EditText) findViewById(R.id.txtRecomendacion);
    }
    public void Solicitud(View view){
        try {
            /*Se llama la base de datos*/
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            /*Para poder guardar la información que diligencia en usuario, se le asina a la variable de la base de datos
             la variable del EditText*/
            String Cantidad_soli=ed_Cantidad.getText().toString();
            String Horas_soli=ed_Horas.getText().toString();
            String Precio_soli=ed_Tiemposugerido.getText().toString();
            String Especificar_soli=ed_Recomendacion.getText().toString();

            /*valida si los campos estan vacíos*/
            if(!Cantidad_soli.isEmpty() && !Horas_soli.isEmpty() && !Precio_soli.isEmpty() && !Especificar_soli.isEmpty()) {

                /*Para poder realizar las validaciones de cantidad de niños*/
                int cantidad = Integer.parseInt(Cantidad_soli);
                int menosNinos = Integer.parseInt(String.valueOf(MenosNinos));
                int masNinos = Integer.parseInt(String.valueOf(MasNinos));

                /*Para poder realizar las validaciones de horas solicitadas*/
                int horas = Integer.parseInt(Horas_soli);
                int menosHoras = Integer.parseInt(String.valueOf(MenosHoras));

                /* Para poder realizar las validaciones de precio*/
                int precioSoli = Integer.parseInt(Precio_soli);
                int Precio1 = Integer.parseInt(String.valueOf(Precio));

                /*Se hace la función donde se evalua si la cantidad de niños es menor a 4 para seguir con la solicitud*/
                if (cantidad < menosNinos  ){
                    /*Se hace la función donde se evalua si la cantidad de niños es mayor o igual a 1 para seguir con la solicitud*/
                    if (cantidad >= masNinos){
                        /*Se hace la función donde se evalua si el numero de horas es mayor o igual a 1 para seguir la solicitud*/
                        if (horas>=menosHoras){
                            /*Se hace la función donde se evalua si el precioes mayor a $10.000*/
                            if (precioSoli>=Precio1){

                                /*Se guarda lo que ingrese el usuario en la balse de datos*/
                                ContentValues solicitud=new ContentValues();
                                solicitud.put("Cantidad_soli", Cantidad_soli);
                                solicitud.put("Horas_soli", Horas_soli);
                                solicitud.put("Precio_soli", Precio_soli);
                                solicitud.put("Especificar_soli", Especificar_soli);

                                registroSQLite.insert("tbl_solicitud", null, solicitud);
                                registroSQLite.close();

                                ed_Cantidad.setText("");
                                ed_Horas.setText("");
                                ed_Tiemposugerido.setText("");
                                ed_Recomendacion.setText("");

                                String correString = "Procesando solicitud";
                                Toast.makeText(getApplicationContext(), correString, Toast.LENGTH_SHORT).show();

                                Intent siguiente =new Intent(this, solicitarninera.class );
                                startActivity(siguiente);
                            }else{
                                String errorString = "Debe ser mayor a $10.000";
                                Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            String errorString = "Debe ser mayor el número de horas";
                            Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        String errorString = "Debe ser mayor o igual a 1 niño";
                        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    String errorString = "Debe ser menor o igual a 3 niños";
                    Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
                }
            } else {

                String errorString = "Debe llenar todos los campos";
                Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            System.err.print("Error"+e);
        }
    }
}
