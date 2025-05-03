
package Interfaz.SuperAdm;

import Modelo.Entidades.Usuario;


public class SuperAdmCategorias extends javax.swing.JFrame {

 
    public SuperAdmCategorias(Usuario usuario) {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDatos15 = new javax.swing.JPanel();
        textNombre = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        iconCerrar = new javax.swing.JLabel();
        btnRegistrar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscarTicket = new javax.swing.JButton();
        textBuscarTicket = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatos15.setBackground(new java.awt.Color(255, 255, 255));

        textNombre.setBackground(new java.awt.Color(255, 255, 255));
        textNombre.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textNombre.setForeground(new java.awt.Color(0, 0, 0));
        textNombre.setBorder(null);
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });

        jSeparator15.setForeground(new java.awt.Color(0, 102, 204));

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("NOMBRE");

        javax.swing.GroupLayout panelDatos15Layout = new javax.swing.GroupLayout(panelDatos15);
        panelDatos15.setLayout(panelDatos15Layout);
        panelDatos15Layout.setHorizontalGroup(
            panelDatos15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelDatos15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator15)
                    .addGroup(panelDatos15Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelDatos15Layout.setVerticalGroup(
            panelDatos15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos15Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel20)
                .addGap(3, 3, 3)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelDatos15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 480, 50));

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w-eliminar.png"))); // NOI18N
        btnCancelar.setText("ELIMINAR");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 140, 45));

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 204));
        btnRegistrar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w-guardar.png"))); // NOI18N
        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 140, 45));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("LISTA DE CATEGORIAS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 238, -1));

        iconCerrar.setBackground(new java.awt.Color(42, 95, 147));
        iconCerrar.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        iconCerrar.setForeground(new java.awt.Color(0, 102, 204));
        iconCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCerrar.setText("X");
        iconCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(iconCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 18, 50, 50));

        btnRegistrar1.setBackground(new java.awt.Color(134, 173, 17));
        btnRegistrar1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnRegistrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_add.png"))); // NOI18N
        btnRegistrar1.setText("AGREGAR");
        btnRegistrar1.setBorderPainted(false);
        btnRegistrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 140, 45));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Tipo de categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 480, 340));

        btnBuscarTicket.setBackground(new java.awt.Color(0, 102, 204));
        btnBuscarTicket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnBuscarTicket.setForeground(new java.awt.Color(98, 66, 26));
        btnBuscarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_search.png"))); // NOI18N
        btnBuscarTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btnBuscarTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTicketActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 30, 30));

        textBuscarTicket.setBackground(new java.awt.Color(255, 255, 255));
        textBuscarTicket.setForeground(new java.awt.Color(51, 51, 51));
        textBuscarTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(textBuscarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 450, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Buscar por ID o Nombre");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void iconCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCerrarMouseClicked

        this.dispose();

    }//GEN-LAST:event_iconCerrarMouseClicked

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed

    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTicket;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JLabel iconCerrar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelDatos15;
    private javax.swing.JTextField textBuscarTicket;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
