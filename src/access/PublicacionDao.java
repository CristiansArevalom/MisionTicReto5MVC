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
import model.PublicacionModel;
import utils.ConnectionDB;

/**
 *
 * @author I5-9600K
 */
public class PublicacionDao {
    private Connection conn = null;
    public ArrayList<PublicacionModel> obtenerPublicacion(){
        ArrayList <PublicacionModel> publicaciones = new ArrayList<PublicacionModel>();
        try{
            if(conn == null){
                Connection conn = ConnectionDB.getConnection();
            }else{
                
             String sql = "SELECT pub_id_publicacion,usr_username,cont_id_contenido,pub_fecha FROM PUBLICACION;";
             PreparedStatement statement = conn.prepareStatement(sql);
               ResultSet result = statement.executeQuery();
                while (result.next()){
                    //se crea un objeto  de publicacion para agregarlos 
                    PublicacionModel publicacion = new PublicacionModel(result.getInt(1), result.getString(2),result.getInt(3), result.getString(4));
                    publicaciones.add(publicacion);      
                }                              
            }          
        }catch (SQLException ex){
            
        }       
        return publicaciones;  
    }
    
    public void agregarPublicacion(PublicacionModel publicacion){
        try{
            if(conn == null){
                Connection conn = ConnectionDB.getConnection();
            }else{
                String sql = "INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) values (?,?,?);";
                PreparedStatement statement  = conn.prepareStatement(sql);
                
                statement.setString(1, publicacion.getUsr_username());
                statement.setInt(2, publicacion.getCont_id_contenido());
                statement.setString(3,publicacion.getPub_fecha());

                int filasInsertadas = statement.executeUpdate();
                if(filasInsertadas>0){
                    System.out.println("Inserto");
                }
            }            
        }catch (SQLException ex){
             System.out.println("NO Inserto");    
        }
    }
    
    public void actualizarPublicacion(PublicacionModel publicacion){
        try{
            if (conn == null){
                Connection conn = ConnectionDB.getConnection();
            }else{
                String sql = "UPDATE PUBLICACION set usr_username = ?,cont_id_contenido = ? ,pub_fecha = ? WHERE pub_id_publicacion = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, publicacion.getUsr_username());
                statement.setInt(2, publicacion.getCont_id_contenido());
                statement.setString(3, publicacion.getPub_fecha());
                
                int filasActualizadas = statement.executeUpdate();
                if (filasActualizadas>0){
                    System.out.println("OK");
                }
            }
        }catch(SQLException ex){
            System.out.println("Error");
        }
    }
    
    public void eliminarPublicacion(PublicacionModel publicacion){
        try{
            if(conn == null){
                Connection conn = ConnectionDB.getConnection();
            }else{
                String sql = "DELETE FROM PUBLICACION WHERE pub_id_publicacion = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, publicacion.getPub_id_publicacion());
                int filasBorradas = statement.executeUpdate();               
                if(filasBorradas>0){
                    System.out.println("borro");
                }
            }
            
        }catch(SQLException ex){
            System.out.println("Error");
        }
    }
}
