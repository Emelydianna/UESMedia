/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.controlador;

import javax.swing.JOptionPane;

import uesmedia.dao.UsuarioDAO;
import uesmedia.modelo.Usuario;
import uesmedia.util.Sesion;

import uesmedia.vista.FrmLogin;
import uesmedia.vista.FrmDashboard;
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

    // INICIAR SESIÓN
    public void iniciarSesion() {

        String correo =
                vista.getTxtCorreo().getText().trim();

        String password =
                String.valueOf(
                        vista.getTxtPassword().getPassword()
                );

        if(correo.isEmpty() || password.isEmpty()) {

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

            // guardar usuario en sesión
            Sesion.usuarioActual = usuario;

            JOptionPane.showMessageDialog(
                    vista,
                    "Bienvenido " + usuario.getNombre()
            );

            FrmDashboard dashboard =
                    new FrmDashboard();

            dashboard.setVisible(true);

            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(
                    vista,
                    "Correo o contraseña incorrectos"
            );
        }

    }

    // RECUPERAR CONTRASEÑA
    public void recuperarPassword() {

        String correo =
                JOptionPane.showInputDialog(
                        vista,
                        "Ingrese su correo"
                );

        if(correo == null || correo.isEmpty()) {

            return;
        }

        boolean existe =
                usuarioDAO.existeCorreo(correo);

        if(!existe) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Correo no encontrado"
            );

            return;
        }

        String nuevaPassword =
                JOptionPane.showInputDialog(
                        vista,
                        "Nueva contraseña"
                );

        if(nuevaPassword == null
                || nuevaPassword.isEmpty()) {

            return;
        }

        boolean actualizado =
                usuarioDAO.cambiarPassword(
                        correo,
                        nuevaPassword
                );

        if(actualizado){

            JOptionPane.showMessageDialog(
                    vista,
                    "Contraseña actualizada"
            );

        }else{

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al actualizar"
            );

        }

    }
}
