/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.dao;

import java.sql.*;

import uesmedia.conexion.Conexion;
/**
 *
 * @author emely
 */
public class DetallePrestamoDAO {

    public boolean devolverRecurso(
            int detalleId,
            int recursoId,
            String estadoRetorno){

        Connection con = null;

        try{

            con = Conexion.getConexion();

            con.setAutoCommit(false);

            String sqlDetalle =
            "UPDATE detalle_prestamo "
            + "SET estado_retorno=? "
            + "WHERE id=?";

            PreparedStatement psDetalle =
            con.prepareStatement(sqlDetalle);

            psDetalle.setString(
                    1,
                    estadoRetorno
            );

            psDetalle.setInt(
                    2,
                    detalleId
            );

            psDetalle.executeUpdate();

            String nuevoEstado;

            if(
               estadoRetorno.equals("DEVUELTO")
            ){

                nuevoEstado = "DISPONIBLE";

            }else{

                nuevoEstado = "MANTENIMIENTO";

            }

            String sqlRecurso =
            "UPDATE recursos "
            + "SET estado=? "
            + "WHERE id=?";

            PreparedStatement psRecurso =
            con.prepareStatement(sqlRecurso);

            psRecurso.setString(
                    1,
                    nuevoEstado
            );

            psRecurso.setInt(
                    2,
                    recursoId
            );

            psRecurso.executeUpdate();

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
