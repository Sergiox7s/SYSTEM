
package Interfaz.SuperAdm;

import Modelo.Entidades.Usuario;
import Modelo.DAO.UsuarioDAO;
import javax.swing.JOptionPane;


public class SuperAdmUsuarios extends javax.swing.JFrame {

    UsuarioDAO gu = new UsuarioDAO();
    Usuario u = new Usuario();

    public SuperAdmUsuarios(Usuario usuario) {
        initComponents();
    }

    public void limpiarDatos() {

        textNombre.setText("");
        textApellidos.setText("");
        textContrasena.setText("");
        textCorreo.setText("");
        cbRol.setSelectedItem(null);

    }

    private void registrarUsuario() {

        u.setNombre(textNombre.getText());
        u.setApellido(textApellidos.getText());
        u.setRol(cbRol.getSelectedItem().toString());
        u.setCorreo(textCorreo.getText());
        u.setContrasena(textContrasena.getText());

        String nombre = textNombre.getText();
        String apellido = textApellidos.getText();
        String correo = textCorreo.getText();
        String contrasena = textContrasena.getText();
        String rol = cbRol.getSelectedItem().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        gu.registrarUsuario(nombre, apellido, correo, contrasena, rol);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        btnBuscarUsuario = new javax.swing.JButton();
        textBuscarUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        panelDatos15 = new javax.swing.JPanel();
        textNombre = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        panelDatos16 = new javax.swing.JPanel();
        textApellidos = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        panelDatos17 = new javax.swing.JPanel();
        textCorreo = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        panelDatos18 = new javax.swing.JPanel();
        textContrasena = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        panelDatos19 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        iconCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w-eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 140, 45));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 204));
        btnGuardar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w-guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 140, 45));

        btnAgregar.setBackground(new java.awt.Color(134, 173, 17));
        btnAgregar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_add.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 140, 45));

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombres", "Correo", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 480, 260));

        btnBuscarUsuario.setBackground(new java.awt.Color(0, 102, 204));
        btnBuscarUsuario.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnBuscarUsuario.setForeground(new java.awt.Color(98, 66, 26));
        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_search.png"))); // NOI18N
        btnBuscarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btnBuscarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 30, 30));

        textBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        textBuscarUsuario.setForeground(new java.awt.Color(51, 51, 51));
        textBuscarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(textBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 450, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Buscar por Nombre o Correo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 230, 20));

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
                        .addGroup(panelDatos15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 83, Short.MAX_VALUE))))
        );
        panelDatos15Layout.setVerticalGroup(
            panelDatos15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelDatos15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 270, -1));

        panelDatos16.setBackground(new java.awt.Color(255, 255, 255));

        textApellidos.setBackground(new java.awt.Color(255, 255, 255));
        textApellidos.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textApellidos.setForeground(new java.awt.Color(0, 0, 0));
        textApellidos.setBorder(null);
        textApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellidosActionPerformed(evt);
            }
        });

        jSeparator16.setForeground(new java.awt.Color(0, 102, 204));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("APELLIDOS");

        javax.swing.GroupLayout panelDatos16Layout = new javax.swing.GroupLayout(panelDatos16);
        panelDatos16.setLayout(panelDatos16Layout);
        panelDatos16Layout.setHorizontalGroup(
            panelDatos16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelDatos16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator16)
                    .addGroup(panelDatos16Layout.createSequentialGroup()
                        .addGroup(panelDatos16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 83, Short.MAX_VALUE))))
        );
        panelDatos16Layout.setVerticalGroup(
            panelDatos16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addGap(0, 0, 0)
                .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelDatos16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 270, -1));

        panelDatos17.setBackground(new java.awt.Color(255, 255, 255));

        textCorreo.setBackground(new java.awt.Color(255, 255, 255));
        textCorreo.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textCorreo.setForeground(new java.awt.Color(0, 0, 0));
        textCorreo.setBorder(null);
        textCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCorreoActionPerformed(evt);
            }
        });

        jSeparator17.setForeground(new java.awt.Color(0, 102, 204));

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("CORREO");

        javax.swing.GroupLayout panelDatos17Layout = new javax.swing.GroupLayout(panelDatos17);
        panelDatos17.setLayout(panelDatos17Layout);
        panelDatos17Layout.setHorizontalGroup(
            panelDatos17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelDatos17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator17)
                    .addGroup(panelDatos17Layout.createSequentialGroup()
                        .addGroup(panelDatos17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelDatos17Layout.setVerticalGroup(
            panelDatos17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel22)
                .addGap(0, 0, 0)
                .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelDatos17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 270, -1));

        panelDatos18.setBackground(new java.awt.Color(255, 255, 255));

        textContrasena.setBackground(new java.awt.Color(255, 255, 255));
        textContrasena.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textContrasena.setForeground(new java.awt.Color(0, 0, 0));
        textContrasena.setBorder(null);
        textContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textContrasenaActionPerformed(evt);
            }
        });

        jSeparator18.setForeground(new java.awt.Color(0, 102, 204));

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("CONTRASENA");

        javax.swing.GroupLayout panelDatos18Layout = new javax.swing.GroupLayout(panelDatos18);
        panelDatos18.setLayout(panelDatos18Layout);
        panelDatos18Layout.setHorizontalGroup(
            panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator18)
                    .addGroup(panelDatos18Layout.createSequentialGroup()
                        .addGroup(panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelDatos18Layout.setVerticalGroup(
            panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel23)
                .addGap(0, 0, 0)
                .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelDatos18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 270, -1));

        panelDatos19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("TIPO DE ROL");

        cbRol.setBackground(new java.awt.Color(255, 255, 255));
        cbRol.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        cbRol.setForeground(new java.awt.Color(0, 0, 0));
        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "usuario", "admin" }));
        cbRol.setBorder(null);
        cbRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRolActionPerformed(evt);
            }
        });

        jSeparator20.setForeground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout panelDatos19Layout = new javax.swing.GroupLayout(panelDatos19);
        panelDatos19.setLayout(panelDatos19Layout);
        panelDatos19Layout.setHorizontalGroup(
            panelDatos19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator20)
            .addGroup(panelDatos19Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(cbRol, javax.swing.GroupLayout.Alignment.TRAILING, 0, 180, Short.MAX_VALUE)
        );
        panelDatos19Layout.setVerticalGroup(
            panelDatos19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(0, 0, 0)
                .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelDatos19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 180, 50));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("USUARIOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 238, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:

        registrarUsuario();
        limpiarDatos();


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed

    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void textApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textApellidosActionPerformed

    private void textCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCorreoActionPerformed

    private void textContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textContrasenaActionPerformed

    private void cbRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRolActionPerformed

    private void iconCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCerrarMouseClicked

        this.dispose();
    }//GEN-LAST:event_iconCerrarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JLabel iconCerrar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JPanel panelDatos15;
    private javax.swing.JPanel panelDatos16;
    private javax.swing.JPanel panelDatos17;
    private javax.swing.JPanel panelDatos18;
    private javax.swing.JPanel panelDatos19;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textBuscarUsuario;
    private javax.swing.JTextField textContrasena;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
