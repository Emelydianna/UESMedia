/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.modelo;

/**
 *
 * @author emely
 */
public class DetallePrestamo {

    private int id;
    private int prestamoId;
    private int recursoId;

    private String estadoEntrega;
    private String estadoRetorno;

    // AUXILIAR PARA TABLAS
    private String nombreRecurso;

    // CONSTRUCTOR VACÍO
    public DetallePrestamo() {
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(int recursoId) {
        this.recursoId = recursoId;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getEstadoRetorno() {
        return estadoRetorno;
    }

    public void setEstadoRetorno(String estadoRetorno) {
        this.estadoRetorno = estadoRetorno;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

}