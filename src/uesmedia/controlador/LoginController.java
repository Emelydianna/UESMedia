/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;

import javax.swing.JOptionPane;

import uesmedia.dao.UsuarioDAO;
import uesmedia.modelo.Usuario;
import uesmedia.util.Sesion;
import uesmedia.vista.FrmDashboard;
import uesmedia.vista.FrmLogin;
/**
 *
 * @author emely
 */
public class LoginController {

    private FrmLogin vista;
    private UsuarioDAO usuarioDAO;

    public LoginController(FrmLogin vista) {

        this.vista = vista;
        this.usuarioDAO = new UsuarioDAO();

    }

    public void iniciarSesion() {

        String correo =
                vista.getTxtCorreo()
                        .getText()
                        .trim();

        String password =
                String.valueOf(
                        vista.getTxtPassword()
                                .getPassword()
                );

        if(correo.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Debe completar todos los campos"
            );

            return;
        }

        Usuario usuario =
                usuarioDAO.iniciarSesion(
                        correo,
                        password
                );

        if(usuario != null) {

            Sesion.usuarioActual =
                    usuario;

            JOptionPane.showMessageDialog(
                    vista,
                    "Bienvenido "
                    + usuario.getNombre()
            );

            FrmDashboard dashboard =
                    new FrmDashboard();

            dashboard.setLocationRelativeTo(
                    null
            );

            dashboard.setVisible(
                    true
            );

            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(
                    vista,
                    "Correo o contraseña incorrectos"
            );

        }

    }

}