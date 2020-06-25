package com.example.nas.condiciones;

public class usuario {
     Integer Cedula;
     String Nombre ;
     String Direccion ;
     String Telefono ;
     String  Correo;
     String  Contrasena;

    /**
     * Contructor
     * @param cedula
     * @param nombre
     * @param direccion
     * @param telefono
     * @param correo
     * @param contrasena
     */
    public usuario(Integer cedula, String nombre, String direccion, String telefono, String correo, String contrasena) {
        Cedula = cedula;
        Nombre = nombre;
        Direccion = direccion;
        Telefono = telefono;
        Correo = correo;
        Contrasena = contrasena;
    }

    public usuario() {

    }

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
}
