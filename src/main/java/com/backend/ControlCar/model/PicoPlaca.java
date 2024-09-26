package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PicoPlacas")
public class PicoPlaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPicoPlaca;
    private LocalDateTime dia;

    private int numero;

    private boolean vigente;

    public PicoPlaca() {
    }

    public PicoPlaca(LocalDateTime dia, int numero, boolean vigente) {
        this.dia = dia;
        this.numero = numero;
        this.vigente = vigente;
    }

    public int getIdPicoPlaca() {
        return idPicoPlaca;
    }

    public void setIdPicoPlaca(int idPicoPlaca) {
        this.idPicoPlaca = idPicoPlaca;
    }

    public LocalDateTime getDia() {
        return dia;
    }

    public void setDia(LocalDateTime dia) {
        this.dia = dia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
}