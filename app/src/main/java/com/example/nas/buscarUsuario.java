package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nas.condiciones.usuario;

public class buscarUsuario extends AppCompatActivity {
    private EditText ed_Cedula, ed_Nombre, ed_Correo, ed_direccion, ed_telefono;
    Button  btnbuscar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_usuario);
        /*Lo que el usuario ponga el las variables de texto tambien quedan en los EditText */
        ed_Cedula=(EditText)findViewById(R.id.txtcedula5);
        ed_Correo=(EditText)findViewById(R.id.txtnombre);
        ed_Nombre=(EditText)findViewById(R.id.txtcorreo2);
        ed_telefono=(EditText)findViewById(R.id.txttelefono2);
        ed_direccion=(EditText)findViewById(R.id.txtdireccion2);
        /*Si el usuario selecciona un botón este hará una función*/
        btnbuscar4=(Button) findViewById(R.id.btnbuscar4);

        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());
        /* Cuando el usuario le de al botón se activara la función buscar2 que esta en registroSQLite*/
        btnbuscar4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario usuario=new usuario();
                registroSQLite.buscar2(usuario, ed_Cedula.getText().toString());
                ed_Nombre.setText(usuario.getNombre());
                ed_Correo.setText(usuario.getCorreo());
                ed_telefono.setText(usuario.getTelefono());
                ed_direccion. setText(usuario.getDireccion());
            }
        });
    }
}
