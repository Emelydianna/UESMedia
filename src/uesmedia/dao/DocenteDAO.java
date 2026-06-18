package uesmedia.dao;


import java.sql.*;
import java.util.ArrayList;

import uesmedia.modelo.Docente;
import uesmedia.conexion.Conexion;


public class DocenteDAO {



    // INSERTAR

    public boolean insertar(Docente d){


        String sql =
        "INSERT INTO docentes(carnet,nombre,telefono,correo)"
        +" VALUES(?,?,?,?)";


        try(Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql)){


            ps.setString(1,d.getCarnet());
            ps.setString(2,d.getNombre());
            ps.setString(3,d.getTelefono());
            ps.setString(4,d.getCorreo());


            return ps.executeUpdate()>0;



        }catch(Exception e){

            System.out.println(e);

        }


        return false;

    }




    // LISTAR

    public ArrayList<Docente> listar(){


        ArrayList<Docente> lista=new ArrayList<>();


        String sql="SELECT * FROM docentes";



        try(Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){



            while(rs.next()){


                Docente d=new Docente();


                d.setId(rs.getInt("id"));
                d.setCarnet(rs.getString("carnet"));
                d.setNombre(rs.getString("nombre"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));


                lista.add(d);

            }



        }catch(Exception e){

            System.out.println(e);

        }


        return lista;

    }





    // ACTUALIZAR


    public boolean actualizar(Docente d){


        String sql =
        "UPDATE docentes SET carnet=?, nombre=?, telefono=?, correo=? WHERE id=?";


        try(Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql)){


            ps.setString(1,d.getCarnet());
            ps.setString(2,d.getNombre());
            ps.setString(3,d.getTelefono());
            ps.setString(4,d.getCorreo());

            ps.setInt(5,d.getId());


            return ps.executeUpdate()>0;



        }catch(Exception e){

            System.out.println(e);

        }


        return false;

    }





    // ELIMINAR


    public boolean eliminar(int id){


        String sql=
        "DELETE FROM docentes WHERE id=?";


        try(Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql)){


            ps.setInt(1,id);


            return ps.executeUpdate()>0;


        }catch(Exception e){

            System.out.println(e);

        }


        return false;

    }



}