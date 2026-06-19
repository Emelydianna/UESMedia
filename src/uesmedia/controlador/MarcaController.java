/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;
import java.util.ArrayList;

import uesmedia.dao.MarcaDAO;
import uesmedia.modelo.Marca;
/**
 *
 * @author emely
 */
public class MarcaController {

    private MarcaDAO dao;

    public MarcaController() {

        dao = new MarcaDAO();

    }

    // GUARDAR MARCA
    public boolean guardar(String nombre) {

        Marca marca = new Marca();

        marca.setNombre(nombre);

        return dao.insertar(marca);

    }

    // ACTUALIZAR MARCA
    public boolean actualizar(int id, String nombre) {

        Marca marca = new Marca();

        marca.setId(id);
        marca.setNombre(nombre);

        return dao.actualizar(marca);

    }

    // ELIMINAR MARCA
    public boolean eliminar(int id) {

        return dao.eliminar(id);

    }

    // LISTAR MARCAS
    public ArrayList<Marca> listar() {

        return dao.listar();

    }

}
