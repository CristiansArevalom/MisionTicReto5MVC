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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.UsuarioModel;
import utils.ConnectionDB;

/**
 *
 * @author I5-9600K
 */
public class UsuarioDAO {

    private Connection conn = null;

    public ArrayList<UsuarioModel> obtenerUsuario() {
        ArrayList<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento FROM USUARIO;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                UsuarioModel usuario = new UsuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());

        }
        return usuarios;
    }

    public void AgregarUsuario(UsuarioModel usuario) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO USUARIO (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento) VALUES ( ?,?,?,?,?,SHA(?),?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getUsr_username());
            statement.setString(2, usuario.getUsr_nombre());
            statement.setString(3, usuario.getUsr_apellido());
            statement.setString(4, usuario.getUsr_email());
            statement.setLong(5, usuario.getUsr_celular());
            statement.setString(6, usuario.getUsr_contraseña());
            statement.setString(7, usuario.getUsr_fecha_nacimiento());

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                 JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void modificarUsuario(UsuarioModel usuario) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String SQL = "UPDATE USUARIO SET usr_nombre = ?,usr_apellido = ?,usr_email= ?,usr_celular = ?,usr_contraseña = ?,usr_fecha_nacimiento=? WHERE usr_username = ?;";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, usuario.getUsr_nombre());
            statement.setString(2, usuario.getUsr_apellido());
            statement.setString(3, usuario.getUsr_email());
            statement.setLong(4, usuario.getUsr_celular());
            statement.setString(5, usuario.getUsr_contraseña());
            statement.setString(6, usuario.getUsr_fecha_nacimiento());
            statement.setString(7, usuario.getUsr_username());
            int filasActualizadas = statement.executeUpdate();
            statement.executeUpdate("commit");
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el registro");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR");
        }
    }

    public void eliminarUsuario(String username) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Delete from USUARIO where usr_username = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,username);
            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Elimino");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean validarCredencialesUsuario(String username, char[] contrasena) {

        boolean credenciales = false;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "SELECT usr_username FROM USUARIO where usr_username=? AND usr_contraseña = SHA(?)";//where usr_username=? AND usr_contraseña = SHA ?;

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, String.valueOf(contrasena));
            ResultSet result = statement.executeQuery();
            System.out.println(statement.toString());

            while (result.next()) {
                credenciales = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return credenciales;

    }

}
