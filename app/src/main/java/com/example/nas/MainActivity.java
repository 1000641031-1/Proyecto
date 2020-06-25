package com.example.nas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase.CursorFactory factory;
    /*Se abre la base de datos*/
    registroSQLite nas;
    /*Se le asigna una variable para los EditText */
    private EditText ed_Correo, ed_Contrasena;

    /*Se crea la actividad MainActivity*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nas= new registroSQLite(this);
        ed_Correo=(EditText)findViewById(R.id.txtcorreoL);
        ed_Contrasena=(EditText)findViewById(R.id.txtcontraseñaL);
    }

    public void siguiente(View view){

        try {
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            /*Para poder guardar la información que diligencia en usuario, se le asina a la variable de la base de datos
             la variable del EditText*/
            String Correo=ed_Correo.getText().toString();
            String Contrasena=ed_Contrasena.getText().toString();

            /*Se valida si los campos estan vacíos*/
            if(!Correo.isEmpty() && !Contrasena.isEmpty() ){
                /*Se valida si los campos estan en la base de datos*/
                if (nas.validar(Correo,Contrasena, "padre")){

                    registroSQLite.close();
                    Intent atras =new Intent(this, padre.class );
                    startActivity(atras);
                    ed_Correo.setText("");
                    ed_Contrasena.setText("");

                    /*Se valida si los campos estan en la base de datos*/
                }else if(nas.validar(Correo,Contrasena, "niñera")){
                    registroSQLite.close();
                    Intent atras =new Intent(this, ninera.class );
                    startActivity(atras);
                    ed_Correo.setText("");
                    ed_Contrasena.setText("");

                    /*Se valida si los campos estan en la base de datos*/
                } else if (nas.validar(Correo,Contrasena, "administrador")){
                    registroSQLite.close();
                    Intent atras =new Intent(this, administrador.class );
                    startActivity(atras);
                    ed_Correo.setText("");
                    ed_Contrasena.setText("");
                }else{
                    Toast.makeText(this,"El usuario o contraseña son incorrectos",Toast.LENGTH_SHORT).show();
                }
            }else{
                String errorString = "Debe llenar todos los campos";
                Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            System.err.print("Error"+e);
        }
    }
    public void registro(View view){
        Intent registro =new Intent(this, registro.class );
        startActivity(registro);
    }

}
