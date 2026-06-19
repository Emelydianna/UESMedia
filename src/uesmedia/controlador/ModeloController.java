/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;
import java.util.ArrayList;

import uesmedia.dao.ModeloDAO;
import uesmedia.modelo.Modelo;
/**
 *
 * @author emely
 */
public class ModeloController {

    private ModeloDAO dao;

    public ModeloController() {

        dao = new ModeloDAO();

    }

    // GUARDAR MODELO
    public boolean guardar(
            int marcaId,
            String nombre) {

        Modelo modelo = new Modelo();

        modelo.setMarcaId(marcaId);
        modelo.setNombre(nombre);

        return dao.insertar(modelo);

    }

    // ACTUALIZAR MODELO
    public boolean actualizar(
            int id,
            int marcaId,
            String nombre) {

        Modelo modelo = new Modelo();

        modelo.setId(id);
        modelo.setMarcaId(marcaId);
        modelo.setNombre(nombre);

        return dao.actualizar(modelo);

    }

    // ELIMINAR MODELO
    public boolean eliminar(int id) {

        return dao.eliminar(id);

    }

    // LISTAR MODELOS
    public ArrayList<Modelo> listar() {

        return dao.listar();

    }
    
    // LISTAR MODELOS POR MARCA
    public ArrayList<Modelo> listarPorMarca(
            int marcaId){

        return dao.listarPorMarca(marcaId);

    }
}
