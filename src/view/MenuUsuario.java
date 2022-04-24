/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import controlador.ControladorPrincipal;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author I5-9600K
 */
public class MenuUsuario extends javax.swing.JFrame {

    ControladorPrincipal controladorPrincipal;
    PanelUsuario panelUsuario;
    PanelVideos panelVideos;

    /**
     * Creates new form MenuUsuario
     */
    public MenuUsuario() {

        initComponents();
        ajustarImagenLabel(jLabelLogo, "src/view/Imagenes/misiontic_logo.png");
        this.setLocationRelativeTo(null);
        pack();
        controladorPrincipal = new ControladorPrincipal(this);


        //controladorPrincipal= new ControladorPrincipal(); 
    }
    //agrega un panel al contenedor.
    public void nuevoPanel(JPanel panelActual) {
        jPanelContenedor.removeAll();
        jPanelContenedor.add(panelActual);
        jPanelContenedor.repaint();
        jPanelContenedor.revalidate();
    }
    private ImageIcon imagen;
    private Icon icono;
   
    private void ajustarImagenLabel(JLabel label, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon( //crea un espacio de imageicon
                this.imagen.getImage().getScaledInstance(
                        label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(this.icono);
        this.repaint(); //refresca y actualiza al ttamaño del label
    }

    private void adjustTextToTable(JTable table) {
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 90) {
                width = 90;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCabecera = new javax.swing.JPanel();
        jPanelOpciones = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelBienvenido1 = new javax.swing.JLabel();
        jLabelBienvenido2 = new javax.swing.JLabel();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelBienvenido3 = new javax.swing.JLabel();
        jPanelHerramientas = new javax.swing.JPanel();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonContenidoDisponible = new javax.swing.JButton();
        verDetallesVideo = new javax.swing.JButton();
        jPanelContenedor = new javax.swing.JPanel();
        jPanelContenidos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelCabecera.setBackground(new java.awt.Color(10, 37, 116));

        jPanelOpciones.setBackground(new java.awt.Color(10, 37, 116));

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Imagenes/misiontic_logo.png"))); // NOI18N
        jLabelLogo.setText("jLabel2");

        jLabelBienvenido1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelBienvenido1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBienvenido1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBienvenido1.setText("Multimedia");
        jLabelBienvenido1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelBienvenido2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelBienvenido2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBienvenido2.setText("Mi Gestor");
        jLabelBienvenido2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jLabelBienvenido3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelBienvenido3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBienvenido3.setText("Bienvenido");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBienvenido1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBienvenido2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                        .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabelBienvenido3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCabeceraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonCerrarSesion))
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addComponent(jButtonCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCabeceraLayout.createSequentialGroup()
                        .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelBienvenido3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCabeceraLayout.createSequentialGroup()
                        .addComponent(jLabelBienvenido2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBienvenido1)
                        .addGap(62, 62, 62))))
        );

        jPanelHerramientas.setBackground(new java.awt.Color(255, 255, 255));

        jButtonUsuarios.setText("Usuarios");
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jButtonContenidoDisponible.setText("Videos Disponibles");
        jButtonContenidoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContenidoDisponibleActionPerformed(evt);
            }
        });

        verDetallesVideo.setText("Ver Detalle Videos");
        verDetallesVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDetallesVideoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHerramientasLayout = new javax.swing.GroupLayout(jPanelHerramientas);
        jPanelHerramientas.setLayout(jPanelHerramientasLayout);
        jPanelHerramientasLayout.setHorizontalGroup(
            jPanelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(verDetallesVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonContenidoDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jButtonUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHerramientasLayout.setVerticalGroup(
            jPanelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHerramientasLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonContenidoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(verDetallesVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenedor.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanelContenidosLayout = new javax.swing.GroupLayout(jPanelContenidos);
        jPanelContenidos.setLayout(jPanelContenidosLayout);
        jPanelContenidosLayout.setHorizontalGroup(
            jPanelContenidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        jPanelContenidosLayout.setVerticalGroup(
            jPanelContenidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanelContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 265, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanelHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonContenidoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContenidoDisponibleActionPerformed
        panelVideos = new PanelVideos();
        nuevoPanel(panelVideos);
        panelVideos.cargarVideos();
        // controladorPrincipal.jButtonContenidoDisponibleActionPerformed();
    }//GEN-LAST:event_jButtonContenidoDisponibleActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        // TODO add your handling code here:
        panelUsuario = new PanelUsuario();
        nuevoPanel(panelUsuario);
        panelUsuario.cargarUsuarios();
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed

        controladorPrincipal.jButtonCerrarSesionActionPerformed();
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void verDetallesVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDetallesVideoActionPerformed
        panelVideos = new PanelVideos();
        nuevoPanel(panelVideos);
        panelVideos.cargarDetalleVideos();


    }//GEN-LAST:event_verDetallesVideoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MenuUsuario().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonContenidoDisponible;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabelBienvenido1;
    private javax.swing.JLabel jLabelBienvenido2;
    private javax.swing.JLabel jLabelBienvenido3;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelContenidos;
    private javax.swing.JPanel jPanelHerramientas;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JButton verDetallesVideo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jTextFieldUsername
     */
}
