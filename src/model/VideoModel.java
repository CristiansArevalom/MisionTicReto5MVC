/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//el modelo es una representación de lo que esta en la BD en el codigo
/**
 *
 * @author I5-9600K
 */
public class VideoModel {

    private int vid_id_video;
    private int vid_anio;
    private String vid_resumen;
    private int cont_id_contenido;
    private int vid_id_director;
    //Son atributos para crear un video a partir de un query
    private String vid_cont_titulo;
    private String vid_director;
    
    public VideoModel (int vid_id_video,int vid_anio,String vid_resumen,int cont_id_contenido,int vid_id_director){
        this.vid_id_video=vid_id_video;
        this.vid_anio=vid_anio;
        this.vid_resumen=vid_resumen;
        this.cont_id_contenido=cont_id_contenido;
        this.vid_id_director=vid_id_director;
        }
    public VideoModel (int vid_id_video,String vid_cont_titulo,String vid_resumen,int vid_anio,String vid_director){
        this.vid_id_video=vid_id_video;
        this.vid_cont_titulo = vid_cont_titulo;
        this.vid_anio=vid_anio;
        this.vid_resumen=vid_resumen;
        this.vid_director=vid_director;
        }

    /**
     * @return the vid_id_video
     */
    public int getVid_id_video() {
        return vid_id_video;
    }

    /**
     * @param vid_id_video the vid_id_video to set
     */
    public void setVid_id_video(int vid_id_video) {
        this.vid_id_video = vid_id_video;
    }

    /**
     * @return the vid_anio
     */
    public int getVid_anio() {
        return vid_anio;
    }

    /**
     * @param vid_anio the vid_anio to set
     */
    public void setVid_anio(int vid_anio) {
        this.vid_anio = vid_anio;
    }

    /**
     * @return the vid_resumen
     */
    public String getVid_resumen() {
        return vid_resumen;
    }

    /**
     * @param vid_resumen the vid_resumen to set
     */
    public void setVid_resumen(String vid_resumen) {
        this.vid_resumen = vid_resumen;
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
     * @return the vid_id_director
     */
    public int getVid_id_director() {
        return vid_id_director;
    }

    /**
     * @param vid_id_director the vid_id_director to set
     */
    public void setVid_id_director(int vid_id_director) {
        this.vid_id_director = vid_id_director;
    }
    
    
    /**
     * @return the vid_cont_titulo
     */
    public String getVid_cont_titulo() {
        return vid_cont_titulo;
    }

    /**
     * @param vid_cont_titulo the vid_cont_titulo to set
     */
    public void setVid_cont_titulo(String vid_cont_titulo) {
        this.vid_cont_titulo = vid_cont_titulo;
    }

    /**
     * @return the vid_director
     */
    public String getVid_director() {
        return vid_director;
    }

    /**
     * @param vid_director the vid_director to set
     */
    public void setVid_director(String vid_director) {
        this.vid_director = vid_director;
    }
    
    }

