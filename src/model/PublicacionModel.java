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
public class PublicacionModel {
    
    private int pub_id_publicacion;
    private String usr_username;
    private int cont_id_contenido;
    private String pub_fecha;
    
    public PublicacionModel (int pub_id_publicacion,String usr_username,int cont_id_contenido,String pub_fecha){
        this.pub_id_publicacion = pub_id_publicacion;
        this.usr_username = usr_username;
        this.cont_id_contenido = cont_id_contenido;
        this.pub_fecha = pub_fecha;
    }

    /**
     * @return the pub_id_publicacion
     */
    public int getPub_id_publicacion() {
        return pub_id_publicacion;
    }

    /**
     * @param pub_id_publicacion the pub_id_publicacion to set
     */
    public void setPub_id_publicacion(int pub_id_publicacion) {
        this.pub_id_publicacion = pub_id_publicacion;
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
     * @return the cont_id_contenido
     */
    public int getCont_id_contenido() {
        return cont_id_contenido;
    }

    /**
     * @param cont_id_contenido the cont_id_contenido to set
     */
    public void setCont_id_contenido(int cont_id_contenido) {
        this.cont_id_contenido = cont_id_contenido;
    }

    /**
     * @return the pub_fecha
     */
    public String getPub_fecha() {
        return pub_fecha;
    }

    /**
     * @param pub_fecha the pub_fecha to set
     */
    public void setPub_fecha(String pub_fecha) {
        this.pub_fecha = pub_fecha;
    }
    
    
           
    
}
