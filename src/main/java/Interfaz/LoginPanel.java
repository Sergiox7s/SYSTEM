
package Interfaz;

import Interfaz.Docente.VistaDocente;
import Interfaz.Admin.VistaColaIncidente;
import Interfaz.SoporteEquipo.VistaEmpleado;
import Modelo.Entidades.Usuario;
import Modelo.DAO.UsuarioDAO;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import proyectoFinal.gestionTickets.Main;
import static proyectoFinal.gestionTickets.Main.usuario;


public class LoginPanel extends javax.swing.JFrame {

    UsuarioDAO gu = new UsuarioDAO();
    Usuario u = new Usuario();

    public LoginPanel() {

        initComponents();
        SetImageLabel(jLabel3, "/Img/fondologin3.jpg");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        panelDatos20 = new javax.swing.JPanel();
        textCorreo = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        panelDatos18 = new javax.swing.JPanel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        textContrasena = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Control de Incidencias");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 390, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(0, 0, 0,100));
        panelLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, null, java.awt.Color.lightGray, java.awt.Color.darkGray));
        panelLogin.setForeground(new java.awt.Color(42, 95, 147));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INICIAR SESION");
        panelLogin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 70, 371, -1));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 204));
        btnIngresar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorderPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelLogin.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 329, 205, 44));

        panelDatos20.setBackground(new java.awt.Color(204, 204, 204));

        textCorreo.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textCorreo.setText("@gmail.com");
        textCorreo.setBorder(null);
        textCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCorreoActionPerformed(evt);
            }
        });

        jSeparator19.setForeground(new java.awt.Color(0, 102, 204));

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 204));
        jLabel27.setText("CORREO");

        javax.swing.GroupLayout panelDatos20Layout = new javax.swing.GroupLayout(panelDatos20);
        panelDatos20.setLayout(panelDatos20Layout);
        panelDatos20Layout.setHorizontalGroup(
            panelDatos20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelDatos20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator19)
                    .addGroup(panelDatos20Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
        );
        panelDatos20Layout.setVerticalGroup(
            panelDatos20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel27)
                .addGap(0, 0, 0)
                .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelLogin.add(panelDatos20, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 161, -1, -1));

        panelDatos18.setBackground(new java.awt.Color(204, 204, 204));

        jSeparator17.setForeground(new java.awt.Color(0, 102, 204));

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 204));
        jLabel25.setText("CONTRASENA");

        textContrasena.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textContrasena.setBorder(null);

        javax.swing.GroupLayout panelDatos18Layout = new javax.swing.GroupLayout(panelDatos18);
        panelDatos18.setLayout(panelDatos18Layout);
        panelDatos18Layout.setHorizontalGroup(
            panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator17)
                    .addGroup(panelDatos18Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textContrasena)))
        );
        panelDatos18Layout.setVerticalGroup(
            panelDatos18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel25)
                .addGap(0, 0, 0)
                .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelLogin.add(panelDatos18, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 238, 205, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_user.png"))); // NOI18N
        panelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 172, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_lock.png"))); // NOI18N
        panelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 249, -1, -1));

        jPanel2.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 62, -1, 440));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondologin3.jpg"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setMaximumSize(new java.awt.Dimension(3000, 2000));
        jLabel3.setMinimumSize(new java.awt.Dimension(600, 400));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 610));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCorreoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        try {
            String correo = textCorreo.getText();
            String contrasena = textContrasena.getText();

            if (contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese una contraseña.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            u = gu.verificarUsuario(correo, contrasena);

            if (u != null) {

                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                Main.usuario = u; // Asignar el empleado autenticado a Main.empleado

                if (u.getRol().equals("admin")) {
                    
                    VistaColaIncidente ap = new VistaColaIncidente(Main.usuario);
                    ap.setVisible(true);
                    ap.setLocationRelativeTo(null);
                    this.dispose();

                }else if(u.getRol().equals("usuario")){

                    VistaDocente up = new VistaDocente(Main.usuario);
                    up.setVisible(true);
                    up.setLocationRelativeTo(null);
                    this.dispose();

                }else if(u.getRol().equals("empleado")){
                    VistaEmpleado emple = new VistaEmpleado(Main.usuario);
                    emple.setVisible(true);
                    emple.setLocationRelativeTo(null);
                    this.dispose();
                }

            } else {

                JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }  catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnIngresarActionPerformed
    //construccion escalabel de imagen
    public void SetImageLabel(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JPanel panelDatos18;
    private javax.swing.JPanel panelDatos20;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField textContrasena;
    private javax.swing.JTextField textCorreo;
    // End of variables declaration//GEN-END:variables
}
