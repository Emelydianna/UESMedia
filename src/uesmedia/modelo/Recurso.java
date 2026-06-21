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
public class Recurso {

    private int id;
    private int modeloId;
    private String codigo;
    private String nombre;
    private String tipo;
    private String descripcion;
    private String estado;
    private boolean enMantenimiento;
    private Date fechaRegistro;
    private String nombreMarca;
    private String nombreModelo;

    public Recurso() {
    }

    public Recurso(int id, int modeloId, String codigo, String nombre,
            String tipo, String descripcion, String estado,
            boolean enMantenimiento, Date fechaRegistro) {

        this.id = id;
        this.modeloId = modeloId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.enMantenimiento = enMantenimiento;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public int getModeloId() {
        return modeloId;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModeloId(int modeloId) {
        this.modeloId = modeloId;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEnMantenimiento(boolean enMantenimiento) {
        this.enMantenimiento = enMantenimiento;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getNombreMarca() {
    return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }
    
}
