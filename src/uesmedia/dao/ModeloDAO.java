/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.dao;

import java.sql.*;
import java.util.ArrayList;

import uesmedia.modelo.Modelo;
import uesmedia.conexion.Conexion;
/**
 *
 * @author emely
 */
public class ModeloDAO {

    // INSERTAR MODELO
    public boolean insertar(Modelo m){

        String sql =
        "INSERT INTO modelos(marca_id,nombre) VALUES(?,?)";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, m.getMarcaId());
            ps.setString(2, m.getNombre());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // LISTAR MODELOS
    public ArrayList<Modelo> listar(){

        ArrayList<Modelo> lista = new ArrayList<>();

        String sql = "SELECT * FROM modelos";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Modelo m = new Modelo();

                m.setId(rs.getInt("id"));
                m.setMarcaId(rs.getInt("marca_id"));
                m.setNombre(rs.getString("nombre"));

                lista.add(m);
            }

        }catch(Exception e){

            System.out.println(e);

        }

        return lista;
    }

    // ACTUALIZAR MODELO
    public boolean actualizar(Modelo m){

        String sql =
        "UPDATE modelos SET marca_id=?, nombre=? WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, m.getMarcaId());
            ps.setString(2, m.getNombre());
            ps.setInt(3, m.getId());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // ELIMINAR MODELO
    public boolean eliminar(int id){

        String sql =
        "DELETE FROM modelos WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

}
