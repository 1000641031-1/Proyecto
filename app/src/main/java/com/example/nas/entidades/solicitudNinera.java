package com.example.nas.entidades;

public class solicitudNinera {
    /*Se declaran las variables */
    private Integer id_solicitud;
    private Integer cantidad_solicitud;
    private String hora_solicitud;
    private Integer precio_solicitud;
    private String especificar_solicitud;

    public solicitudNinera() {
    }
    /*con las variables declaradas se le asgina su campo y su tipo de dato */
    public solicitudNinera(Integer id_solicitud, Integer cantidad_solicitud, String hora_solicitud, Integer precio_solicitud, String especificar_solicitud) {
        /*Se hace la comparacion de los datos en la base de datos*/
        this.id_solicitud = id_solicitud;
        this.cantidad_solicitud = cantidad_solicitud;
        this.hora_solicitud = hora_solicitud;
        this.precio_solicitud = precio_solicitud;
        this.especificar_solicitud = especificar_solicitud;
    }
    /*Se hace el get y set de cada campo */
    public Integer getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(Integer id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Integer getCantidad_solicitud() {
        return cantidad_solicitud;
    }

    public void setCantidad_solicitud(Integer cantidad_solicitud) {
        this.cantidad_solicitud = cantidad_solicitud;
    }

    public String getHora_solicitud() {
        return hora_solicitud;
    }

    public void setHora_solicitud(String hora_solicitud) {
        this.hora_solicitud = hora_solicitud;
    }

    public Integer getPrecio_solicitud() {
        return precio_solicitud;
    }

    public void setPrecio_solicitud(Integer precio_solicitud) {
        this.precio_solicitud = precio_solicitud;
    }

    public String getEspecificar_solicitud() {
        return especificar_solicitud;
    }

    public void setEspecificar_solicitud(String especificar_solicitud) {
        this.especificar_solicitud = especificar_solicitud;
    }
}
