/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uesmedia.modelo;

/**
 *
 * @author emely
 */
public class Docente {


    private int id;
    private String carnet;
    private String nombre;
    private String telefono;
    private String correo;



    public Docente(){

    }



    public int getId(){
        return id;
    }


    public void setId(int id){
        this.id=id;
    }



    public String getCarnet(){
        return carnet;
    }


    public void setCarnet(String carnet){
        this.carnet=carnet;
    }




    public String getNombre(){
        return nombre;
    }


    public void setNombre(String nombre){
        this.nombre=nombre;
    }




    public String getTelefono(){
        return telefono;
    }


    public void setTelefono(String telefono){
        this.telefono=telefono;
    }




    public String getCorreo(){
        return correo;
    }


    public void setCorreo(String correo){
        this.correo=correo;
    }


}
