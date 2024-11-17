package com.curso.ecommerce.sprintecommerce.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ordenes")

public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    @ManyToOne
    private Usuario usuario;
    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalleOrden;

    public Orden(int idOrden) {}

    public Orden(int idOrden, String numero, Date fechaCreacion, Date fechaRecibida) {
        this.idOrden = idOrden;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public DetalleOrden getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(DetalleOrden detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "idOrden=" + idOrden +
                ", numero='" + numero + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaRecibida=" + fechaRecibida +
                ", usuario=" + usuario +
                ", detalleOrden=" + detalleOrden +
                '}';
    }
}
