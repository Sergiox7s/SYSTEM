/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package Interfaz.SoporteEquipo;

import Modelo.DAO.TicketDAO;
import Modelo.Entidades.Empleado;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class VistaEmpleado extends java.awt.Frame {

    Empleado emple=new Empleado();
    TicketDAO gestionTicket;
    
    
    
    public VistaEmpleado(Empleado empleado) {
        this.emple=empleado;
        initComponents();
        
        
        gestionTicket = new TicketDAO();
        lblNombreEmpleado.setText(emple.getNombre() + " " + emple.getApellido()); 
        cargarTicketsUsuario(emple.getIdEmpleado());
        
        
        SetImageLabel(jLabel1, "/Img/apoyoicon.png");
        SetImageButton(jButton1, "/Img/completado.png");
        SetImageButton(jButton2, "/Img/warFile.png");
        SetImageButton(jButton3, "/Img/checkgreen.png");
        SetImageButton(jButton4, "/Img/reporteAnual.png");
    }
    
    public void cargarTicketsUsuario(int idUsuario) {
        // Llamar al método de TicketDAO para obtener los tickets del usuario y llenar la tabla
        gestionTicket.obtenerTicketsDeUsuario(idUsuario, tableTicketActual);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        lblSalirSistema = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTicketActual = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Control de Incidencias");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hola");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        lblNombreEmpleado.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        lblNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpleado.setText("Juan");
        jPanel2.add(lblNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 60, 60));

        lblSalirSistema.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        lblSalirSistema.setForeground(new java.awt.Color(255, 255, 255));
        lblSalirSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_exit2.png"))); // NOI18N
        lblSalirSistema.setText("SALIR");
        jPanel2.add(lblSalirSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/apoyoicon.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 150));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("name");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 180, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("DISPONIBILIDAD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 150, 20));

        tableTicketActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "titlt5", "tit6", "tit7", "tit8", "tit9"
            }
        ));
        jScrollPane1.setViewportView(tableTicketActual);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 930, 340));

        jLabel7.setText("PENDIENTES");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel8.setText("COMPLETADOS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("REPORTES ANUAL");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 110, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/checkgreen.png"))); // NOI18N
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, 110));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/warFile.png"))); // NOI18N
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 110));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteAnual.png"))); // NOI18N
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 120, 110));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 440, 180));

        jLabel10.setText("FINALIZAR TICKET");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, 110, 30));

        jLabel12.setText("#Pagina");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        jLabel13.setText("Total de registro Por pagina");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 140, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 150, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/completado.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 90, 80));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
            System.exit(0);
    }//GEN-LAST:event_exitForm


    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEmpleado().setVisible(true);
            }
        });
    }*/
    
    public void SetImageLabel(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }
    public void SetImageButton(JButton button, String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(
            button.getWidth(), 
            button.getHeight(), 
            Image.SCALE_SMOOTH
        );
        button.setIcon(new ImageIcon(img)); // Establece la imagen en el botón
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblSalirSistema;
    private javax.swing.JTable tableTicketActual;
    // End of variables declaration//GEN-END:variables
}
