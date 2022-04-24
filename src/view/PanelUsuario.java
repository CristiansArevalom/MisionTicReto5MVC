/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.ControladorPrincipal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.UsuarioModel;

/**
 *
 * @author I5-9600K
 */
public class PanelUsuario extends javax.swing.JPanel {

    private ControladorPrincipal controladorPrincipal;
    private boolean editable; //variable que controla si se puede seleccionar un campo para editar
    private JPopupMenu jpopupMenuUsuario;
    private JMenuItem usuarioEliminado;
    private JMenuItem usuarioAgregado;

    /**
     * Creates new form panelUsuario
     */
    public PanelUsuario() {
        initComponents();
        controladorPrincipal = new ControladorPrincipal(this);
        jpopupMenuUsuario = new JPopupMenu();
        //Metodo funcional del jmenu para eliminar usuario
        usuarioEliminado = new JMenuItem("Eliminar registro");
        usuarioEliminado.addActionListener((ActionEvent e) -> {
            eliminarFilasSeleccionadas(jTableUsuario);
            JOptionPane.showMessageDialog(null, "Registro eliminado");

        });
        //metodo funcional del jmenu para agregar usuario
        usuarioAgregado = new JMenuItem("Añadir Usuario");
        usuarioAgregado.addActionListener((ActionEvent e) -> {
            DefaultTableModel model = (DefaultTableModel) jTableUsuario.getModel();
            model.addRow(new Object[]{"user_name", "Nombre", "Apellido", "Email", "Celular", "Contrasena", "YYYY-MM-DD"});
        });
        //genera el popup en la tabla
        jpopupMenuUsuario.add(usuarioEliminado);
        jpopupMenuUsuario.add(usuarioAgregado);

        jTableUsuario.setComponentPopupMenu(jpopupMenuUsuario);
//Es el listener d ela tabla, recibe los eventos de la tabla.
        TableCellListener tcl = new TableCellListener(jTableUsuario, action);
    }

    //GESTIONA LOS EVENTOS 
    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableCellListener tcl = (TableCellListener) e.getSource();
            System.out.println("Row : " + tcl.getRow());
            System.out.println("column : " + tcl.getColumn());
            System.out.println("Old : " + tcl.getOldValue());
            System.out.println("New : " + tcl.getNewValue());
            String valorAntiguo = tcl.getOldValue().toString();
            //gestiona el evento para actualizar el usuario
//valida los campos antiguos, si son los de de la plantilla para ingresar un valor, entonces no haga el update y valida que haya diligenciado el ultimo campo
            if (!valorAntiguo.equals("user_name")&& !valorAntiguo.equals("Nombre") && !valorAntiguo.equals("Apellido") && !valorAntiguo.equals("Email") && !valorAntiguo.equals("Celular") && !valorAntiguo.equals("Contrasena")) {
                if (!valorAntiguo.equals("YYYY-MM-DD")) {                    
                    try {
                        String user_name = jTableUsuario.getModel().getValueAt(tcl.getRow(), 0).toString();
                        String Nombre = jTableUsuario.getModel().getValueAt(tcl.getRow(), 1).toString();
                        String Apellido = jTableUsuario.getModel().getValueAt(tcl.getRow(), 2).toString();
                        String Email = jTableUsuario.getModel().getValueAt(tcl.getRow(), 3).toString();
                        long celular = Long.parseLong(jTableUsuario.getModel().getValueAt(tcl.getRow(), 4).toString());
                        String contrasena = jTableUsuario.getModel().getValueAt(tcl.getRow(), 5).toString(); //no deberia guardarse en string la contrasena nunca
                        String fechaNacimiento = jTableUsuario.getModel().getValueAt(tcl.getRow(), 6).toString();
                        UsuarioModel usuarioActualizado = new UsuarioModel(user_name, Nombre, Apellido, Email, celular, contrasena, fechaNacimiento);
                        controladorPrincipal.actualizarUsuario(usuarioActualizado);

                    } catch (UnsupportedOperationException ex) {
                        System.out.println(ex);
                        throw new UnsupportedOperationException("Not supported yet." + ex); //To change body of generated methods, choose Tools | Templates.
                    }
                } else {
                    //valido que si es un insert. crea el objeto usuario y le pide al controlador que lo cargue
                    String user_name = jTableUsuario.getModel().getValueAt(tcl.getRow(), 0).toString();
                    String Nombre = jTableUsuario.getModel().getValueAt(tcl.getRow(), 1).toString();
                    String Apellido = jTableUsuario.getModel().getValueAt(tcl.getRow(), 2).toString();
                    String Email = jTableUsuario.getModel().getValueAt(tcl.getRow(), 3).toString();
                    long celular = Long.parseLong(jTableUsuario.getModel().getValueAt(tcl.getRow(), 4).toString());
                    String contrasena = jTableUsuario.getModel().getValueAt(tcl.getRow(), 5).toString(); //no deberia guardarse en string la contrasena nunca
                    String fechaNacimiento = jTableUsuario.getModel().getValueAt(tcl.getRow(), 6).toString();
                    UsuarioModel usuarioInsertado = new UsuarioModel(user_name, Nombre, Apellido, Email, celular, contrasena, fechaNacimiento);
                    controladorPrincipal.agregarUsuario(usuarioInsertado);
                }
            }
        }
    };

    public void cargarUsuarios() {
        TableModel modelo = controladorPrincipal.consultarUsuarios();
        jTableUsuario.setModel(modelo);
        jTableUsuario.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 14));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jButtonVolverUsuario = new javax.swing.JButton();

        jTableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuario);

        jButtonVolverUsuario.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(jButtonVolverUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVolverUsuario)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolverUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    // End of variables declaration//GEN-END:variables

    private void eliminarFilasSeleccionadas(JTable jTableUsuario) {
        DefaultTableModel model = (DefaultTableModel) this.jTableUsuario.getModel();
        int columna = 0;
        int fila = this.jTableUsuario.getSelectedRow();
        String valor = model.getValueAt(fila, columna).toString();
        controladorPrincipal.eliminarUsuario(valor);
        model.removeRow(fila);

    }
}
