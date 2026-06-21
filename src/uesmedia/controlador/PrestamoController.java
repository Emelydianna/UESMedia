/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;
import java.sql.Date;
import java.util.ArrayList;

import uesmedia.dao.PrestamoDAO;
import uesmedia.modelo.DetallePrestamo;
import uesmedia.modelo.Prestamo;
/**
 *
 * @author emely
 */
public class PrestamoController {

    private PrestamoDAO dao;

    // Lista temporal de recursos seleccionados
    private ArrayList<DetallePrestamo> detalles;

    public PrestamoController() {

        dao = new PrestamoDAO();
        detalles = new ArrayList<>();

    }

    // OBTENER DETALLES
    public ArrayList<DetallePrestamo> getDetalles() {

        return detalles;

    }

    // AGREGAR RECURSO AL PRÉSTAMO
    public boolean agregarRecurso(
            int recursoId,
            String nombreRecurso) {

        // evitar duplicados
        for (DetallePrestamo d : detalles) {

            if (d.getRecursoId() == recursoId) {

                return false;

            }

        }

        DetallePrestamo detalle =
                new DetallePrestamo();

        detalle.setRecursoId(recursoId);

        detalle.setNombreRecurso(
                nombreRecurso
        );

        detalle.setEstadoEntrega(
                "ENTREGADO"
        );

        detalle.setEstadoRetorno(
                "PENDIENTE"
        );

        detalles.add(detalle);

        return true;

    }

    // QUITAR RECURSO
    public boolean quitarRecurso(
            int recursoId) {

        return detalles.removeIf(
                d -> d.getRecursoId() == recursoId
        );

    }

    // LIMPIAR LISTA TEMPORAL
    public void limpiarDetalles() {

        detalles.clear();

    }

    // VALIDAR SI HAY RECURSOS
    public boolean tieneRecursos() {

        return !detalles.isEmpty();

    }

    // CANTIDAD DE RECURSOS
    public int cantidadRecursos() {

        return detalles.size();

    }

    // GUARDAR PRÉSTAMO
    public boolean guardarPrestamo(
        int docenteId,
        Date fechaInicio,
        Date fechaFin) {

        if(detalles.isEmpty()) {

            return false;

        }

        if(fechaInicio == null || fechaFin == null) {

            return false;

        }

        if(fechaFin.before(fechaInicio)) {

            return false;

        }

        Prestamo prestamo =
                new Prestamo();

        prestamo.setDocenteId(
                docenteId
        );

        prestamo.setFechaInicio(
                fechaInicio
        );

        prestamo.setFechaFin(
                fechaFin
        );

        prestamo.setFechaDevolucion(
                null
        );

        prestamo.setEstado(
                "ACTIVO"
        );

        boolean resultado =
                dao.registrarPrestamo(
                        prestamo,
                        detalles
                );

        if(resultado) {

            detalles.clear();

        }

        return resultado;
    }

}
