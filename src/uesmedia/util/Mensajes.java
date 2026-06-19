/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.util;

import javax.swing.JOptionPane;
/**
 *
 * @author emely
 */
public class Mensajes {

    public static void informacion(String mensaje){

        JOptionPane.showMessageDialog(
                null,
                mensaje
        );

    }

    public static void error(String mensaje){

        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

    }

}
