/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.dao;

import java.sql.*;
import java.util.ArrayList;

import uesmedia.conexion.Conexion;
import uesmedia.modelo.DetallePrestamo;
/**
 *
 * @author emely
 */
public class DetallePrestamoDAO {

    // LISTAR DETALLES DE UN PRÉSTAMO
    public ArrayList<DetallePrestamo> listarPorPrestamo(int prestamoId){

        ArrayList<DetallePrestamo> lista = new ArrayList<>();

        String sql =
        "SELECT dp.*, r.nombre AS nombre_recurso "
        + "FROM detalle_prestamo dp "
        + "INNER JOIN recursos r "
        + "ON dp.recurso_id = r.id "
        + "WHERE dp.prestamo_id = ?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, prestamoId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                DetallePrestamo d = new DetallePrestamo();

                d.setId(rs.getInt("id"));
                d.setPrestamoId(rs.getInt("prestamo_id"));
                d.setRecursoId(rs.getInt("recurso_id"));
                d.setEstadoEntrega(rs.getString("estado_entrega"));
                d.setEstadoRetorno(rs.getString("estado_retorno"));

                // campo auxiliar para JTable
                d.setNombreRecurso(
                        rs.getString("nombre_recurso")
                );

                lista.add(d);
            }

        }catch(Exception e){

            System.out.println(e);

        }

        return lista;
    }

    // REGISTRAR DEVOLUCIÓN DE UN RECURSO
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

            psDetalle.setString(1, estadoRetorno);
            psDetalle.setInt(2, detalleId);

            psDetalle.executeUpdate();

            String estadoRecurso;

            if(estadoRetorno.equals("DEVUELTO")){

                estadoRecurso = "DISPONIBLE";

            }else{

                estadoRecurso = "MANTENIMIENTO";

            }

            String sqlRecurso =
            "UPDATE recursos "
            + "SET estado=? "
            + "WHERE id=?";

            PreparedStatement psRecurso =
            con.prepareStatement(sqlRecurso);

            psRecurso.setString(1, estadoRecurso);
            psRecurso.setInt(2, recursoId);

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

    // VERIFICAR SI TODOS LOS RECURSOS FUERON DEVUELTOS
    public boolean todosDevueltos(int prestamoId){

        String sql =
        "SELECT COUNT(*) total "
        + "FROM detalle_prestamo "
        + "WHERE prestamo_id=? "
        + "AND estado_retorno='PENDIENTE'";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, prestamoId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt("total") == 0;

            }

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // FINALIZAR PRÉSTAMO
    public boolean finalizarPrestamo(int prestamoId){

        String sql =
        "UPDATE prestamos "
        + "SET estado='FINALIZADO' "
        + "WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, prestamoId);

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

}
