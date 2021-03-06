package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nas.condiciones.usuario;

public class Actualizarninera extends AppCompatActivity {

    /*Se le asigna una variable para los EditText */
    private EditText ed_Cedula, ed_Telefono, ed_Direccion, ed_Correo;
    /*Se le asigna una variable para los Button */
    Button btnActualizar1, btnbuscar1;

    /*Se crea la actividad Actualizarninera*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizarninera);
        /*Se le asigna las variables creadas para los EditText a los id de los campos de texto*/
        ed_Cedula=(EditText)findViewById(R.id.cedula2);
        ed_Telefono=(EditText)findViewById(R.id.telefono2);
        ed_Direccion=(EditText)findViewById(R.id.direccion2);
        ed_Correo=(EditText)findViewById(R.id.correo2);
        /*Si el usuario selecciona un botón este hará una función*/
        btnbuscar1=(Button)findViewById(R.id.btnbuscar1);
        btnActualizar1=(Button)findViewById(R.id.btnActualizar1);


        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());

        /* Cuando el usuario le de al botón se activara la función buscar que esta en registroSQLite*/
        btnbuscar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario usuario=new usuario();
                registroSQLite.buscar(usuario, ed_Cedula.getText().toString());
                ed_Telefono.setText(usuario.getTelefono());
                ed_Correo.setText(usuario.getCorreo());
                ed_Direccion.setText(usuario.getDireccion());
            }
        });
        /* Cuando el usuario le de al botón se activara la función actualizar que esta en registroSQLite*/
        btnActualizar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registroSQLite.actualizar( ed_Cedula.getText().toString(),ed_Telefono.getText().toString(),
                        ed_Correo.getText().toString(),ed_Direccion.getText().toString());
                ed_Telefono.setText("");
                ed_Correo.setText("");
                ed_Direccion.setText("");

                String correString = "Sus datos se actualizaron correctamente";
                Toast.makeText(getApplicationContext(), correString, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
