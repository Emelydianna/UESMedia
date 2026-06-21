/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;
import java.util.ArrayList;

import uesmedia.dao.DetallePrestamoDAO;
import uesmedia.modelo.DetallePrestamo;

/**
 *
 * @author emely
 */
public class DetallePrestamoController {

    private DetallePrestamoDAO dao;

    public DetallePrestamoController() {

        dao = new DetallePrestamoDAO();

    }

    // LISTAR DETALLES DE UN PRÉSTAMO
    public ArrayList<DetallePrestamo> listarPorPrestamo(
            int prestamoId) {

        return dao.listarPorPrestamo(
                prestamoId
        );

    }

    // DEVOLVER RECURSO
    public boolean devolverRecurso(
            int detalleId,
            int recursoId,
            String estadoRetorno) {

        return dao.devolverRecurso(
                detalleId,
                recursoId,
                estadoRetorno
        );

    }

    // VERIFICAR SI TODOS LOS RECURSOS FUERON DEVUELTOS
    public boolean todosDevueltos(
            int prestamoId) {

        return dao.todosDevueltos(
                prestamoId
        );

    }

    // FINALIZAR PRÉSTAMO
    public boolean finalizarPrestamo(
            int prestamoId) {

        return dao.finalizarPrestamo(
                prestamoId
        );

    }

    // PROCESO COMPLETO DE DEVOLUCIÓN
    public boolean procesarDevolucion(
            int prestamoId,
            int detalleId,
            int recursoId,
            String estadoRetorno) {

        boolean devuelto =
                dao.devolverRecurso(
                        detalleId,
                        recursoId,
                        estadoRetorno
                );

        if(!devuelto) {

            return false;

        }

        if(dao.todosDevueltos(prestamoId)) {

            dao.finalizarPrestamo(
                    prestamoId
            );

        }

        return true;

    }

}