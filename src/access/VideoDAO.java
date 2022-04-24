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
import javax.swing.JOptionPane;
import model.VideoModel;
import utils.ConnectionDB;

/**
 *
 * @author I5-9600K
 */
public class VideoDAO {
    
    private Connection conn = null;

    public ArrayList<VideoModel> obtenerVideos() {
        ArrayList<VideoModel> videos = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
                String sql = "SELECT vid_id_video, vid_anio,vid_resumen,cont_id_contenido,vid_id_director FROM VIDEO;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql); //select 
                while (result.next()) {
                    VideoModel video = new VideoModel(result.getInt(1), result.getInt(2),result.getString(3),result.getInt(4),result.getInt(5));
                    
                    videos.add(video);
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return videos;
    }
        public ArrayList<VideoModel> obtenerDetalleVideos() {
        ArrayList<VideoModel> videos = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
                String sql = "select vid_id_video,cont_titulo,vid_resumen,vid_anio, concat (dir_nombre,\" \",dir_apellido) as director "
                        + "from CONTENIDO AS CONT "
                        + "INNER JOIN VIDEO AS VID on CONT.cont_id_contenido = VID.cont_id_contenido "
                        + "inner JOIN DIRECTOR AS DIC ON VID.VID_ID_DIRECTOR = DIC.DIR_ID_DIRECTOR;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql); //select 
                while (result.next()) {
                    VideoModel video = new VideoModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5));
                    videos.add(video);
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return videos;
    }
    
    
    public void insertarVideos(VideoModel video){
        try{
            if(conn==null){
               conn = ConnectionDB.getConnection();               
            }else{
                String sql ="INSERT INTO VIDEO (vid_anio,vid_resumen,cont_id_contenido,vid_id_director) values (?,?,?,?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,video.getVid_anio());
                statement.setString(2,video.getVid_resumen());
                statement.setInt(3,video.getCont_id_contenido());
                statement.setInt(4,video.getVid_id_video());
                
                int filasInsertadas = statement.executeUpdate(); //insert, update, delete es con execute updatre
                if(filasInsertadas>0){
                    //Mostrar mensaje de que los datos se ingresaron correctamente
                }       
            }
        }catch (SQLException ex){
            System.err.println("Error al insertar");
            //error
        }
    }
    
   public void actualizarContenidos(VideoModel video){
       try{
           if(conn==null){
               conn= ConnectionDB.getConnection();
           }else{
               String sql ="UPDATE VIDEO SET vid_anio = ?,vid_resumen = ?,cont_id_contenido =?,vid_id_director = ? WHERE vid_id_video = ?;";
               PreparedStatement statement = conn.prepareStatement(sql);
               statement.setInt(1, video.getVid_anio()); //el primer ?, remplacelo por la variable y ajustelo a string
               statement.setString(2, video.getVid_resumen()); //el primer ?, remplacelo por la variable y ajustelo a string
               statement.setInt(3, video.getCont_id_contenido());
               statement.setInt(4, video.getVid_id_director());
               
               int filasActualizadas = statement.executeUpdate();
               if(filasActualizadas>0){
                   //imprimir que actualizo filas
               }
           }
       }catch (SQLException ex){
           //immprimir error
       }
   }
   
   public void eliminarContenidos(VideoModel video){
       try{
           if(conn==null){
               conn =ConnectionDB.getConnection();
           }else{
               String sql = "Delete from VIDEO WHERE vid_id_video = ?;";
               
               PreparedStatement statement = conn.prepareStatement(sql);
               statement.setInt(1, video.getVid_id_video());
               int filasBorradas = statement.executeUpdate();
               if(filasBorradas >0){
                   //imprimir que se borro la fila
               }
           }
       }catch(SQLException ex){
           
           //imprimir error
       }
   }
}
