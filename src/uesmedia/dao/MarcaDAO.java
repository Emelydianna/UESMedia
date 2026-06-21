/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.dao;

import java.sql.*;
import java.util.ArrayList;

import uesmedia.modelo.Marca;
import uesmedia.conexion.Conexion;
/**
 *
 * @author emely
 */
public class MarcaDAO {

    // INSERTAR MARCA
    public boolean insertar(Marca m){

        String sql =
        "INSERT INTO marcas(nombre) VALUES(?)";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, m.getNombre());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // LISTAR MARCAS
    public ArrayList<Marca> listar(){

        ArrayList<Marca> lista = new ArrayList<>();

        String sql = "SELECT * FROM marcas";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Marca m = new Marca();

                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));

                lista.add(m);
            }

        }catch(Exception e){

            System.out.println(e);

        }

        return lista;
    }

    // ACTUALIZAR MARCA
    public boolean actualizar(Marca m){

        String sql =
        "UPDATE marcas SET nombre=? WHERE id=?";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getId());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }

    // ELIMINAR MARCA
    public boolean eliminar(int id){

        String sql =
        "DELETE FROM marcas WHERE id=?";

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
