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

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.ContenidoModel;
import utils.ConnectionDB;

/**
 *
 * @author I5-9600K
 */
//DAO DATA ACCESS OBJECT, aqui se tedran los querys para recuperar los datos, TODOS LOS QUERYS SE VAN A HACER EN EL DAO
public class ContenidoDAO {

    private Connection conn = null;

    public ArrayList<ContenidoModel> obtenerContenidos() {
        ArrayList<ContenidoModel> contenidos = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            } else {
                String sql = "SELECT cont_id_contenido, cont_titulo FROM CONTENIDO;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql); //select 
                while (result.next()) {
                    ContenidoModel contenido = new ContenidoModel(result.getInt(1), result.getString(2));
                    contenidos.add(contenido);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return contenidos;
    }
    
    public void insertarContenidos(ContenidoModel contenido){
        try{
            if(conn==null){
               conn = ConnectionDB.getConnection();               
            }else{
                String sql ="INSERT INTO contenido(cont_titulo) values (?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, contenido.getCont_titulo());
                
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
    
   public void actualizarContenidos(ContenidoModel contenido){
       try{
           if(conn==null){
               conn= ConnectionDB.getConnection();
           }else{
               String sql ="UPDATE CONTENIDO SET cont_titulo = ? WHERE cont_id_contenido = ?;";
               PreparedStatement statement = conn.prepareStatement(sql);
               statement.setString(1, contenido.getCont_titulo()); //el primer ?, remplacelo por la variable y ajustelo a string
               statement.setInt(2, contenido.getCon_id_contenido()); //el primer ?, remplacelo por la variable y ajustelo a string
                
               int filasActualizadas = statement.executeUpdate();
               if(filasActualizadas>0){
                   //imprimir que actualizo filas
               }
           }
       }catch (SQLException ex){
           //immprimir error
       }
   }
   
   public void eliminarContenidos(ContenidoModel contenido){
       try{
           if(conn==null){
               conn =ConnectionDB.getConnection();
           }else{
               String sql = "Delete from Contenido where cont_id_contenido = ?;";
               
               PreparedStatement statement = conn.prepareStatement(sql);
               statement.setInt(1, contenido.getCon_id_contenido());
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

