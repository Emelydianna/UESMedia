package uesmedia.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import uesmedia.modelo.Usuario;
import uesmedia.conexion.Conexion;

public class UsuarioDAO {


    // LOGIN
    public Usuario iniciarSesion(String correo, String password){


        String sql = 
        "SELECT * FROM usuarios WHERE correo=? AND password=?";


        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){


            ps.setString(1, correo);
            ps.setString(2, password);


            ResultSet rs = ps.executeQuery();


            if(rs.next()){


                Usuario u = new Usuario();


                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));


                return u;

            }


        }catch(Exception e){

            System.out.println("Error login: "+e);

        }


        return null;

    }



    // VERIFICAR SI EXISTE EL CORREO
    // antes de cambiar contraseña

    public boolean existeCorreo(String correo){


        String sql =
        "SELECT id FROM usuarios WHERE correo=?";


        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){


            ps.setString(1, correo);


            ResultSet rs = ps.executeQuery();


            return rs.next();



        }catch(Exception e){

            System.out.println(e);

        }


        return false;

    }




    // CAMBIAR CONTRASEÑA

    public boolean cambiarPassword(String correo, String nuevaPassword){


        String sql =
        "UPDATE usuarios SET password=? WHERE correo=?";


        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){


            ps.setString(1,nuevaPassword);
            ps.setString(2,correo);


            return ps.executeUpdate() > 0;



        }catch(Exception e){

            System.out.println(e);

        }


        return false;

    }



}