/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.dao;

import java.sql.*;
import java.util.ArrayList;

import uesmedia.conexion.Conexion;
import uesmedia.modelo.Prestamo;
import uesmedia.modelo.DetallePrestamo;
/**
 *
 * @author emely
 */
public class PrestamoDAO {

    // REGISTRAR PRESTAMO COMPLETO
    public boolean registrarPrestamo(
            Prestamo prestamo,
            ArrayList<DetallePrestamo> detalles){

        Connection con = null;

        try{

            con = Conexion.getConexion();

            // iniciar transacción
            con.setAutoCommit(false);

            String sqlPrestamo =
            "INSERT INTO prestamos("
            + "docente_id,"
            + "fecha_inicio,"
            + "fecha_fin,"
            + "fecha_devolucion,"
            + "estado)"
            + " VALUES(?,?,?,?,?)";

            PreparedStatement psPrestamo =
            con.prepareStatement(
                    sqlPrestamo,
                    Statement.RETURN_GENERATED_KEYS
            );

            psPrestamo.setInt(1, prestamo.getDocenteId());
            psPrestamo.setDate(2, prestamo.getFechaInicio());
            psPrestamo.setDate(3, prestamo.getFechaFin());
            psPrestamo.setDate(4, prestamo.getFechaDevolucion());
            psPrestamo.setString(5, prestamo.getEstado());

            psPrestamo.executeUpdate();

            ResultSet rs =
            psPrestamo.getGeneratedKeys();

            int prestamoId = 0;

            if(rs.next()){

                prestamoId = rs.getInt(1);

            }

            String sqlDetalle =
            "INSERT INTO detalle_prestamo("
            + "prestamo_id,"
            + "recurso_id,"
            + "estado_entrega,"
            + "estado_retorno)"
            + " VALUES(?,?,?,?)";

            String sqlActualizarRecurso =
            "UPDATE recursos "
            + "SET estado='PRESTADO' "
            + "WHERE id=?";

            for(DetallePrestamo detalle : detalles){

                PreparedStatement psDetalle =
                con.prepareStatement(sqlDetalle);

                psDetalle.setInt(1, prestamoId);
                psDetalle.setInt(2, detalle.getRecursoId());
                psDetalle.setString(
                        3,
                        detalle.getEstadoEntrega()
                );
                psDetalle.setString(
                        4,
                        detalle.getEstadoRetorno()
                );

                psDetalle.executeUpdate();

                PreparedStatement psRecurso =
                con.prepareStatement(
                        sqlActualizarRecurso
                );

                psRecurso.setInt(
                        1,
                        detalle.getRecursoId()
                );

                psRecurso.executeUpdate();

            }

            con.commit();

            return true;

        }catch(Exception e){

            try{

                if(con != null){

                    con.rollback();

                }

            }catch(Exception ex){

                System.out.println(ex);

            }

            System.out.println(e);

            return false;

        }finally{

            try{

                if(con != null){

                    con.close();

                }

            }catch(Exception e){

                System.out.println(e);

            }

        }

    }

}
