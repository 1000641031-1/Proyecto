package com.example.nas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;



































import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class descripcionPerfil extends AppCompatActivity {
    ImageView imagen;
     private EditText ed_Descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_perfil);
        imagen=(ImageView)findViewById(R.id.imagenId);
        ed_Descripcion=(EditText)findViewById(R.id.txtDescripcion);
    }

    public void onclick (View view){
        cargarimagen();
    }

    private void cargarimagen() {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("/imagen");
        startActivityForResult(intent.createChooser(intent, "Seleccione la aplicación"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }

    public void descripcion(View view){
        try {
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            String descripcionPerfil=ed_Descripcion.getText().toString();

            if(!descripcionPerfil.isEmpty()){
                    ContentValues registro=new ContentValues();
                registro.put("descripcionPerfil", descripcionPerfil);

                    registroSQLite.insert("usuarios", null, registro);
                    registroSQLite.close();

                    ed_Descripcion.setText("");

                    String correString = "Registro exitoso";
                    Toast.makeText(getApplicationContext(), correString, Toast.LENGTH_SHORT).show();

                    Intent siguiente =new Intent(this, MainActivity.class );
                    startActivity(siguiente);
            } else {
                String errorString = "Debe llenar todos los campos";
                Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            System.err.print("Error"+e);
        }
    }
}