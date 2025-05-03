
package Interfaz.Admin;

import Servicio.GestionEmpleado;
import Interfaz.LoginPanel;
import Modelo.Entidades.Categoria;
import Modelo.Entidades.Empleado;
import Modelo.Entidades.Usuario;
import Servicio.GestionCategoria;
import Servicio.GestionIncidente;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static proyectoFinal.gestionTickets.Main.usuario;


public class VistaMetricas extends javax.swing.JFrame {

    private GestionCategoria gestionCategoria;
    private GestionEmpleado gestionEmpleado;
    private GestionIncidente gestionIncidente;

    public VistaMetricas(Usuario usuario) {
        gestionCategoria = new GestionCategoria();
        gestionEmpleado = new GestionEmpleado();
        gestionIncidente = new GestionIncidente();

        initComponents();
        mostrarMetricaIncidentes();
        lbNomUsuario.setText(usuario.getNombre() + " " + usuario.getApellido());
        gestionCategoria.mostrarCategorias(cbCategoria);
        cbCategoria.addActionListener(e -> actualizarEmpleados());

        tableListaEmpleado.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableListaEmpleado.getSelectedRow() != -1) {
                mostrarMetricaEmpleado();
                mostrarHistorialEmpleado();
            }
        });

    }

    private void actualizarEmpleados() {
        gestionEmpleado.cargarEmpleadosPorCategoria(cbCategoria, tableListaEmpleado);
    }

    private void mostrarMetricaIncidentes() {
        int totalIncidentes = gestionIncidente.obtenerTotalIncidentes();
        int totalIncidentesDia = gestionIncidente.obtenerTotalIncidentesDia();
        int incidentesEnCurso = gestionIncidente.obtenerIncidentesEnCurso();
        int empleadosDisponibles = gestionIncidente.obtenerEmpleadosDisponibles();
        String tiempoPromedio = gestionIncidente.obtenerTiempoPromedio();

        textIncidentes.setText(String.valueOf(totalIncidentes));
        textIncidentesDia.setText(String.valueOf(totalIncidentesDia));
        textIncidenteAsignado.setText(String.valueOf(incidentesEnCurso));
        textTotalEmpleadosDisponibles.setText(String.valueOf(empleadosDisponibles));
        textTiempoPromedio.setText(tiempoPromedio);

    }

    private void mostrarMetricaEmpleado() {
        int filaSeleccionada = tableListaEmpleado.getSelectedRow();
        if (filaSeleccionada != -1) {

            String nombreCompleto = tableListaEmpleado.getValueAt(filaSeleccionada, 0).toString();
            Empleado empleado = gestionEmpleado.obtenerDetallesEmpleado(nombreCompleto);

            if (empleado != null) {

                txtIdEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
                txtNombreCompleto.setText(empleado.getNombre() + " " + empleado.getApellido());
                txtEstado.setText(empleado.getEstado());
                txtCelular.setText(empleado.getCelular());
                txtTotalIncidentes.setText(String.valueOf(empleado.getTotalIncidentes()));
                txtPromedioRespuesta.setText(empleado.getPromedioRespuesta() + " min");
            } else {

                limpiarCampos();
            }
        }
    }

    public void mostrarHistorialEmpleado() {
  
        int filaSeleccionada = tableListaEmpleado.getSelectedRow();
        if (filaSeleccionada != -1) {
       
            String nombreCompleto = tableListaEmpleado.getValueAt(filaSeleccionada, 0).toString();

            List<Object[]> incidentes = gestionEmpleado.obtenerIncidentesPorEmpleado(nombreCompleto);

            DefaultTableModel modeloHistorial = (DefaultTableModel) tableHistorial.getModel();
            modeloHistorial.setRowCount(0); 

            for (Object[] incidente : incidentes) {
                modeloHistorial.addRow(incidente);
            }
        }
    }

    private void limpiarCampos() {
        txtIdEmpleado.setText("--");
        txtNombreCompleto.setText("--");
        txtEstado.setText("--");
        txtCelular.setText("--");
        txtTotalIncidentes.setText("--");
        txtPromedioRespuesta.setText("--");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        lbSalirSistema = new javax.swing.JLabel();
        lbVistaColaIncidentes = new javax.swing.JLabel();
        lbVistaMetricas = new javax.swing.JLabel();
        lbVistaHistorial = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistorial = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListaEmpleado = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalIncidentes = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtPromedioRespuesta = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        textIncidentesDia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textIncidenteAsignado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textTiempoPromedio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textTotalEmpleadosDisponibles = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        textIncidentes = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();

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

        lbVistaColaIncidentes.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbVistaColaIncidentes.setForeground(new java.awt.Color(255, 255, 255));
        lbVistaColaIncidentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVistaColaIncidentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (27).png"))); // NOI18N
        lbVistaColaIncidentes.setText("Inicio");
        lbVistaColaIncidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVistaColaIncidentesMouseClicked(evt);
            }
        });
        jPanel3.add(lbVistaColaIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 130, 70));

        lbVistaMetricas.setBackground(new java.awt.Color(0, 102, 204));
        lbVistaMetricas.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbVistaMetricas.setForeground(new java.awt.Color(255, 255, 255));
        lbVistaMetricas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVistaMetricas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (16).png"))); // NOI18N
        lbVistaMetricas.setText("Metricas");
        lbVistaMetricas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVistaMetricas.setOpaque(true);
        lbVistaMetricas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVistaMetricasMouseClicked(evt);
            }
        });
        jPanel3.add(lbVistaMetricas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 120, 70));

        lbVistaHistorial.setBackground(new java.awt.Color(0, 102, 204));
        lbVistaHistorial.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbVistaHistorial.setForeground(new java.awt.Color(255, 255, 255));
        lbVistaHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVistaHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (33).png"))); // NOI18N
        lbVistaHistorial.setText("Tickets");
        lbVistaHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVistaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVistaHistorialMouseClicked(evt);
            }
        });
        jPanel3.add(lbVistaHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 120, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Actividad actual:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 480, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tableHistorial.setBackground(new java.awt.Color(255, 255, 255));
        tableHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tableHistorial.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        tableHistorial.setForeground(new java.awt.Color(0, 102, 204));
        tableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Incidente", "Estado", "Tiempo Resolucion (min)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 560, 190));

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Selecciona una categoria");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        cbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cbCategoria.setForeground(new java.awt.Color(0, 0, 0));
        cbCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 340, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tableListaEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        tableListaEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tableListaEmpleado.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        tableListaEmpleado.setForeground(new java.awt.Color(0, 102, 204));
        tableListaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Estado", "ID Incidente", "Aula", "F. Asignación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableListaEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableListaEmpleado.setGridColor(new java.awt.Color(204, 204, 204));
        tableListaEmpleado.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tableListaEmpleado.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableListaEmpleado.setShowGrid(false);
        jScrollPane2.setViewportView(tableListaEmpleado);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 730, 210));

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ASIGNADOS");

        txtTotalIncidentes.setEditable(false);
        txtTotalIncidentes.setBackground(new java.awt.Color(153, 0, 0));
        txtTotalIncidentes.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        txtTotalIncidentes.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalIncidentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalIncidentes.setText("--");
        txtTotalIncidentes.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalIncidentes, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 130, 90));

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("ID Empleado:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        txtIdEmpleado.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        txtIdEmpleado.setForeground(new java.awt.Color(51, 51, 51));
        txtIdEmpleado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdEmpleado.setText("055545");
        txtIdEmpleado.setBorder(null);
        jPanel2.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 170, 20));

        jLabel32.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Celular:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 70, 20));

        txtCelular.setEditable(false);
        txtCelular.setBackground(new java.awt.Color(255, 255, 255));
        txtCelular.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtCelular.setForeground(new java.awt.Color(0, 102, 204));
        txtCelular.setText("SDFSDF");
        txtCelular.setBorder(null);
        txtCelular.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 170, -1));

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Nombres:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 70, 20));

        txtNombreCompleto.setEditable(false);
        txtNombreCompleto.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCompleto.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtNombreCompleto.setForeground(new java.awt.Color(0, 102, 204));
        txtNombreCompleto.setText("SDFSF");
        txtNombreCompleto.setBorder(null);
        txtNombreCompleto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(txtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 170, -1));

        jSeparator17.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 1010, 10));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PROMEDIO");

        txtPromedioRespuesta.setEditable(false);
        txtPromedioRespuesta.setBackground(new java.awt.Color(51, 51, 51));
        txtPromedioRespuesta.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        txtPromedioRespuesta.setForeground(new java.awt.Color(255, 255, 255));
        txtPromedioRespuesta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPromedioRespuesta.setText("--");
        txtPromedioRespuesta.setBorder(null);
        txtPromedioRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPromedioRespuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPromedioRespuesta)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPromedioRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 130, 90));

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Estado:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 70, -1));

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(255, 255, 255));
        txtEstado.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(0, 102, 204));
        txtEstado.setText("SDFSDF");
        txtEstado.setBorder(null);
        jPanel2.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 170, -1));

        btActualizar.setBackground(new java.awt.Color(134, 173, 17));
        btActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/75 (12).png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btActualizar.setFocusPainted(false);
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 150, 40));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        textIncidentesDia.setEditable(false);
        textIncidentesDia.setBackground(new java.awt.Color(0, 102, 204));
        textIncidentesDia.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        textIncidentesDia.setForeground(new java.awt.Color(255, 255, 255));
        textIncidentesDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textIncidentesDia.setText("-");
        textIncidentesDia.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Incidentes del dia:");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Incidentes en proceso:");

        textIncidenteAsignado.setEditable(false);
        textIncidenteAsignado.setBackground(new java.awt.Color(0, 102, 204));
        textIncidenteAsignado.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        textIncidenteAsignado.setForeground(new java.awt.Color(255, 255, 255));
        textIncidenteAsignado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textIncidenteAsignado.setText("-");
        textIncidenteAsignado.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tiempo promedio de resolucion");

        textTiempoPromedio.setEditable(false);
        textTiempoPromedio.setBackground(new java.awt.Color(0, 102, 204));
        textTiempoPromedio.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        textTiempoPromedio.setForeground(new java.awt.Color(255, 255, 255));
        textTiempoPromedio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTiempoPromedio.setText("--");
        textTiempoPromedio.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Empleados disponibles:");

        textTotalEmpleadosDisponibles.setEditable(false);
        textTotalEmpleadosDisponibles.setBackground(new java.awt.Color(0, 102, 204));
        textTotalEmpleadosDisponibles.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        textTotalEmpleadosDisponibles.setForeground(new java.awt.Color(255, 255, 255));
        textTotalEmpleadosDisponibles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTotalEmpleadosDisponibles.setText("-");
        textTotalEmpleadosDisponibles.setBorder(null);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Total Incidentes:");

        textIncidentes.setEditable(false);
        textIncidentes.setBackground(new java.awt.Color(0, 102, 204));
        textIncidentes.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        textIncidentes.setForeground(new java.awt.Color(255, 255, 255));
        textIncidentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textIncidentes.setText("-");
        textIncidentes.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textTiempoPromedio)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(textTotalEmpleadosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textIncidenteAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textIncidentesDia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIncidentesDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIncidenteAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTotalEmpleadosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textTiempoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 250, 320));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("METRICA POR EMPLEADO");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 250, 20));

        jSeparator18.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 720, 10));

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

    private void lbSalirSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirSistemaMouseClicked
        LoginPanel lp = new LoginPanel();
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbSalirSistemaMouseClicked

    private void lbVistaColaIncidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaColaIncidentesMouseClicked
        VistaColaIncidente ap = new VistaColaIncidente(usuario);
        ap.setVisible(true);
        ap.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_lbVistaColaIncidentesMouseClicked

    private void lbVistaMetricasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaMetricasMouseClicked


    }//GEN-LAST:event_lbVistaMetricasMouseClicked

    private void lbVistaHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaHistorialMouseClicked

        VistaHistorial Ae = new VistaHistorial(usuario);
        Ae.setVisible(true);
        Ae.setLocationRelativeTo(null);
        this.dispose();


    }//GEN-LAST:event_lbVistaHistorialMouseClicked

    private void txtPromedioRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPromedioRespuestaActionPerformed

    }//GEN-LAST:event_txtPromedioRespuestaActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed

    }//GEN-LAST:event_btActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JComboBox<Categoria> cbCategoria;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JLabel lbSalirSistema;
    private javax.swing.JLabel lbVistaColaIncidentes;
    private javax.swing.JLabel lbVistaHistorial;
    private javax.swing.JLabel lbVistaMetricas;
    private javax.swing.JTable tableHistorial;
    private javax.swing.JTable tableListaEmpleado;
    private javax.swing.JTextField textIncidenteAsignado;
    private javax.swing.JTextField textIncidentes;
    private javax.swing.JTextField textIncidentesDia;
    private javax.swing.JTextField textTiempoPromedio;
    private javax.swing.JTextField textTotalEmpleadosDisponibles;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtPromedioRespuesta;
    private javax.swing.JTextField txtTotalIncidentes;
    // End of variables declaration//GEN-END:variables
}
