/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;
import java.sql.Date;
import java.util.ArrayList;

import uesmedia.dao.RecursoDAO;
import uesmedia.modelo.Recurso;
/**
 *
 * @author emely
 */
public class RecursoController {

    private RecursoDAO dao;

    public RecursoController() {

        dao = new RecursoDAO();

    }

    // GUARDAR RECURSO
    public boolean guardar(
            int modeloId,
            String codigo,
            String nombre,
            String tipo,
            String descripcion,
            String estado,
            boolean enMantenimiento,
            Date fechaRegistro) {

        Recurso recurso = new Recurso();

        recurso.setModeloId(modeloId);
        recurso.setCodigo(codigo);
        recurso.setNombre(nombre);
        recurso.setTipo(tipo);
        recurso.setDescripcion(descripcion);
        recurso.setEstado(estado);
        recurso.setEnMantenimiento(enMantenimiento);
        recurso.setFechaRegistro(fechaRegistro);

        return dao.insertar(recurso);

    }

    // ACTUALIZAR RECURSO
    public boolean actualizar(
            int id,
            int modeloId,
            String codigo,
            String nombre,
            String tipo,
            String descripcion,
            String estado,
            boolean enMantenimiento) {

        Recurso recurso = new Recurso();

        recurso.setId(id);
        recurso.setModeloId(modeloId);
        recurso.setCodigo(codigo);
        recurso.setNombre(nombre);
        recurso.setTipo(tipo);
        recurso.setDescripcion(descripcion);
        recurso.setEstado(estado);
        recurso.setEnMantenimiento(enMantenimiento);

        return dao.actualizar(recurso);

    }

    // ELIMINAR RECURSO
    public boolean eliminar(int id) {

        return dao.eliminar(id);

    }

    // LISTAR RECURSOS
    public ArrayList<Recurso> listar() {

        return dao.listar();

    }
    
    // LISTAR RECURSOS CON DETALLE
    public ArrayList<Recurso> listarConDetalle(){

        return dao.listarConDetalle();

    }

}
