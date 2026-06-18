/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * CONFIGURACIÓN DE BASE DE DATOS
 *
 * Este proyecto utiliza el archivo:
 *
 * config/database.properties
 *
 * modificar:
 *
 * db.url
 * db.user
 * db.password
 *
 * según su entorno local.
 *
 * Ejemplo XAMPP:
 * db.user=root
 * db.password=
 */
/**
 *
 * @author emely
 */
public class Conexion {
    
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {

        try {

            Properties props = new Properties();

            props.load(
                new FileInputStream(
                    "config/database.properties"
                )
            );

            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");

        } catch (IOException e) {

            System.out.println(
                "Error cargando configuración: "
                + e.getMessage()
            );
        }
    }

    public static Connection getConexion() {

        try {

            return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
            );

        } catch (SQLException e) {

            System.out.println(
                "Error de conexión: "
                + e.getMessage()
            );

            return null;
        }
    }
}
