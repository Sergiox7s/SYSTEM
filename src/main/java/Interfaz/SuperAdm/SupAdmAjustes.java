
package Interfaz.SuperAdm;

import Interfaz.Admin.VistaHistorial;
import Interfaz.Admin.VistaColaIncidente;
import Modelo.Entidades.Usuario;
import Utilidades.MenuSuperAdm;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyectoFinal.gestionTickets.Main;


public class SupAdmAjustes extends javax.swing.JFrame {

    Usuario u = new Usuario();

    public SupAdmAjustes(Usuario usuario) {
        initComponents();
        configureMouseEvents();
    }

    private void configureMouseEvents() {
        MenuSuperAdm p1 = new MenuSuperAdm();

        p1.configureMouseEvents(btnCategorias, new JButton[]{btnEmpleados, btnUsuarios, btnHistorial, btnAlertas, btnReportes});
        p1.configureMouseEvents(btnEmpleados, new JButton[]{btnCategorias, btnUsuarios, btnHistorial, btnAlertas, btnReportes});
        p1.configureMouseEvents(btnUsuarios, new JButton[]{btnEmpleados, btnCategorias, btnHistorial, btnAlertas, btnReportes});
        p1.configureMouseEvents(btnHistorial, new JButton[]{btnEmpleados, btnUsuarios, btnCategorias, btnAlertas, btnReportes});
        p1.configureMouseEvents(btnAlertas, new JButton[]{btnEmpleados, btnUsuarios, btnHistorial, btnCategorias, btnReportes});
        p1.configureMouseEvents(btnReportes, new JButton[]{btnEmpleados, btnUsuarios, btnHistorial, btnAlertas, btnCategorias});

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        lbSalirSistema = new javax.swing.JLabel();
        lbMenuPrincipal = new javax.swing.JLabel();
        lbMenuTickets = new javax.swing.JLabel();
        lbMenuAjustes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        btnCategorias = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnAlertas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Control de Incidencias");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 390, 70));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Hola,");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 70));

        lbNomUsuario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setText("Evelyn Pascual");
        jPanel3.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 150, 70));

        lbSalirSistema.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbSalirSistema.setForeground(new java.awt.Color(255, 255, 255));
        lbSalirSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSalirSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_exit2.png"))); // NOI18N
        lbSalirSistema.setText("SALIR");
        lbSalirSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(lbSalirSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 60, 70));

        lbMenuPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        lbMenuPrincipal.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (27).png"))); // NOI18N
        lbMenuPrincipal.setText("Inicio");
        lbMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMenuPrincipal.setOpaque(true);
        lbMenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuPrincipalMouseClicked(evt);
            }
        });
        jPanel3.add(lbMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 130, 70));

        lbMenuTickets.setBackground(new java.awt.Color(51, 51, 51));
        lbMenuTickets.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbMenuTickets.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuTickets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuTickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (33).png"))); // NOI18N
        lbMenuTickets.setText("Tickets");
        lbMenuTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMenuTickets.setOpaque(true);
        lbMenuTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuTicketsMouseClicked(evt);
            }
        });
        jPanel3.add(lbMenuTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 120, 70));

        lbMenuAjustes.setBackground(new java.awt.Color(0, 102, 204));
        lbMenuAjustes.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbMenuAjustes.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuAjustes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (1).png"))); // NOI18N
        lbMenuAjustes.setText("Ajustes");
        lbMenuAjustes.setOpaque(true);
        jPanel3.add(lbMenuAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 120, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Ajustes");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 230, 30));

        jSeparator15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1000, 10));

        btnCategorias.setBackground(new java.awt.Color(51, 51, 51));
        btnCategorias.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (3).png"))); // NOI18N
        btnCategorias.setText("Categorias");
        btnCategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        jPanel2.add(btnCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, 180));

        btnEmpleados.setBackground(new java.awt.Color(51, 51, 51));
        btnEmpleados.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (37).png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 250, 180));

        btnUsuarios.setBackground(new java.awt.Color(51, 51, 51));
        btnUsuarios.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (33)_1.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel2.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 250, 180));

        btnHistorial.setBackground(new java.awt.Color(51, 51, 51));
        btnHistorial.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (25).png"))); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistorial.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 250, 180));

        btnAlertas.setBackground(new java.awt.Color(51, 51, 51));
        btnAlertas.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnAlertas.setForeground(new java.awt.Color(255, 255, 255));
        btnAlertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (34).png"))); // NOI18N
        btnAlertas.setText("Alertas");
        btnAlertas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlertas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(btnAlertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 250, 180));

        btnReportes.setBackground(new java.awt.Color(51, 51, 51));
        btnReportes.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (36).png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 250, 180));

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

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed

        SuperAdmCategorias c = new SuperAdmCategorias(Main.usuario);
        c.setVisible(true);
        c.setLocationRelativeTo(null);


        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        SuperAdmUsuarios us = new SuperAdmUsuarios(Main.usuario);
        us.setVisible(true);
        us.setLocationRelativeTo(null);
  

        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void lbMenuPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuPrincipalMouseClicked

        VistaColaIncidente Aa = new VistaColaIncidente(Main.usuario);
        Aa.setVisible(true);
        Aa.setLocationRelativeTo(null);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_lbMenuPrincipalMouseClicked

    private void lbMenuTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuTicketsMouseClicked

        VistaHistorial Ae = new VistaHistorial(Main.usuario);
        Ae.setVisible(true);
        Ae.setLocationRelativeTo(null);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_lbMenuTicketsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlertas;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JLabel lbMenuAjustes;
    private javax.swing.JLabel lbMenuPrincipal;
    private javax.swing.JLabel lbMenuTickets;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JLabel lbSalirSistema;
    // End of variables declaration//GEN-END:variables
}
