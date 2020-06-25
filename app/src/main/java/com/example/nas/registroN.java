package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registroN extends AppCompatActivity {
    SQLiteDatabase.CursorFactory factory;

    private EditText ed_Nombre, ed_Cedula, ed_Telefono, ed_Direccion, ed_Correo, ed_Contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_n);

        ed_Cedula=(EditText)findViewById(R.id.txtCedula2);
        ed_Nombre=(EditText)findViewById(R.id.txtNombre1);
        ed_Telefono=(EditText)findViewById(R.id.txtTelefono2);
        ed_Direccion=(EditText)findViewById(R.id.txtDireccion2);
        ed_Correo=(EditText)findViewById(R.id.txtCorreo3);
        ed_Contrasena=(EditText)findViewById(R.id.txtContraseña3);
    }

    //metodo para dar de alta a los productos
    public void Registrar(View view){
        try {
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            String Cedula=ed_Cedula.getText().toString();
            String Nombre=ed_Nombre.getText().toString();
            String Telefono=ed_Telefono.getText().toString();
            String Direccion=ed_Direccion.getText().toString();
            String Correo=ed_Correo.getText().toString();
            String Contrasena=ed_Contrasena.getText().toString();

            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            String email = Correo;

            Matcher mather = pattern.matcher(email);


            if(!Nombre.isEmpty() && !Cedula.isEmpty() && !Telefono.isEmpty() && !Direccion.isEmpty() && !Correo.isEmpty() && !Contrasena.isEmpty() ){
                if (mather.find() == true) {
                    ContentValues registro=new ContentValues();
                    registro.put("Cedula", Cedula);
                    registro.put("Nombre", Nombre);
                    registro.put("Telefono", Telefono);
                    registro.put("Direccion", Direccion);
                    registro.put("Correo", Correo);
                    registro.put("Contrasena", Contrasena);
                    registro.put("rol", "niñera");

                    registroSQLite.insert("usuarios", null, registro);
                    registroSQLite.close();

                    ed_Nombre.setText("");
                    ed_Cedula.setText("");
                    ed_Telefono.setText("");
                    ed_Direccion.setText("");
                    ed_Correo.setText("");
                    ed_Contrasena.setText("");

                    Intent siguiente =new Intent(this, descripcionPerfil.class );
                    startActivity(siguiente);

                }else{

                    String errorString = "Debe tenero un @ un . y sin espacios";
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

    public void atras(View view){
        Intent atras =new Intent(this, registro.class );
        startActivity(atras);
    }
}
