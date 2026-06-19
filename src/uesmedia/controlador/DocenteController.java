/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import uesmedia.dao.DocenteDAO;
import uesmedia.modelo.Docente;
import uesmedia.vista.FrmDocentes;

/**
 *
 * @author emely
 */
public class DocenteController {
    private FrmDocentes vista;
    private DocenteDAO dao;

    public DocenteController(
            FrmDocentes vista) {

        this.vista = vista;
        this.dao = new DocenteDAO();

    }

    // GUARDAR DOCENTE
    public void guardar() {

        Docente d = new Docente();

        d.setCarnet(
                vista.getTxtCarnet().getText()
        );

        d.setNombre(
                vista.getTxtNombre().getText()
        );

        d.setTelefono(
                vista.getTxtTelefono().getText()
        );

        d.setCorreo(
                vista.getTxtCorreo().getText()
        );

        if(dao.insertar(d)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Docente registrado"
            );

            listar();

        } else {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al registrar"
            );

        }

    }

    // LISTAR DOCENTES
    public void listar() {

        ArrayList<Docente> lista =
                dao.listar();

        DefaultTableModel modelo =
                (DefaultTableModel)
                vista.getTblDocentes()
                     .getModel();

        modelo.setRowCount(0);

        for(Docente d : lista){

            modelo.addRow(new Object[]{
                d.getId(),
                d.getCarnet(),
                d.getNombre(),
                d.getTelefono(),
                d.getCorreo()
            });

        }

    }

    // ELIMINAR DOCENTE
    public void eliminar(int id){

        int opcion =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Eliminar docente?"
                );

        if(opcion == JOptionPane.YES_OPTION){

            if(dao.eliminar(id)){

                listar();

            }

        }

    }
}
