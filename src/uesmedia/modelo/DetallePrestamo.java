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
    private String nombreRecurso;
    
    public DetallePrestamo() {
    }

    public DetallePrestamo(int id, int prestamoId, int recursoId,
            String estadoEntrega, String estadoRetorno) {

        this.id = id;
        this.prestamoId = prestamoId;
        this.recursoId = recursoId;
        this.estadoEntrega = estadoEntrega;
        this.estadoRetorno = estadoRetorno;
    }

    public int getId() {
        return id;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public int getRecursoId() {
        return recursoId;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public String getEstadoRetorno() {
        return estadoRetorno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public void setRecursoId(int recursoId) {
        this.recursoId = recursoId;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
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
