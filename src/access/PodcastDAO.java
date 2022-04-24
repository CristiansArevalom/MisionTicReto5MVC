/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.PodcastModel;
import utils.ConnectionDB;

/**
 *
 * @author I5-9600K
 */
public class PodcastDAO {

    Connection conn = null;

    public ArrayList<PodcastModel> obtenerPodcast() {

        ArrayList<PodcastModel> podcasts = new ArrayList<PodcastModel>();
        try {
            if (conn == null) {
                Connection con = ConnectionDB.getConnection();
            } else {
                String sql = "SELECT pod_id_podcast,pod_numero_episodios,pod_numero_temporadas,cont_id_contenido FROM PODCAST;";
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    PodcastModel podcast = new PodcastModel(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4));
                    podcasts.add(podcast);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return podcasts;
    }

    public void insertarPodcast(PodcastModel podcast) {
        try {
            if (conn == null) {
                Connection conn = ConnectionDB.getConnection();
            } else {
                String sql = "INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido) VALUES (???);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, podcast.getPod_numero_episodios());
                statement.setInt(2, podcast.getPod_numero_temporadas());
                statement.setInt(3, podcast.getCont_id_contenido());
                int filaInsertada = statement.executeUpdate();
                if (filaInsertada > 0) {
                    System.out.print("fila insertada");
                }
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }

    public void actualizarPodcast(PodcastModel podcast) {
        try {
            if (conn == null) {
                Connection conn = ConnectionDB.getConnection();
            } else {
                String sql = "UPDATE PODCAST SET pod_numero_episodios = ? ,pod_numero_temporadas = ? ,cont_id_contenido = ? WHERE pod_id_podcast = ? ;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, podcast.getPod_numero_episodios());
                statement.setInt(2, podcast.getPod_numero_temporadas());
                statement.setInt(3, podcast.getCont_id_contenido());
                statement.setInt(4, podcast.getCont_id_contenido());

                int filasActualizadas = statement.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("SE actualizo");
                }
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }

    public void elimininarPodcast(PodcastModel podcast) {
        try {

            if (conn == null) {
                Connection conn = ConnectionDB.getConnection();
            } else {
                String sql = "Delete from PODCAST where pod_id_podcast = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, podcast.getPod_id_podcast());
                
                int filasBorradas=statement.executeUpdate();
                if(filasBorradas>0){
                    System.out.println("BorroRegistros");
                }
            }
        } catch (SQLException ex) {
                    System.out.println("error");
        }
    }
}
