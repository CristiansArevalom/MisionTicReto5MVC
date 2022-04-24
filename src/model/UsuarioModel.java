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
public class UsuarioModel {

    /**
     * @return the usr_fecha_nacimiento
     */

    private String usr_username;
    private String usr_nombre;
    private String usr_apellido;
    private String usr_email;
    private long usr_celular;
    private String usr_contraseña;
    private String usr_fecha_nacimiento;
    
    public UsuarioModel(){
        
    }
    
    public UsuarioModel(String usr_username,String usr_nombre,String usr_apellido,String usr_email,long usr_celular,String usr_contraseña,String usr_fecha_nacimiento){
        this.usr_username = usr_username;
        this.usr_nombre = usr_nombre;
        this.usr_apellido = usr_apellido;
        this.usr_email = usr_email;
        this.usr_celular = usr_celular;
        this.usr_contraseña = usr_contraseña;
        this.usr_fecha_nacimiento= usr_fecha_nacimiento;
    }

    /**
     * @return the usr_username
     */
    public String getUsr_username() {
        return usr_username;
    }

    /**
     * @param usr_username the usr_username to set
     */
    public void setUsr_username(String usr_username) {
        this.usr_username = usr_username;
    }

    /**
     * @return the usr_nombre
     */
    public String getUsr_nombre() {
        return usr_nombre;
    }

    /**
     * @param usr_nombre the usr_nombre to set
     */
    public void setUsr_nombre(String usr_nombre) {
        this.usr_nombre = usr_nombre;
    }

    /**
     * @return the usr_apellido
     */
    public String getUsr_apellido() {
        return usr_apellido;
    }

    /**
     * @param usr_apellido the usr_apellido to set
     */
    public void setUsr_apellido(String usr_apellido) {
        this.usr_apellido = usr_apellido;
    }

    /**
     * @return the usr_email
     */
    public String getUsr_email() {
        return usr_email;
    }

    /**
     * @param usr_email the usr_email to set
     */
    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    /**
     * @return the usr_celular
     */
    public long getUsr_celular() {
        return usr_celular;
    }

    /**
     * @param usr_celular the usr_celular to set
     */
    public void setUsr_celular(long usr_celular) {
        this.usr_celular = usr_celular;
    }

    /**
     * @return the usr_contraseña
     */
    public String getUsr_contraseña() {
        return usr_contraseña;
    }

    /**
     * @param usr_contraseña the usr_contraseña to set
     */
    public void setUsr_contraseña(String usr_contraseña) {
        this.usr_contraseña = usr_contraseña;
    }
    
    public String getUsr_fecha_nacimiento() {
        return usr_fecha_nacimiento;
    }

    /**
     * @param usr_fecha_nacimiento the usr_fecha_nacimiento to set
     */
    public void setUsr_fecha_nacimiento(String usr_fecha_nacimiento) {
        this.usr_fecha_nacimiento = usr_fecha_nacimiento;
    }
}
