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

    // recursos agregados temporalmente
    private ArrayList<DetallePrestamo> detalles;

    public PrestamoController() {

        dao = new PrestamoDAO();

        detalles = new ArrayList<>();

    }

    // OBTENER DETALLES
    public ArrayList<DetallePrestamo> getDetalles() {

        return detalles;

    }

}
