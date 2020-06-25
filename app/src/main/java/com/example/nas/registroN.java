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

    /*Se le asigna una variable para los EditText */
    private EditText ed_Nombre, ed_Cedula, ed_Telefono, ed_Direccion, ed_Correo, ed_Contrasena, ed_Descripcion;

    /*Se crea la actividad registroN*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_n);
        /*Lo que el usuario ponga el las variables de texto tambien quedan en los EditText */
        ed_Cedula=(EditText)findViewById(R.id.txtCedula2);
        ed_Nombre=(EditText)findViewById(R.id.txtNombre1);
        ed_Telefono=(EditText)findViewById(R.id.txtTelefono2);
        ed_Direccion=(EditText)findViewById(R.id.txtDireccion2);
        ed_Correo=(EditText)findViewById(R.id.txtCorreo3);
        ed_Contrasena=(EditText)findViewById(R.id.txtContraseña3);
        ed_Descripcion=(EditText)findViewById(R.id.txtDescripcion);

    }


    public void Registrar(View view){
        try {
            /*Se llama la base de datos*/
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            /*Para poder guardar la información que diligencia en usuario, se le asina a la variable de la base de datos
             la variable del EditText*/
            String Cedula=ed_Cedula.getText().toString();
            String Nombre=ed_Nombre.getText().toString();
            String Telefono=ed_Telefono.getText().toString();
            String Direccion=ed_Direccion.getText().toString();
            String Correo=ed_Correo.getText().toString();
            String Contrasena=ed_Contrasena.getText().toString();
            String descripcion=ed_Descripcion.getText().toString();

            /*Método para la validación del correo*/
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            String email = Correo;
            Matcher mather = pattern.matcher(email);

            /*Se valida si los campos estan vacíos*/
            if(!Nombre.isEmpty() && !Cedula.isEmpty() && !Telefono.isEmpty() && !Direccion.isEmpty() && !Correo.isEmpty() && !Contrasena.isEmpty() ){

                /*Se valida si el correo esta escrito correctamente, es decir que tenga un arroa, un punto y que no tenga espacios*/
                if (mather.find() == true) {

                    /*Se guarda lo que ingrese el usuario en la balse de datos*/
                    ContentValues registro=new ContentValues();
                    registro.put("Cedula", Cedula);
                    registro.put("Nombre", Nombre);
                    registro.put("Telefono", Telefono);
                    registro.put("Direccion", Direccion);
                    registro.put("Correo", Correo);
                    registro.put("Contrasena", Contrasena);
                    registro.put("rol", "niñera");
                    registro.put("descripcion", descripcion);

                    registroSQLite.insert("usuarios", null, registro);
                    registroSQLite.close();

                    ed_Nombre.setText("");
                    ed_Cedula.setText("");
                    ed_Telefono.setText("");
                    ed_Direccion.setText("");
                    ed_Correo.setText("");
                    ed_Contrasena.setText("");
                    ed_Descripcion.setText("");


                    String errorString = "Registro exitoso";
                    Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();

                    Intent siguiente =new Intent(this, MainActivity.class );
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
