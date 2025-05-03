
package Interfaz.Docente;

import Interfaz.Docente.VistaDocente;
import Modelo.Entidades.Usuario;
import Servicio.GestionIncidente;
import Modelo.DAO.TicketDAO;
import Interfaz.LoginPanel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import proyectoFinal.gestionTickets.Main;

/**
 *
 * @author rpasc
 */
public class VistaRegistroTicket extends javax.swing.JFrame {

    Usuario u = new Usuario();
    VistaDocente up = new VistaDocente(Main.usuario);
    LoginPanel lp= new LoginPanel();

    public VistaRegistroTicket(Usuario usuario) {
        this.u = usuario;
        initComponents();
        mostrarFecha();
        cargarCategorias();
         lbNomUsuario.setText(u.getNombre() + " " + u.getApellido());
         textNombreUserConectado.setText(usuario.getNombre());
         textApellidoUserConectado.setText(usuario.getApellido());
    }

    public void mostrarFecha() {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Timer t = new Timer(1000, e -> {
            Date d = new Date();
            String fechaHora = s.format(d);
            textFecha.setText(fechaHora);
        });

        t.start();
    }
        private void cargarCategorias() {
        Modelo.DAO.TicketDAO gestion = new Modelo.DAO.TicketDAO();
        gestion.cargarCategorias(cbCategoria);  // Aquí 'cbCategoria' es tu JComboBox
    }
        
      private void actualizarTablaYRegresar() {
        // Llamar al método cargarTicketsUsuario() de VistaDocente
        up.cargarTicketsUsuario(u.getId());  // Actualizamos la tabla antes de regresar
        
        // Hacer visible el VistaDocente y ocultar el VistaRegistroTicket
        up.setVisible(true);
        this.setVisible(false);  // Ocultamos la ventana actual
    }
      
      public void limpiar(){
          textCelular.setText("");
          textAula.setText("");
          textDescripcion.setText("");
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbRegresar = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        textApellidoUserConectado = new javax.swing.JTextField();
        textNombreUserConectado = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnCrearTicket = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        textCelular = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        textAula = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        lbMenu = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        lbSalirSistema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbRegresar.setBackground(new java.awt.Color(0, 0, 0));
        lbRegresar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbRegresar.setForeground(new java.awt.Color(0, 102, 204));
        lbRegresar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRegresar.setText("< Regresar");
        lbRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegresarMouseClicked(evt);
            }
        });
        jPanel2.add(lbRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 120, 30));

        jSeparator15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1000, 10));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("APELLIDOS:");

        textApellidoUserConectado.setEditable(false);
        textApellidoUserConectado.setBackground(new java.awt.Color(255, 255, 255));
        textApellidoUserConectado.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textApellidoUserConectado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        textNombreUserConectado.setEditable(false);
        textNombreUserConectado.setBackground(new java.awt.Color(255, 255, 255));
        textNombreUserConectado.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textNombreUserConectado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        textNombreUserConectado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel31.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("NOMBRE:");

        btnCrearTicket.setBackground(new java.awt.Color(0, 102, 204));
        btnCrearTicket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnCrearTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_add.png"))); // NOI18N
        btnCrearTicket.setText("CREAR TICKET");
        btnCrearTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCrearTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTicketActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("NUMERO DE CONTACTO:");

        textCelular.setBackground(new java.awt.Color(255, 255, 255));
        textCelular.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textCelular.setForeground(new java.awt.Color(0, 0, 0));
        textCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31)
                            .addComponent(jLabel27)
                            .addComponent(jLabel25)
                            .addComponent(textNombreUserConectado, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(textApellidoUserConectado)
                            .addComponent(textCelular)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCrearTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(textNombreUserConectado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(textApellidoUserConectado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCrearTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 310, 480));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("AULA:");

        textAula.setBackground(new java.awt.Color(255, 255, 255));
        textAula.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        textAula.setForeground(new java.awt.Color(0, 0, 0));
        textAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        textFecha.setEditable(false);
        textFecha.setBackground(new java.awt.Color(255, 255, 255));
        textFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFecha.setForeground(new java.awt.Color(102, 102, 102));
        textFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFecha.setBorder(null);

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("TIPO DE INCIDENCIA:");

        cbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cbCategoria.setForeground(new java.awt.Color(0, 0, 0));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", " " }));
        cbCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCategoriaMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("DESCRIPCION (*)");

        textDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        textDescripcion.setColumns(20);
        textDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        textDescripcion.setRows(5);
        textDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane2.setViewportView(textDescripcion);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addGap(140, 140, 140))
                                .addComponent(textAula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 650, 460));

        lbMenu.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbMenu.setForeground(new java.awt.Color(0, 102, 204));
        lbMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/b_home.png"))); // NOI18N
        lbMenu.setText("Inicio  / ");
        lbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 100, 50));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 204));
        jLabel14.setText("Nuevo Ticket");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 610));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Control de Incidencias");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 390, 70));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hola,");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 70));

        lbNomUsuario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setText("Evelyn Pascual");
        jPanel1.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 150, 70));

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
        jPanel1.add(lbSalirSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 60, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTicketActionPerformed
       String selectedCategory = (String) cbCategoria.getSelectedItem();
       String aula = textAula.getText().trim();
       String celular = textCelular.getText().trim();

    // Validación de la categoría seleccionada
    if (selectedCategory != null && selectedCategory.equals("Seleccionar tipo de incidencia")) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de incidencia.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    
    if (aula.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese el número del aula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    if (celular.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de celular.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    if (celular.length() != 9 || !celular.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "El número de celular debe contener exactamente 9 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    // Si todas las validaciones pasan, proceder con la creación del ticket
    // Aquí se agregaría el código para crear el ticket
      TicketDAO gestionTicket = new TicketDAO();
      gestionTicket.crearTicket(textFecha, textAula, textCelular, cbCategoria, textDescripcion, u);  
        limpiar();
        
    }//GEN-LAST:event_btnCrearTicketActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        up.setVisible(true);
        up.setLocationRelativeTo(null);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lbRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresarMouseClicked
         actualizarTablaYRegresar();
        up.setVisible(true);
        up.setLocationRelativeTo(null);
        
        this.dispose();
        

        
    }//GEN-LAST:event_lbRegresarMouseClicked

    private void cbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCategoriaMouseClicked

    }//GEN-LAST:event_cbCategoriaMouseClicked

    private void lbSalirSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirSistemaMouseClicked
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbSalirSistemaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearTicket;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JLabel lbRegresar;
    private javax.swing.JLabel lbSalirSistema;
    private javax.swing.JTextField textApellidoUserConectado;
    private javax.swing.JTextField textAula;
    private javax.swing.JTextField textCelular;
    private javax.swing.JTextArea textDescripcion;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textNombreUserConectado;
    // End of variables declaration//GEN-END:variables
}
