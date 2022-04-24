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
public class ContenidoModel {
    private int con_id_contenido;
    private String cont_titulo;
    
    public ContenidoModel (int con_id_contenido, String cont_titulo ){
        this.con_id_contenido = con_id_contenido;
        this.cont_titulo = cont_titulo;
    }

    /**
     * @return the con_id_contenido
     */
    public int getCon_id_contenido() {
        return con_id_contenido;
    }

    /**
     * @param con_id_contenido the con_id_contenido to set
     */
    public void setCon_id_contenido(int con_id_contenido) {
        this.con_id_contenido = con_id_contenido;
    }

    /**
     * @return the cont_titulo
     */
    public String getCont_titulo() {
        return cont_titulo;
    }

    /**
     * @param cont_titulo the cont_titulo to set
     */
    public void setCont_titulo(String cont_titulo) {
        this.cont_titulo = cont_titulo;
    }
   
}
