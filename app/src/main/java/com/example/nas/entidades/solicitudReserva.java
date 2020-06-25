package com.example.nas.entidades;

public class solicitudReserva {private Integer Id_reservar;
    private Integer Cantidad_reservar;
    private Integer numero_horas;
    private Integer Precio_reservar;
    private String Hora_reservar;
    private String Fecha_reservar;

        public solicitudReserva() {
        }

        public solicitudReserva(Integer id_reservar, Integer Cantidad_reservar, Integer  numero_horas, Integer Precio_reservar, String Hora_reservar, String Fecha_reservar) {
            this.Id_reservar = id_reservar;
            this.Cantidad_reservar = Cantidad_reservar;
            this.numero_horas = numero_horas;
            this.Precio_reservar = Precio_reservar;
            this.Hora_reservar = Hora_reservar;
            this.Fecha_reservar = Fecha_reservar;
        }

    public Integer getid_reservar() {
        return Id_reservar;
    }

    public void setid_reservar(Integer id_reservar) {
        this.Id_reservar = id_reservar;
    }

    public Integer getCantidad_reservar() {
        return Cantidad_reservar;
    }

    public void setCantidad_reservar(Integer cantidad_reservar) {
        Cantidad_reservar = cantidad_reservar;
    }

    public Integer getnumero_horas() {
        return numero_horas;
    }
    public void setnumero_horas(Integer numero_horas) {
        this.numero_horas = numero_horas;
    }

    public Integer getPrecio_reservar() {
        return Precio_reservar;
    }

    public void setPrecio_reservar(Integer Precio_reservar) {
        this.Precio_reservar = Precio_reservar;
    }

    public String getHora_reservar() {
        return Hora_reservar;
    }

    public void setHora_reservar(String hora_reservar) {
        Hora_reservar = hora_reservar;
    }

    public String getFecha_reservar() {
        return Fecha_reservar;
    }

    public void setFecha_reservar(String fecha_reservar) {
        Fecha_reservar = fecha_reservar;
    }


}
