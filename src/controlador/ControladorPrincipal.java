/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import access.UsuarioDAO;
import access.VideoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.UsuarioModel;
import model.VideoModel;
import view.MenuIniciarSesion;
import view.MenuUsuario;
import view.PanelUsuario;
import view.PanelVideos;

/**
 *
 * @author I5-9600K
 */
public class ControladorPrincipal {

    private MenuIniciarSesion menuIniciarSesion;
    private MenuUsuario menuUsuario;
    private PanelUsuario panelUsuario;
    private PanelVideos panelVideos;
    private UsuarioDAO usrDAO;

    public ControladorPrincipal(MenuIniciarSesion menuIniciarSesion) {
        this.menuIniciarSesion = menuIniciarSesion;
    }

    public ControladorPrincipal(MenuUsuario menuUsuario) {
        this.menuUsuario = menuUsuario;
    }

    public ControladorPrincipal(PanelUsuario panelUsuario) {
        this.panelUsuario = panelUsuario;
    }

    public ControladorPrincipal(PanelVideos panelVideos) {
        this.panelVideos = panelVideos;
    }

    public void jButtonIniciarSesion() {
        try {
            String usuario = menuIniciarSesion.getjTextFieldUserName().getText();
            char[] contrasena = menuIniciarSesion.getjFieldPassword().getPassword();
    usrDAO = new UsuarioDAO();
            boolean credenciales = usrDAO.validarCredencialesUsuario(usuario, contrasena);
            if (credenciales) {
                JOptionPane.showMessageDialog(null, "Credenciales correctas");
                //cree jframe menu princial
                menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                menuIniciarSesion.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
            }

        } catch (Exception err) {
            System.out.println("Error en controlador");
        }
    }

    public void jButtonCerrarSesionActionPerformed() {
        MenuIniciarSesion menuIniciarSesion = new MenuIniciarSesion();
        menuIniciarSesion.setVisible(true);
        menuUsuario.setVisible(false);
    }

    public TableModel consultarVideos() {
        String[] titulos = {"Id video", "id_Contenido", "Resumen", "Año", "Id_director"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        ArrayList<VideoModel> videos = new VideoDAO().obtenerVideos();
        for (VideoModel videoModel : videos) {
            String[] registro = new String[5];
            registro[0] = videoModel.getVid_id_video() + "";
            registro[1] = videoModel.getCont_id_contenido() + "";
            registro[2] = videoModel.getVid_resumen();
            registro[3] = videoModel.getVid_anio() + "";
            registro[4] = videoModel.getVid_id_director() + "";
            modelo.addRow(registro);
        }
        return modelo;

    }

    public void jButtonContenidoDisponibleActionPerformed() {
        consultarVideos();
    }

    public TableModel consultarDetalleVideos() {
        String[] titulos = {"Id video", "Titulo", "Resumen", "año", "Director"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        ArrayList<VideoModel> videos = new VideoDAO().obtenerDetalleVideos();
        for (VideoModel videoModel : videos) {
            String[] registro = new String[5];
            registro[0] = videoModel.getVid_id_video() + "";
            registro[1] = videoModel.getVid_cont_titulo();
            registro[2] = videoModel.getVid_resumen();
            registro[3] = videoModel.getVid_anio() + "";
            registro[4] = videoModel.getVid_director();
            modelo.addRow(registro);
        }
        return modelo;
    }

    public TableModel consultarUsuarios() {
        String[] titulos = {"user_name", "Nombre", "Apellido", "Email", "Celular", "Contrasena", "Fecha Nacimiento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        ArrayList<UsuarioModel> usuario = new UsuarioDAO().obtenerUsuario();
        for (UsuarioModel usuarioModel : usuario) {
            String[] registro = new String[7];
            registro[0] = usuarioModel.getUsr_username();
            registro[1] = usuarioModel.getUsr_nombre();
            registro[2] = usuarioModel.getUsr_apellido();
            registro[3] = usuarioModel.getUsr_email();
            registro[4] = usuarioModel.getUsr_celular() + "";
            registro[5] = usuarioModel.getUsr_contraseña();
            registro[6] = usuarioModel.getUsr_fecha_nacimiento();
            modelo.addRow(registro);
        }
        return modelo;
    }

    public void actualizarUsuario(UsuarioModel usuario) {
        try {
             usrDAO = new UsuarioDAO();
            usrDAO.modificarUsuario(usuario);
        } catch (UnsupportedOperationException ex) {
            System.err.println(ex);
            //To change body of generated methods, choose Tools | Templates.
        }
    }

    public void eliminarUsuario(String username) {
         usrDAO = new UsuarioDAO();
        usrDAO.eliminarUsuario(username);
    }

    public void agregarUsuario(UsuarioModel usuario) {
        usrDAO = new UsuarioDAO();
        usrDAO.AgregarUsuario(usuario);
    }

}
