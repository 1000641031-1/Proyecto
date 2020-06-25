package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nav_home2 extends AppCompatActivity {
    /*Se le asigna una variable para los EditText */
    private EditText ed_Cedula;
    /*Se le asigna una variable para los Button */
    Button btnAceptar;

    /*Se crea la actividad nav_home2*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_home2);

        /*Se le asigna las variables creadas para los EditText a los id de los campos de texto*/
        ed_Cedula=(EditText)findViewById(R.id.txtcedula5);
        /*Si el usuario selecciona un botón este hará una función*/
        btnAceptar=(Button) findViewById(R.id.btnNotificacion);

        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());

        /* Cuando el usuario le de al botón se activara la función eliminar que esta en registroSQLite*/
        btnAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registroSQLite.eliminar(ed_Cedula.getText().toString());
                ed_Cedula.setText(" ");
                String correString = "Usuario eliminado";
                Toast.makeText(getApplicationContext(), correString, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
