package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nav_home2 extends AppCompatActivity {

    private EditText ed_Cedula;
    Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_home2);

        ed_Cedula=(EditText)findViewById(R.id.txtcedula5);
        btnAceptar=(Button) findViewById(R.id.btnNotificacion);

        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());

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
