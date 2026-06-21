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

    // LISTAR PRÉSTAMOS
    public ArrayList<Prestamo> listar() {

        ArrayList<Prestamo> lista = new ArrayList<>();

        String sql = "SELECT * FROM prestamos";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                Prestamo p = new Prestamo();

                p.setId(rs.getInt("id"));
                p.setDocenteId(rs.getInt("docente_id"));
                p.setFechaInicio(rs.getDate("fecha_inicio"));
                p.setFechaFin(rs.getDate("fecha_fin"));
                p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
                p.setEstado(rs.getString("estado"));

                lista.add(p);
            }

        } catch(Exception e) {

            System.out.println(e);

        }

        return lista;
    }

    // BUSCAR PRÉSTAMO POR ID
    public Prestamo buscar(int id) {

        String sql =
        "SELECT * FROM prestamos WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                Prestamo p = new Prestamo();

                p.setId(rs.getInt("id"));
                p.setDocenteId(rs.getInt("docente_id"));
                p.setFechaInicio(rs.getDate("fecha_inicio"));
                p.setFechaFin(rs.getDate("fecha_fin"));
                p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
                p.setEstado(rs.getString("estado"));

                return p;
            }

        } catch(Exception e) {

            System.out.println(e);

        }

        return null;
    }

    // REGISTRAR PRESTAMO COMPLETO
    public boolean registrarPrestamo(
            Prestamo prestamo,
            ArrayList<DetallePrestamo> detalles){

        Connection con = null;

        try{

            con = Conexion.getConexion();

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

            ResultSet rs = psPrestamo.getGeneratedKeys();

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
                psDetalle.setString(3, detalle.getEstadoEntrega());
                psDetalle.setString(4, detalle.getEstadoRetorno());

                psDetalle.executeUpdate();

                PreparedStatement psRecurso =
                con.prepareStatement(sqlActualizarRecurso);

                psRecurso.setInt(
                        1,
                        detalle.getRecursoId()
                );

                psRecurso.executeUpdate();
            }

            con.commit();

            return true;

        } catch(Exception e){

            try{

                if(con != null){

                    con.rollback();

                }

            } catch(Exception ex){

                System.out.println(ex);

            }

            System.out.println(e);

            return false;

        } finally {

            try{

                if(con != null){

                    con.close();

                }

            } catch(Exception e){

                System.out.println(e);

            }

        }

    }
    //Método de disponibilidad del recurso 
    public boolean recursoDisponible(
        int recursoId){

        String sql =
        "SELECT estado "
        + "FROM recursos "
        + "WHERE id=?";

        try(Connection con =
                Conexion.getConexion();

            PreparedStatement ps =
                con.prepareStatement(sql)){

            ps.setInt(1,recursoId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()){

                return rs.getString(
                        "estado"
                ).equals(
                        "DISPONIBLE"
                );

            }

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }
    //Contar prestamos activos
    public int contarPrestamosActivos() {

        int total = 0;

        String sql =
            "SELECT COUNT(*) FROM prestamos WHERE estado='ACTIVO'";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if(rs.next()){
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
    //Contar prestamos vencidos 
    public int contarPrestamosVencidos() {

        int total = 0;

        String sql =
            "SELECT COUNT(*) FROM prestamos " +
            "WHERE fecha_fin < CURDATE() " +
            "AND estado='ACTIVO'";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if(rs.next()){
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
    
}
