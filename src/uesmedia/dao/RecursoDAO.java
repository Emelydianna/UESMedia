/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.dao;

import java.sql.*;
import java.util.ArrayList;

import uesmedia.modelo.Recurso;
import uesmedia.conexion.Conexion;
/**
 *
 * @author emely
 */
public class RecursoDAO {

    // INSERTAR RECURSO
    public boolean insertar(Recurso r){

        String sql =
        "INSERT INTO recursos("
        + "modelo_id,codigo,nombre,tipo,"
        + "descripcion,estado,en_mantenimiento,"
        + "fecha_registro)"
        + " VALUES(?,?,?,?,?,?,?,?)";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, r.getModeloId());
            ps.setString(2, r.getCodigo());
            ps.setString(3, r.getNombre());
            ps.setString(4, r.getTipo());
            ps.setString(5, r.getDescripcion());
            ps.setString(6, r.getEstado());
            ps.setBoolean(7, r.isEnMantenimiento());
            ps.setDate(8, r.getFechaRegistro());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // LISTAR RECURSOS
    public ArrayList<Recurso> listar(){

        ArrayList<Recurso> lista = new ArrayList<>();

        String sql = "SELECT * FROM recursos";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Recurso r = new Recurso();

                r.setId(rs.getInt("id"));
                r.setModeloId(rs.getInt("modelo_id"));
                r.setCodigo(rs.getString("codigo"));
                r.setNombre(rs.getString("nombre"));
                r.setTipo(rs.getString("tipo"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getString("estado"));
                r.setEnMantenimiento(rs.getBoolean("en_mantenimiento"));
                r.setFechaRegistro(rs.getDate("fecha_registro"));

                lista.add(r);
            }

        }catch(Exception e){

            System.out.println(e);

        }

        return lista;
    }

    // ACTUALIZAR RECURSO
    public boolean actualizar(Recurso r){

        String sql =
        "UPDATE recursos SET "
        + "modelo_id=?,"
        + "codigo=?,"
        + "nombre=?,"
        + "tipo=?,"
        + "descripcion=?,"
        + "estado=?,"
        + "en_mantenimiento=? "
        + "WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, r.getModeloId());
            ps.setString(2, r.getCodigo());
            ps.setString(3, r.getNombre());
            ps.setString(4, r.getTipo());
            ps.setString(5, r.getDescripcion());
            ps.setString(6, r.getEstado());
            ps.setBoolean(7, r.isEnMantenimiento());
            ps.setInt(8, r.getId());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // ELIMINAR RECURSO
    public boolean eliminar(int id){

        String sql =
        "DELETE FROM recursos WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }
    // LISTAR RECURSOS CON MARCA Y MODELO
    public ArrayList<Recurso> listarConDetalle(){

        ArrayList<Recurso> lista =
                new ArrayList<>();

        String sql =
        "SELECT r.*, "
        + "m.nombre AS modelo, "
        + "ma.nombre AS marca "
        + "FROM recursos r "
        + "INNER JOIN modelos m "
        + "ON r.modelo_id = m.id "
        + "INNER JOIN marcas ma "
        + "ON m.marca_id = ma.id";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ResultSet rs =
                    ps.executeQuery()){

            while(rs.next()){

                Recurso r = new Recurso();

                r.setId(rs.getInt("id"));
                r.setModeloId(rs.getInt("modelo_id"));
                r.setCodigo(rs.getString("codigo"));
                r.setNombre(rs.getString("nombre"));
                r.setTipo(rs.getString("tipo"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getString("estado"));
                r.setEnMantenimiento(
                        rs.getBoolean(
                                "en_mantenimiento"
                        )
                );

                r.setFechaRegistro(
                        rs.getDate(
                                "fecha_registro"
                        )
                );

                r.setNombreMarca(
                        rs.getString("marca")
                );

                r.setNombreModelo(
                        rs.getString("modelo")
                );

                lista.add(r);

            }

        }catch(Exception e){

            System.out.println(e);

        }

        return lista;

    }
    //Contador 
    public int contarRecursos() {
        int total = 0;

        String sql = "SELECT COUNT(*) FROM recursos";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
    
    //Contador para mantenimiento
    public int contarRecursosMantenimiento() {
        int total = 0;

        String sql =
            "SELECT COUNT(*) FROM recursos WHERE en_mantenimiento = true";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
    //Contador recursos disponibles 
    public int contarDisponibles() {

        int total = 0;

        String sql =
            "SELECT COUNT(*) FROM recursos WHERE en_mantenimiento = false";

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
