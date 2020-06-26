package com.example.nas.entidades;

import java.io.Serializable;

public class Nineras implements Serializable {
    /*Se declaran las variables */
    private String cedula;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String clave;
    private String rol;
    private String descripcion;

    public Nineras() {
    }
    /*con las variables declaradas se le asgina su campo y su tipo de dato */
    public Nineras(String cedula, String nombre, String telefono, String direccion, String correo, String clave, String rol, String descripcion) {
        /*Se hace la comparacion de los datos en la base de datos*/
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.clave = clave;
        this.rol = rol;
        this.descripcion = descripcion;
    }
    /*Se hace el get y set de cada campo */

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
