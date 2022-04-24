/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import utils.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DirectorModel;

/**
 *
 * @author I5-9600K
 */
public class DirectorDAO {

    //obtener, insertar, actualizar y borrar CRUD
    Connection conn = null;

    public ArrayList<DirectorModel> obtenerDirector() {
        //1 se crea un arreglo de tipo director, que alnacenara lo que retorne el query
        ArrayList<DirectorModel> directores = new ArrayList<DirectorModel>();
        //se valida si existe la conexion a BD
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            } else {
                //crear la sentenciaSQL
                String sql = "Select dir_id_director,dir_nombre,dir_apellido,dir_nacionalidad from Director;";
                PreparedStatement statement = conn.prepareStatement(sql);//se prepara una sentencia con el sql
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    DirectorModel director = new DirectorModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));//se crea un Objeto de tipo director hasta que termine el bucle
                    directores.add(director);
                }
                conn.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return directores;
    }
    public void insertarDirector(DirectorModel director) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            } else {
                String sql = "INSERT INTO DIRECTOR (dir_nombre,dir_apellido,dir_nacionalidad) VALUES (???);";//
                //PREPARAR SENTENCIA
                PreparedStatement statement = conn.prepareStatement(sql);
                //Dar formato a los datos, que recibe del objeto director
                statement.setString(1, director.getDir_nombre());
                statement.setString(2, director.getDir_apellido());
                statement.setString(3, director.getNacionalidad());
                //se ejectua el statement y como este retorna un numero contando la cantidad afectada se guarda eun un int
                int filasInsertadas = statement.executeUpdate();
                if (filasInsertadas > 0) {
                    //IMPRIMIR QUE Se inserto
                }
                              conn.close();conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarDirector(DirectorModel director) {
        try{
            if(conn  == null ){
                Connection conn = ConnectionDB.getConnection();
            }else{
              String sql = "UPDATE DIRECTOR SET dir_nombre,dir_apellido,dir_nacionalidad,dir_id_director = ?;";
              PreparedStatement statement = conn.prepareStatement(sql);
              statement.setString(1,director.getDir_nombre());
              statement.setString(2,director.getDir_apellido());
              statement.setString(3,director.getNacionalidad());
              int filasActualizadas = statement.executeUpdate();
              if(filasActualizadas>0){
                  //print ok
              }
              conn.close();
            }
            
        }catch (SQLException ex){
            System.out.println("access.DirectorDAO.actualizarDirector()");
        }
    }
    public void eliminarDirector(DirectorModel director){
        try{
        if(conn == null){
            Connection conn = ConnectionDB.getConnection();
        }else{            
            String sql = "delete from DIRECTOR where dir_id_director = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, director.getDir_id_director());
            int registroEliminado = statement.executeUpdate();
            if(registroEliminado>0){
                System.out.println("Eliminado");
            }          
        }
        }catch (SQLException ex){
            System.out.println("error");

        }
    }

}
