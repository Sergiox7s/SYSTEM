package Interfaz.Admin;

import Interfaz.Admin.VistaDetalleTicket;
import Interfaz.Admin.VistaColaIncidente;
import Modelo.DAO.ActividadEmpleadoDAO;
import Modelo.Entidades.Incidente;
import javax.swing.table.DefaultTableModel;
import proyectoFinal.gestionTickets.Main;
import Servicio.GestionActividadEmpleado;
import Servicio.GestionIncidente;
import Interfaz.LoginPanel;
import Modelo.Entidades.Categoria;
import Modelo.Entidades.Usuario;
import Servicio.GestionCategoria;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static proyectoFinal.gestionTickets.Main.usuario;

public class VistaHistorial extends javax.swing.JFrame {

    private GestionIncidente gestionIncidente;
    private GestionCategoria gestionCategoria;

    public VistaHistorial(Usuario usuario) {
        gestionIncidente = new GestionIncidente();
        gestionCategoria = new GestionCategoria();
        initComponents();
        lbNomUsuario.setText(usuario.getNombre() + " " + usuario.getApellido());
        cargarHistorial();
        gestionCategoria.mostrarCategorias(cbCategoria);
        SetImageLabel(jLabel1, "/Img/palacioBlanco.jpg");
    }

    private void cargarHistorial() {
        GestionActividadEmpleado gestion = new GestionActividadEmpleado();
        gestion.actualizarTablaAsignados(tableHistorial);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        lbSalirSistema = new javax.swing.JLabel();
        lbVistaCola = new javax.swing.JLabel();
        lbVistaHistorial = new javax.swing.JLabel();
        lbVistaMetricas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistorial = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        textBuscarTicket = new javax.swing.JTextField();
        btnBuscarTicket = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        btActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sistema Control de Incidencias");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 390, 70));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hola,");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 70));

        nomUsuario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        nomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomUsuario.setText("Evelyn Pascual");
        jPanel1.add(nomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 150, 70));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_exit2.png"))); // NOI18N
        jLabel4.setText("SALIR");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 60, 70));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Control de Incidencias");
        jLabel14.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel14AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 320, 70));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Hola,");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 70));

        lbNomUsuario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setText("--");
        jPanel3.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 150, 70));

        lbSalirSistema.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbSalirSistema.setForeground(new java.awt.Color(255, 255, 255));
        lbSalirSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSalirSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_exit2.png"))); // NOI18N
        lbSalirSistema.setText("SALIR");
        lbSalirSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSalirSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalirSistemaMouseClicked(evt);
            }
        });
        jPanel3.add(lbSalirSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 60, 70));

        lbVistaCola.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbVistaCola.setForeground(new java.awt.Color(255, 255, 255));
        lbVistaCola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVistaCola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (27).png"))); // NOI18N
        lbVistaCola.setText("Inicio");
        lbVistaCola.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVistaCola.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbVistaColaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lbVistaCola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVistaColaMouseClicked(evt);
            }
        });
        jPanel3.add(lbVistaCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 130, 70));

        lbVistaHistorial.setBackground(new java.awt.Color(0, 102, 204));
        lbVistaHistorial.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbVistaHistorial.setForeground(new java.awt.Color(255, 255, 255));
        lbVistaHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVistaHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (33).png"))); // NOI18N
        lbVistaHistorial.setText("Tickets");
        lbVistaHistorial.setOpaque(true);
        jPanel3.add(lbVistaHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 120, 70));

        lbVistaMetricas.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbVistaMetricas.setForeground(new java.awt.Color(255, 255, 255));
        lbVistaMetricas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVistaMetricas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (16).png"))); // NOI18N
        lbVistaMetricas.setText("Metricas");
        lbVistaMetricas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVistaMetricas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVistaMetricasMouseClicked(evt);
            }
        });
        jPanel3.add(lbVistaMetricas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 120, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/b_doc.png"))); // NOI18N
        jLabel13.setText("Tickets / Historial");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 480, 30));

        jSeparator15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1000, 10));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tableHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tableHistorial.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        tableHistorial.setForeground(new java.awt.Color(0, 102, 204));
        tableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Incidente", "Asignado a", "Estado", "F. Asignado", "F. Finalizado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableHistorial.setGridColor(new java.awt.Color(204, 204, 204));
        tableHistorial.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tableHistorial.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableHistorial.setShowGrid(false);
        jScrollPane1.setViewportView(tableHistorial);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 1000, 400));

        btnVerDetalle.setBackground(new java.awt.Color(0, 102, 204));
        btnVerDetalle.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnVerDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnVerDetalle.setText("VER DETALLES");
        btnVerDetalle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerDetalle.setFocusPainted(false);
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 160, 45));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Buscar ID de Ticket");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 230, 20));

        textBuscarTicket.setForeground(new java.awt.Color(51, 51, 51));
        textBuscarTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(textBuscarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 300, 30));

        btnBuscarTicket.setBackground(new java.awt.Color(0, 102, 204));
        btnBuscarTicket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnBuscarTicket.setForeground(new java.awt.Color(98, 66, 26));
        btnBuscarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/w_search.png"))); // NOI18N
        btnBuscarTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btnBuscarTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTicketActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 30, 30));

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Seleccionar Categoria");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        cbCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 390, 30));

        btActualizar.setBackground(new java.awt.Color(134, 173, 17));
        btActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/75 (12).png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btActualizar.setFocusPainted(false);
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondoBlanco.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed

        int selectedRow = tableHistorial.getSelectedRow();

        if (selectedRow != -1) {
            int idTicket = (int) tableHistorial.getValueAt(selectedRow, 0);
            Incidente incidente = gestionIncidente.obtenerIncidentePorId(idTicket);
            if (incidente != null) {
                VistaDetalleTicket detalle = new VistaDetalleTicket(incidente, this);
                detalle.setVisible(true);
                detalle.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un incidente.", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void lbVistaColaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaColaMouseClicked

        VistaColaIncidente ap = new VistaColaIncidente(usuario);
        ap.setVisible(true);
        ap.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_lbVistaColaMouseClicked

    private void lbSalirSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirSistemaMouseClicked
        LoginPanel lp = new LoginPanel();
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbSalirSistemaMouseClicked

    private void jLabel14AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel14AncestorAdded

    }//GEN-LAST:event_jLabel14AncestorAdded

    private void lbVistaColaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbVistaColaAncestorAdded

    }//GEN-LAST:event_lbVistaColaAncestorAdded

    private void lbVistaMetricasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaMetricasMouseClicked
        VistaMetricas vm = new VistaMetricas(usuario);
        vm.setVisible(true);
        vm.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_lbVistaMetricasMouseClicked

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed

    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed

    }//GEN-LAST:event_btActualizarActionPerformed

    public void SetImageLabel(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btnBuscarTicket;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JComboBox<Categoria> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JLabel lbSalirSistema;
    private javax.swing.JLabel lbVistaCola;
    private javax.swing.JLabel lbVistaHistorial;
    private javax.swing.JLabel lbVistaMetricas;
    private javax.swing.JLabel nomUsuario;
    public static javax.swing.JTable tableHistorial;
    private javax.swing.JTextField textBuscarTicket;
    // End of variables declaration//GEN-END:variables
}
