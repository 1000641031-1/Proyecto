package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nas.condiciones.usuario;

public class Cambiarninera extends AppCompatActivity {

    private EditText ed_Cedula, ed_Contrasena;
    Button btnCambiar1, btnbuscar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiarninera);


        ed_Cedula=(EditText)findViewById(R.id.txtcedula4);
        ed_Contrasena=(EditText)findViewById(R.id.txtContraseña4);
        btnbuscar3=(Button) findViewById(R.id.btnbuscar3);
        btnCambiar1=(Button) findViewById(R.id.btnCambiar1);

        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());

        /*Con este botón ayuda a buscar datos del padre*/
        btnbuscar3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario usuario=new usuario();
                registroSQLite.buscar1(usuario, ed_Cedula.getText().toString());
                ed_Contrasena.setText(usuario.getContrasena());

            }
        });
        /*Con este botón se cambia la contraseña en la base de datos, gracias a la fución que esta en la base de datos*/
        btnCambiar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registroSQLite.cambiar( ed_Cedula.getText().toString(),ed_Contrasena.getText().toString());
                ed_Contrasena.setText("");
                String correString = "Contraseña actualizada correctamente";
                Toast.makeText(getApplicationContext(), correString, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
