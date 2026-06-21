/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.util;

/**
 *
 * @author emely
 */
public class Validaciones {

    public static boolean campoVacio(
            String texto){

        return texto == null
                || texto.trim().isEmpty();

    }

    public static boolean correoValido(
            String correo){

        return correo.matches(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        );

    }

    public static boolean soloNumeros(
            String texto){

        return texto.matches(
            "\\d+"
        );

    }

    public static boolean telefonoValido(
            String telefono){

        return telefono.matches(
            "\\d{8}"
        );

    }

    public static boolean carnetValido(
            String carnet){

        return carnet != null
                && carnet.length() >= 5;

    }

}