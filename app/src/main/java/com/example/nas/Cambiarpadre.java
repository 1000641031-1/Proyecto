package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nas.condiciones.usuario;

public class Cambiarpadre extends AppCompatActivity {
    /*Se le asigna una variable para los EditText */
    private EditText ed_Cedula, ed_Contrasena;
    /*Se le asigna una variable para los Button */
    Button btnCambiar, btnbuscar2;

    /*Se crea la actividad Cambiarpadre*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiarpadre);

        /*Lo que el usuario ponga el las variables de texto tambien quedan en los EditText */
        ed_Cedula=(EditText)findViewById(R.id.txtcedula3);
        ed_Contrasena=(EditText)findViewById(R.id.txtContraseña);
        /*Si el usuario selecciona un botón este hará una función*/
        btnbuscar2=(Button) findViewById(R.id.btnbuscar2);
        btnCambiar=(Button) findViewById(R.id.btnCambiar);

        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());
        /* Cuando el usuario le de al botón se activara la función buscar1 que esta en registroSQLite*/
        btnbuscar2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario usuario=new usuario();
                registroSQLite.buscar1(usuario, ed_Cedula.getText().toString());
                ed_Contrasena.setText(usuario.getContrasena());

            }
        });
        /*Con este botón se cambia la contraseña en la base de datos, gracias a la fución que esta en la clase registroSQLite*/
        btnCambiar.setOnClickListener(new View.OnClickListener(){
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
