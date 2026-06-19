/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.modelo;

import java.sql.Date;

/**
 *
 * @author emely
 */
public class Prestamo {

    private int id;
    private int docenteId;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaDevolucion;
    private String estado;

    public Prestamo() {
    }

    public Prestamo(int id, int docenteId, Date fechaInicio,
            Date fechaFin, Date fechaDevolucion, String estado) {

        this.id = id;
        this.docenteId = docenteId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getDocenteId() {
        return docenteId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
