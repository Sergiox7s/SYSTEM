
package Interfaz.Docente;
import Modelo.DAO.TicketDAO;
import Interfaz.LoginPanel;
import Modelo.Entidades.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import proyectoFinal.gestionTickets.Main;


public class VistaDocente extends javax.swing.JFrame {

    Usuario u = new Usuario();
    TicketDAO gestionTicket;
    LoginPanel lp= new LoginPanel();
    
    public VistaDocente(Usuario usuario) {
        this.u = usuario;
        initComponents();
         gestionTicket = new TicketDAO();
         lbNomUsuario.setText(u.getNombre() + " " + u.getApellido()); 
         
          // Cargar los tickets del usuario al iniciar
        cargarTicketsUsuario(u.getId());
        SetImageLabel(jLabel1, "/Img/institucion.jpg");
    }
    
    public void cargarTicketsUsuario(int idUsuario) {
        // Llamar al método de TicketDAO para obtener los tickets del usuario y llenar la tabla
        gestionTicket.obtenerTicketsDeUsuario(idUsuario, tableTicketUserConectado);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTicketUserConectado = new javax.swing.JTable();
        btnBorrarTicket = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        textBuscarTicket = new javax.swing.JTextField();
        btnBuscarTicket = new javax.swing.JButton();
        btnAgregarTicket = new javax.swing.JButton();
        lbMenu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbSalirSistema = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tableTicketUserConectado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tableTicketUserConectado.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        tableTicketUserConectado.setForeground(new java.awt.Color(0, 102, 204));
        tableTicketUserConectado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Descripcion", "Estado", "F. Reporte", "Aula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableTicketUserConectado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableTicketUserConectado.setGridColor(new java.awt.Color(204, 204, 204));
        tableTicketUserConectado.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tableTicketUserConectado.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableTicketUserConectado.setShowGrid(false);
        jScrollPane1.setViewportView(tableTicketUserConectado);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 1000, 370));

        btnBorrarTicket.setBackground(new java.awt.Color(153, 0, 51));
        btnBorrarTicket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnBorrarTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w-eliminar.png"))); // NOI18N
        btnBorrarTicket.setText("ELIMINAR");
        btnBorrarTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrarTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarTicketMouseClicked(evt);
            }
        });
        btnBorrarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTicketActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 150, 40));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Buscar ID de Ticket");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 230, 20));

        jSeparator15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1000, 10));

        textBuscarTicket.setForeground(new java.awt.Color(51, 51, 51));
        textBuscarTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        textBuscarTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarTicketKeyReleased(evt);
            }
        });
        jPanel2.add(textBuscarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 430, 30));

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
        jPanel2.add(btnBuscarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 30, 30));

        btnAgregarTicket.setBackground(new java.awt.Color(0, 102, 204));
        btnAgregarTicket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnAgregarTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_add.png"))); // NOI18N
        btnAgregarTicket.setText("AGREGAR INCIDENTE");
        btnAgregarTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTicketActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 200, 40));

        lbMenu.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbMenu.setForeground(new java.awt.Color(0, 102, 204));
        lbMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/b_home.png"))); // NOI18N
        lbMenu.setText("Inicio  / ");
        lbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 100, 50));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Mis Tickets");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/institucion.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 610));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 610));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSalirSistema.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbSalirSistema.setForeground(new java.awt.Color(255, 255, 255));
        lbSalirSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSalirSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_exit2.png"))); // NOI18N
        lbSalirSistema.setText("SALIR");
        lbSalirSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSalirSistema.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbSalirSistemaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lbSalirSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalirSistemaMouseClicked(evt);
            }
        });
        jPanel1.add(lbSalirSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 60, 70));

        lbNomUsuario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setText("Evelyn Pascual");
        jPanel1.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 150, 70));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hola,");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 70));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Control de Incidencias");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 390, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTicketActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarTicketActionPerformed

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed

    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    private void lbSalirSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirSistemaMouseClicked

        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbSalirSistemaMouseClicked

    private void btnAgregarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTicketActionPerformed

        VistaRegistroTicket ut = new VistaRegistroTicket(Main.usuario);

        ut.setVisible(true);
        ut.setLocationRelativeTo(null);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarTicketActionPerformed

    private void lbSalirSistemaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbSalirSistemaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSalirSistemaAncestorAdded

    private void btnBorrarTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarTicketMouseClicked
        int row = tableTicketUserConectado.getSelectedRow();  // Obtener la fila seleccionada
        if (row >= 0) {
        // Obtener el ID del ticket (columna 0 tiene el ID)
        int idIncidente = (int) tableTicketUserConectado.getValueAt(row, 0);

        // Llamar al método de TicketDAO para eliminar el ticket
        gestionTicket.eliminarTicket(idIncidente);  // Eliminar ticket sin necesidad de pasar el ID del usuario
    } else {
        // Si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un ticket para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
         }
        cargarTicketsUsuario(u.getId());
    }//GEN-LAST:event_btnBorrarTicketMouseClicked

    private void textBuscarTicketKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarTicketKeyReleased
        
    }//GEN-LAST:event_textBuscarTicketKeyReleased
    public void SetImageLabel(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTicket;
    private javax.swing.JButton btnBorrarTicket;
    private javax.swing.JButton btnBuscarTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JLabel lbSalirSistema;
    private javax.swing.JTable tableTicketUserConectado;
    private javax.swing.JTextField textBuscarTicket;
    // End of variables declaration//GEN-END:variables
}
