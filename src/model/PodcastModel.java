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
public class PodcastModel {
    private int pod_id_podcast;
    private int pod_numero_episodios;
    private int pod_numero_temporadas;
    private int cont_id_contenido;
    
    public PodcastModel(int pod_id_podcast,int pod_numero_episodios,int pod_numero_temporadas,int cont_id_contenido){
        this.pod_id_podcast = pod_id_podcast;
        this.pod_numero_episodios = pod_numero_episodios;
        this.pod_numero_temporadas =pod_numero_temporadas;
        this.cont_id_contenido = cont_id_contenido;
    }

    /**
     * @return the pod_id_podcast
     */
    public int getPod_id_podcast() {
        return pod_id_podcast;
    }

    /**
     * @param pod_id_podcast the pod_id_podcast to set
     */
    public void setPod_id_podcast(int pod_id_podcast) {
        this.pod_id_podcast = pod_id_podcast;
    }

    /**
     * @return the pod_numero_episodios
     */
    public int getPod_numero_episodios() {
        return pod_numero_episodios;
    }

    /**
     * @param pod_numero_episodios the pod_numero_episodios to set
     */
    public void setPod_numero_episodios(int pod_numero_episodios) {
        this.pod_numero_episodios = pod_numero_episodios;
    }

    /**
     * @return the pod_numero_temporadas
     */
    public int getPod_numero_temporadas() {
        return pod_numero_temporadas;
    }

    /**
     * @param pod_numero_temporadas the pod_numero_temporadas to set
     */
    public void setPod_numero_temporadas(int pod_numero_temporadas) {
        this.pod_numero_temporadas = pod_numero_temporadas;
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
}
