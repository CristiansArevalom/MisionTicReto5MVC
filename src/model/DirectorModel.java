/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author I5-9600K
 */
public class DirectorModel {
    
    private int dir_id_director;
    private String dir_nombre;
    private String dir_apellido;
    private String nacionalidad;
    
    public DirectorModel (int dir_id_director,String dir_nombre,String dir_apellido,String nacionalidad){
        this.dir_id_director= dir_id_director;
        this.dir_nombre = dir_nombre;
        this.dir_apellido=dir_apellido;
        this.nacionalidad=nacionalidad;
    }

    /**
     * @return the dir_id_director
     */
    public int getDir_id_director() {
        return dir_id_director;
    }

    /**
     * @param dir_id_director the dir_id_director to set
     */
    public void setDir_id_director(int dir_id_director) {
        this.dir_id_director = dir_id_director;
    }

    /**
     * @return the dir_nombre
     */
    public String getDir_nombre() {
        return dir_nombre;
    }

    /**
     * @param dir_nombre the dir_nombre to set
     */
    public void setDir_nombre(String dir_nombre) {
        this.dir_nombre = dir_nombre;
    }

    /**
     * @return the dir_apellido
     */
    public String getDir_apellido() {
        return dir_apellido;
    }

    /**
     * @param dir_apellido the dir_apellido to set
     */
    public void setDir_apellido(String dir_apellido) {
        this.dir_apellido = dir_apellido;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
}
