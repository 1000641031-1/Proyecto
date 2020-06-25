package com.example.nas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Reservarninera extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase.CursorFactory factory;
    private EditText ed_Nombre, ed_Precio, ed_Cantidad, ed_Fecha, ed_Hora, ed_Ninos;
    private Button btnFecha, btnHora;
    private  int dia,mes,ano, hora, minutos;
    int MenosNinos=4;
    int MasNinos=1;
    int MenosHoras=1;
    int Precio_reser=10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservarninera);

        ed_Nombre = (EditText) findViewById(R.id.txtNinera);
        ed_Precio = (EditText) findViewById(R.id.txtPrecio);
        ed_Ninos = (EditText) findViewById(R.id.id_cantidadHoras);
        ed_Cantidad = (EditText) findViewById(R.id.txtNinos);
        ed_Fecha = (EditText) findViewById(R.id.txtFecha);
        ed_Hora = (EditText) findViewById(R.id.txtHora);
        btnFecha = (Button) findViewById(R.id.btnFecha);
        btnHora = (Button) findViewById(R.id.btnHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener( this);
    }


    public void reservar(View view){
        try {
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            String Nombre_reservar=ed_Nombre.getText().toString();
            String Precio_reservar=ed_Precio.getText().toString();
            String Numero_reservar=ed_Ninos.getText().toString();
            String Cantidad_reservar=ed_Cantidad.getText().toString();
            String Fecha_reservar=ed_Fecha.getText().toString();
            String Hora_reservar=ed_Hora.getText().toString();

            /*valida si los campos estan vacios*/
            if(!Nombre_reservar.isEmpty() && !Precio_reservar.isEmpty() && !Cantidad_reservar.isEmpty() && !Fecha_reservar.isEmpty() && !Hora_reservar.isEmpty()) {
                /*Para poder realizar las validaciones de cantidad de niños*/
                int cantidad = Integer.parseInt(Cantidad_reservar);
                int menosNinos = Integer.parseInt(String.valueOf(MenosNinos));
                int masNinos = Integer.parseInt(String.valueOf(MasNinos));

                /*Para poder realizar las validaciones de horas solicitadas*/
                int horas = Integer.parseInt(Numero_reservar);
                int menosHoras = Integer.parseInt(String.valueOf(MenosHoras));

                /*Para poder realizar las validaciones de precio*/
                int precioreser = Integer.parseInt(Precio_reservar);
                int Precio = Integer.parseInt(String.valueOf(Precio_reser));

                /*Se guarda lo que ingrese el usuario en la balse de datos*/
                ContentValues reserva = new ContentValues();
                reserva.put("Nombre_reservar", Nombre_reservar);
                reserva.put("Precio_reservar", Precio_reservar);
                reserva.put("Numero_reservar", Numero_reservar);
                reserva.put("Cantidad_reservar", Cantidad_reservar);
                reserva.put("Fecha_reservar", Fecha_reservar);
                reserva.put("Hora_reservar", Hora_reservar);
                /*Tabla en la cual se guarda el registro que acabo de hacer el usuario*/
                registroSQLite.insert("tbl_reservaninera", null, reserva);
                registroSQLite.close();

                /*Todos los campos que el usuario había escrito se eliminan del EditText, pero quedan guardados en la base de datos*/
                ed_Nombre.setText("");
                ed_Precio.setText("");
                ed_Ninos.setText("");
                ed_Cantidad.setText("");
                ed_Fecha.setText("");
                ed_Hora.setText("");

                String correString = "Reserva exitosa";
                Toast.makeText(getApplicationContext(), correString, Toast.LENGTH_SHORT).show();
            } else {

                String errorString = "Debe llenar todos los campos";
                Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            System.err.print("Error"+e);
        }
    }

    @Override
    public void onClick(View v) {
        /*Se crea el botón donde se muestra el calendario*/
        if (v==btnFecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    ed_Fecha.setText(dayOfMonth+"/"+(month)+"/"+year);
                }
            }
                    , dia,mes,ano);
            datePickerDialog.show();
        }
        /*Se crea el botón donde se muestra la hora*/
        if (v==btnHora){
            final Calendar c= Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    ed_Hora.setText(hourOfDay+":"+minute);
                }
            }, hora, minutos, false);
            timePickerDialog.show();

        }

    }
}