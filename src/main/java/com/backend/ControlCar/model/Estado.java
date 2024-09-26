package com.backend.ControlCar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estados")
public class Estado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEstado;

    private String nombre;

    public Estado(){
}
    public Estado(long idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}