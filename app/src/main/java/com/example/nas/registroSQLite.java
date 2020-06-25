package com.example.nas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.example.nas.condiciones.usuario;

public class registroSQLite extends SQLiteOpenHelper{
    public registroSQLite(Context context) {
        super(context, "nas",  null, 1);
    }
    /* Validar si el correo y la contraaseña en en la base de datos*/
    public boolean validar(String Correo, String Contrasena, String rol){
        if (Correo.compareTo("andreatehortua613@gmail.com") ==0 && Contrasena.compareTo("andreag1") ==0 && rol.compareTo("administrador") ==0){
            return true;
        }
        String sql ="select count(*) from usuarios where Correo='" +Correo+"' and Contrasena='"+Contrasena+"' and rol='"+rol+"'";
        SQLiteStatement statement= getReadableDatabase().compileStatement(sql);
        long valor=statement.simpleQueryForLong();
        if(valor==1){
            return true;
        }else{
            return false;
        }
    }

    /*Se crea la base de datos llamada nas y las tablas de ella*/
    @Override
    public void onCreate(SQLiteDatabase nas) {

        nas.execSQL("create table usuarios(Cedula integer primary key ,Nombre text," +
                "Telefono int,Direccion text,Correo text,Contrasena text, rol text, descripcion text)");

        nas.execSQL("create table tbl_solicitud(id_solicitud integer primary key AUTOINCREMENT,Cantidad_soli float," +
                "Horas_soli float,Precio_soli float, Especificar_soli text)");

        nas.execSQL("Create table tbl_reservaninera(id_reservar integer primary key AUTOINCREMENT, Cantidad_reservar int, " +
                "Numero_reservar int, Precio_reservar float, Hora_reservar text,Fecha_reservar text  )");

        nas.execSQL("Create table tbl_reserva(id_reservar integer primary key AUTOINCREMENT, Precio_reservar float, " +
                "Cantidad_reserva int, Fecha_reservar text, Hora_reservar text )");
    }
    @Override

    /*Si ya estan creadas las tablas se eliminan y se vuelve a crear*/
    public void onUpgrade(SQLiteDatabase nas, int oldVersion, int newVersion) {
        nas.execSQL("drop table if exists usuarios");
        nas.execSQL("create table usuarios(Cedula integer primary key ,Nombre text," +
                "Telefono int,Direccion text,Correo text,Contrasena text, rol text)");

        nas.execSQL("drop table if exists tbl_solicitud");
        nas.execSQL("create table tbl_solicitud(id_solicitud integer primary key AUTOINCREMENT,Cantidad_soli float," +
                "Horasoli float,Precio_soli float, Especificar_soli text)");

        nas.execSQL("drop table if exists tbl_reservaninera");
        nas.execSQL("Create table tbl_reservaninera(id_reservar integer primary key AUTOINCREMENT, Nombre_reservar text, Precio_reservar float, " +
                "Cantidad_reservar int, Fecha_reservar text, Hora_reservar time )");

    }
    /*Busca los campos de teléfono, correo y direccion*/
    public usuario buscar(usuario usuario, String Cedula){
        SQLiteDatabase registroSQLite= getReadableDatabase();
        Cursor cursor =registroSQLite.rawQuery("select Cedula, Telefono, Correo, Direccion  from usuarios where Cedula='"+Cedula+"'", null);
        if(cursor.moveToFirst()){
            do{
                usuario.setTelefono(cursor.getString(1));
                usuario.setCorreo(cursor.getString(2));
                usuario.setDireccion(cursor.getString(3));
            }while(cursor.moveToNext());
        }
        return usuario;
    }
    /*Busca el campo de contraseña*/
    public usuario buscar1(usuario usuario, String Cedula){
        SQLiteDatabase registroSQLite= getReadableDatabase();
        Cursor cursor =registroSQLite.rawQuery("select Cedula, Contrasena  from usuarios where Cedula='"+Cedula+"'", null);
        if(cursor.moveToFirst()){
            do{
                usuario.setContrasena(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        return usuario;
    }
    /*Busca el registro de los perfiles niñera y padre*/
    public usuario buscar2(usuario usuario, String Cedula){
        SQLiteDatabase registroSQLite= getReadableDatabase();
        Cursor cursor =registroSQLite.rawQuery("select Cedula, Nombre, Correo, Telefono, Direccion from usuarios where Cedula='"+Cedula+"'", null);
        if(cursor.moveToFirst()){
            do{
                usuario.setNombre(cursor.getString(1));
                usuario.setCorreo(cursor.getString(2));
                usuario.setTelefono(cursor.getString(3));
                usuario.setDireccion(cursor.getString(4));


            }while(cursor.moveToNext());
        }
        return usuario;
    }
    /*Actualizar información*/
    public void actualizar(String Cedula, String Telefono, String Correo, String Direccion) {
        SQLiteDatabase registroSQLite = getWritableDatabase();
        if (registroSQLite != null) {
            registroSQLite.execSQL("update usuarios set Telefono='" + Telefono + "', Correo='" + Correo + "', Direccion='" + Direccion + "'" +
                    " where Cedula='" + Cedula + "'");
            registroSQLite.close();
        }
    }
    /*Cambiar contraseña*/
    public void cambiar(String Cedula, String Contrasena) {
        SQLiteDatabase registroSQLite = getWritableDatabase();
        if (registroSQLite != null) {
            registroSQLite.execSQL("update usuarios set Contrasena='" + Contrasena + "'" +
                    " where Cedula='" + Cedula + "'");
            registroSQLite.close();
        }
    }
    /*Eliminar registros*/
    public void eliminar(String Cedula){
        SQLiteDatabase registroSQLite=getWritableDatabase();
        if(registroSQLite!=null){
            registroSQLite.execSQL("delete from usuarios where Cedula='"+Cedula+"'");
            registroSQLite.close();
        }
    }
}
