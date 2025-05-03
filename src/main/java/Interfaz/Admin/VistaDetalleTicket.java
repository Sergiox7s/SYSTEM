package Interfaz.Admin;

import Modelo.DAO.ActividadEmpleadoDAO;
import Modelo.DAO.IncidenteDAO;
import Modelo.Entidades.Incidente;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class VistaDetalleTicket extends javax.swing.JFrame {

    private ActividadEmpleadoDAO actividadEmpleadoDAO;
    private VistaHistorial parent;

    public VistaDetalleTicket(Incidente incidente, VistaHistorial parent) {
        this.parent = parent;
        
        
        initComponents();
        this.actividadEmpleadoDAO = new ActividadEmpleadoDAO();
        cargarDetallesIncidente(incidente);
    }

    private void cargarDetallesIncidente(Incidente incidente) {
        if (incidente != null) {
            txtIdTicket.setText(String.valueOf(incidente.getIdTicket()));
            textFecha.setText(incidente.getFechaReporte().toString());
            txtDocente.setText(incidente.getSolicita().getNombre() + " " + incidente.getSolicita().getApellido());
            txttelefonoDocente.setText(incidente.getCelular());
            txtAula.setText(incidente.getAula());
            lblEstadoTicket.setText(incidente.getEstado());

            // Asignar la hora al nuevo campo txtHora
            if (incidente.getHoraReporte() != null) {
                // Convertir la hora al formato de 12 horas con AM/PM
                String horaConFormato = incidente.getHoraReporte().format(java.time.format.DateTimeFormatter.ofPattern("hh:mm a"));
                txthora.setText(horaConFormato);
            } else {
                txthora.setText("No disponible");
            }
            txtEmpleadoAsignado.setText((incidente.getEmpleadoAsignado() != null)
                    ? incidente.getEmpleadoAsignado().getNombre() : "No asignado");
            txtTipoIncidencia.setText(incidente.getCategoria().getNombre());
            jTextAreaDescripciondelIncindente.setText(incidente.getDescripcion());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel26 = new javax.swing.JLabel();
        textFecha5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripciondelIncindente = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtIdTicket = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txttelefonoDocente = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTipoIncidencia = new javax.swing.JTextField();
        txtEmpleadoAsignado = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtAula = new javax.swing.JTextField();
        lblEstadoTicket = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txthora = new javax.swing.JTextField();
        btnfinalizar = new javax.swing.JButton();
        iconCerrar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("ASUNTO:");

        textFecha5.setEditable(false);
        textFecha5.setBackground(new java.awt.Color(255, 255, 255));
        textFecha5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("DESCRIPCION (*)");

        jTextAreaDescripciondelIncindente.setBackground(new java.awt.Color(255, 255, 255));
        jTextAreaDescripciondelIncindente.setColumns(20);
        jTextAreaDescripciondelIncindente.setForeground(new java.awt.Color(0, 0, 0));
        jTextAreaDescripciondelIncindente.setRows(5);
        jTextAreaDescripciondelIncindente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextAreaDescripciondelIncindente.setFocusable(false);
        jTextAreaDescripciondelIncindente.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextAreaDescripciondelIncindente);

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("SOLICITA:");

        txtDocente.setEditable(false);
        txtDocente.setBackground(new java.awt.Color(255, 255, 255));
        txtDocente.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        txtDocente.setForeground(new java.awt.Color(0, 102, 204));
        txtDocente.setBorder(null);
        txtDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDocente.setFocusable(false);
        txtDocente.setRequestFocusEnabled(false);

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("ESTADO:");

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("FECHA");

        textFecha.setEditable(false);
        textFecha.setBackground(new java.awt.Color(255, 255, 255));
        textFecha.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        textFecha.setForeground(new java.awt.Color(0, 102, 204));
        textFecha.setBorder(null);
        textFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textFecha.setFocusable(false);
        textFecha.setRequestFocusEnabled(false);

        jLabel28.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("TICKET ID:");

        txtIdTicket.setEditable(false);
        txtIdTicket.setBackground(new java.awt.Color(0, 102, 204));
        txtIdTicket.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtIdTicket.setForeground(new java.awt.Color(255, 255, 255));
        txtIdTicket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdTicket.setBorder(null);
        txtIdTicket.setFocusable(false);
        txtIdTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTicketActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("NUMERO DE CONTACTO:");

        txttelefonoDocente.setEditable(false);
        txttelefonoDocente.setBackground(new java.awt.Color(255, 255, 255));
        txttelefonoDocente.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        txttelefonoDocente.setForeground(new java.awt.Color(0, 102, 204));
        txttelefonoDocente.setBorder(null);
        txttelefonoDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txttelefonoDocente.setFocusable(false);
        txttelefonoDocente.setRequestFocusEnabled(false);

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("PERSONAL ASIGNADO:");

        txtTipoIncidencia.setEditable(false);
        txtTipoIncidencia.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoIncidencia.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        txtTipoIncidencia.setForeground(new java.awt.Color(0, 102, 204));
        txtTipoIncidencia.setBorder(null);
        txtTipoIncidencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtTipoIncidencia.setFocusable(false);
        txtTipoIncidencia.setRequestFocusEnabled(false);

        txtEmpleadoAsignado.setEditable(false);
        txtEmpleadoAsignado.setBackground(new java.awt.Color(255, 255, 255));
        txtEmpleadoAsignado.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        txtEmpleadoAsignado.setForeground(new java.awt.Color(0, 102, 204));
        txtEmpleadoAsignado.setBorder(null);
        txtEmpleadoAsignado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEmpleadoAsignado.setFocusable(false);
        txtEmpleadoAsignado.setRequestFocusEnabled(false);

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("TIPO DE INCIDENCIA:");

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("AULA");

        txtAula.setEditable(false);
        txtAula.setBackground(new java.awt.Color(255, 255, 255));
        txtAula.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        txtAula.setForeground(new java.awt.Color(0, 102, 204));
        txtAula.setBorder(null);
        txtAula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAula.setFocusable(false);
        txtAula.setRequestFocusEnabled(false);

        lblEstadoTicket.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        lblEstadoTicket.setForeground(new java.awt.Color(0, 102, 204));
        lblEstadoTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEstadoTicket.setText("---");
        lblEstadoTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblEstadoTicket.setFocusable(false);
        lblEstadoTicket.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("HORA");

        txthora.setEditable(false);
        txthora.setBackground(new java.awt.Color(255, 255, 255));
        txthora.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        txthora.setForeground(new java.awt.Color(0, 102, 204));
        txthora.setBorder(null);
        txthora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txthora.setFocusable(false);
        txthora.setRequestFocusEnabled(false);

        btnfinalizar.setBackground(new java.awt.Color(0, 102, 204));
        btnfinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnfinalizar.setText("FINALIZAR");
        btnfinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttelefonoDocente)
                                            .addComponent(txtTipoIncidencia))
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtAula, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtEmpleadoAsignado, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                            .addComponent(txtIdTicket))
                                        .addGap(70, 70, 70)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel24)
                                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23)
                                            .addComponent(lblEstadoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(btnfinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(0, 0, 0)
                        .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstadoTicket)))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefonoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAula)))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpleadoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnfinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 420, 480));

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
        jPanel2.add(iconCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 50, 50));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("DETALLE DE TICKET");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 250, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTicketActionPerformed

    private void iconCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCerrarMouseClicked

        this.dispose();
    }//GEN-LAST:event_iconCerrarMouseClicked

    private void btnfinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizarActionPerformed

        if (lblEstadoTicket.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(this, "Este ticket ya está finalizado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            btnfinalizar.setEnabled(false);
            return;
        }

        int idTicket = Integer.parseInt(txtIdTicket.getText());

        String[] opciones = {"Sí", "No"};
        int confirmacion = JOptionPane.showOptionDialog(
                this,
                "¿Está seguro de que desea finalizar este ticket?",
                "Confirmar finalización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            IncidenteDAO incidenteDAO = new IncidenteDAO();
            boolean finalizado = incidenteDAO.finalizarTicket(idTicket);

            if (finalizado) {
                JOptionPane.showMessageDialog(this, "El ticket ha sido finalizado exitosamente.");

                lblEstadoTicket.setText("FINALIZADO");
                btnfinalizar.setEnabled(false);
                actividadEmpleadoDAO.actualizarTablaAsignados(parent.tableHistorial);
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un problema al finalizar el ticket.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnfinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfinalizar;
    private javax.swing.JLabel iconCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaDescripciondelIncindente;
    private javax.swing.JLabel lblEstadoTicket;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textFecha5;
    private javax.swing.JTextField txtAula;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtEmpleadoAsignado;
    private javax.swing.JTextField txtIdTicket;
    private javax.swing.JTextField txtTipoIncidencia;
    private javax.swing.JTextField txthora;
    private javax.swing.JTextField txttelefonoDocente;
    // End of variables declaration//GEN-END:variables
}
