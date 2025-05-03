package Interfaz.Admin;

import Modelo.Entidades.Empleado;
import Modelo.Entidades.Usuario;
import Modelo.DAO.CategoriaDAO;
import Modelo.DAO.EmpleadoDAO;
import Servicio.GestionIncidente;
import Interfaz.LoginPanel;
import Modelo.Entidades.Incidente;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Queue;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static proyectoFinal.gestionTickets.Main.usuario;

public class VistaColaIncidente extends javax.swing.JFrame {

    GestionIncidente gestionIncidente;
    private EmpleadoDAO EmpleadoDAO;

    public VistaColaIncidente(Usuario usuario) {
        gestionIncidente = new GestionIncidente();
        EmpleadoDAO = new EmpleadoDAO();

        initComponents();

        mostrarFecha();
        lbNomUsuario.setText(usuario.getNombre() + " " + usuario.getApellido());

        gestionIncidente = new GestionIncidente();

        //gestionIncidente.cargarIncidenciasPendientes(tableColaTickets);
        EmpleadoDAO = new EmpleadoDAO();
        EmpleadoDAO.cargarEmpleadoDisponiblePorCategoria(cbEmpleados, ABORT);
        gestionIncidente.obtenerConteoIncidentesAsignados();
        cargarIncidentesPendientes();
        actualizarContadores();

        tableColaTickets.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && tableColaTickets.getSelectedRow() != -1) {
                    int selectedRow = tableColaTickets.getSelectedRow();
                    int ticketID = (int) tableColaTickets.getValueAt(selectedRow, 0);
                    lbTicketID.setText(String.valueOf(ticketID));

                    String nombreCategoria = tableColaTickets.getValueAt(selectedRow, 1).toString();
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    int idCategoria = categoriaDAO.obtenerIdCategoriaPorNombre(nombreCategoria);

                    if (idCategoria != -1) {
                        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                        empleadoDAO.cargarEmpleadoDisponiblePorCategoria(cbEmpleados, idCategoria);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la categoría seleccionada.");
                    }
                }
            }
        });

        cbEmpleados.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Empleado empleadoSeleccionado = (Empleado) cbEmpleados.getSelectedItem();
                    if (empleadoSeleccionado != null && empleadoSeleccionado.getIdEmpleado() != -1) {

                        EmpleadoDAO estado = new EmpleadoDAO();
                        String estadoEmpleado = estado.obtenerEstadoEmpleado(empleadoSeleccionado.getIdEmpleado());
                        if (estadoEmpleado != null) {

                            lblEstadoEmpleado.setText("Estado: " + estadoEmpleado);
                        } else {
                            lblEstadoEmpleado.setText("Estado: Desconocido");
                        }
                    } else {
                        lblEstadoEmpleado.setText("Estado: N/A");
                    }
                }
            }
        });

    }

    public void mostrarFecha() {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Timer t = new Timer(1000, e -> {
            Date d = new Date();
            String FechaActual = sd.format(d);
            lbFecha.setText(FechaActual);
        });
        t.start();
    }

    private void cargarIncidentesPendientes() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Categoria");
        model.addColumn("Descripción");
        model.addColumn("Aula");
        model.addColumn("Contacto");
        model.addColumn("Estado");
        model.addColumn("Solicitante");
        model.addColumn("Empleado Asignado");
        model.addColumn("Fecha Reporte");
        model.addColumn("Hora Reporte");

        Queue<Incidente> cola = gestionIncidente.cargarIncidenciasPendientes();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        for (Incidente incidente : cola) {

            String nombreCompletoSolicitante = incidente.getSolicita().getNombre();
            if (incidente.getSolicita().getApellido() != null) {
                nombreCompletoSolicitante += " " + incidente.getSolicita().getApellido();
            }

            String horaFormateada = incidente.getHoraReporte().format(timeFormatter);

            model.addRow(new Object[]{
                incidente.getIdTicket(),
                incidente.getCategoria().getNombre(), 
                incidente.getDescripcion(), 
                incidente.getAula(), 
                incidente.getCelular(), 
                incidente.getEstado(),
                nombreCompletoSolicitante, 
                (incidente.getEmpleadoAsignado() != null) ? incidente.getEmpleadoAsignado().getNombre() : "No asignado", 
                incidente.getFechaReporte(), 
                horaFormateada 
            });
        }

        tableColaTickets.setModel(model); 
    }

    public void asignarEmpleado() {
        int selectedRow = tableColaTickets.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un ticket para asignar.");
            return;
        }

        int ticketID = (int) tableColaTickets.getValueAt(selectedRow, 0);

        Empleado empleadoSeleccionado = (Empleado) cbEmpleados.getSelectedItem();
        if (empleadoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un empleado.");
            return;
        }

        int empleadoID = empleadoSeleccionado.getIdEmpleado();

        boolean asignacionExitosa = gestionIncidente.asignarTicketAEmpleado(ticketID, empleadoID);

        if (asignacionExitosa) {
            JOptionPane.showMessageDialog(this, "Ticket asignado correctamente.");
            actualizarContadores();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al asignar el ticket.");
        }
    }

    private void actualizarContadores() {
 
        Queue<Incidente> colaPendientes = gestionIncidente.getColaIncidentesPendientes();
        int enEsperaCount = (colaPendientes != null) ? colaPendientes.size() : 0;
        int asignadosCount = gestionIncidente.obtenerConteoIncidentesAsignados();
        int finalizadosCount = gestionIncidente.obtenerConteoIncidentesFinalizados();

        lblEnESPERA.setText(String.valueOf(enEsperaCount));
        lblASIGNADOS.setText(String.valueOf(asignadosCount));
        lblFinalizados.setText(String.valueOf(finalizadosCount)); 
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tableColaTickets.getModel();
        modelo.setRowCount(0); 

        Queue<Incidente> colaPendientes = gestionIncidente.getColaIncidentesPendientes();
        if (colaPendientes != null) {
            for (Incidente incidente : colaPendientes) {
                Object[] fila = {
                    incidente.getIdTicket(),
                    incidente.getDescripcion(),
                    incidente.getEstado()
                };
                modelo.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableColaTickets = new javax.swing.JTable();
        cbEmpleados = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblFinalizados = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblEnESPERA = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblASIGNADOS = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btActualizar = new javax.swing.JButton();
        lbFecha = new javax.swing.JLabel();
        lblEstadoEmpleado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbTicketID = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lbSalirSistema = new javax.swing.JLabel();
        lbMenuInicio = new javax.swing.JLabel();
        lbVistaHistorial = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbVistaMetricas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tableColaTickets.setBackground(new java.awt.Color(255, 255, 255));
        tableColaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tableColaTickets.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        tableColaTickets.setForeground(new java.awt.Color(0, 102, 204));
        tableColaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Descripcion", "Aula", "Contacto", "F. Reporte", "Estado", "Solicita", "Asignado a"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableColaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableColaTickets.setGridColor(new java.awt.Color(204, 204, 204));
        tableColaTickets.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tableColaTickets.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableColaTickets.setShowGrid(false);
        jScrollPane1.setViewportView(tableColaTickets);

        cbEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        cbEmpleados.setForeground(new java.awt.Color(51, 51, 51));
        cbEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("ASIGNAR A:");

        btnAsignar.setBackground(new java.awt.Color(0, 102, 204));
        btnAsignar.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnAsignar.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w_add.png"))); // NOI18N
        btnAsignar.setText("ASIGNAR");
        btnAsignar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAsignar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsignar.setFocusPainted(false);
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFinalizados.setFont(new java.awt.Font("Tw Cen MT", 1, 22)); // NOI18N
        lblFinalizados.setForeground(new java.awt.Color(51, 51, 51));
        lblFinalizados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinalizados.setText("0");
        jPanel4.add(lblFinalizados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("FINALIZADOS");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 110, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEnESPERA.setFont(new java.awt.Font("Tw Cen MT", 1, 22)); // NOI18N
        lblEnESPERA.setForeground(new java.awt.Color(204, 0, 51));
        lblEnESPERA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnESPERA.setText("0");
        jPanel5.add(lblEnESPERA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("EN ESPERA");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 110, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(134, 173, 17), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblASIGNADOS.setFont(new java.awt.Font("Tw Cen MT", 1, 22)); // NOI18N
        lblASIGNADOS.setForeground(new java.awt.Color(134, 173, 17));
        lblASIGNADOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblASIGNADOS.setText("0");
        jPanel7.add(lblASIGNADOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(134, 173, 17));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ASIGNADOS");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 110, 40));

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

        lbFecha.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(153, 153, 153));

        lblEstadoEmpleado.setText("---");

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));

        lbTicketID.setBackground(new java.awt.Color(0, 102, 204));
        lbTicketID.setFont(new java.awt.Font("Poppins", 1, 28)); // NOI18N
        lbTicketID.setForeground(new java.awt.Color(255, 255, 255));
        lbTicketID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTicketID.setText("0000");

        jLabel30.setFont(new java.awt.Font("Poppins", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("EN TURNO:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(lbTicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstadoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(btActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addComponent(cbEmpleados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(cbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEstadoEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 610));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Control de Incidencias");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 0, 390, 70));

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
        jPanel6.add(lbSalirSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 60, 70));

        lbMenuInicio.setBackground(new java.awt.Color(0, 102, 204));
        lbMenuInicio.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbMenuInicio.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1 (27).png"))); // NOI18N
        lbMenuInicio.setText("Inicio");
        lbMenuInicio.setOpaque(true);
        jPanel6.add(lbMenuInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 130, 70));

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
        jPanel6.add(lbVistaHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 120, 70));

        lbNomUsuario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setText("--");
        jPanel6.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 150, 70));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hola,");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 70));

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
        jPanel6.add(lbVistaMetricas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 120, 70));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        int selectedRow = tableColaTickets.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un ticket de la tabla.");
            return;
        }

        int ticketID = (int) tableColaTickets.getValueAt(selectedRow, 0);

        Empleado empleadoSeleccionado = (Empleado) cbEmpleados.getSelectedItem();
        if (empleadoSeleccionado == null || empleadoSeleccionado.getIdEmpleado() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un empleado.");
            return;
        }
        GestionIncidente incidente = new GestionIncidente();
        int empleadoID = empleadoSeleccionado.getIdEmpleado();

        boolean exito = incidente.asignarTicketAEmpleado(ticketID, empleadoID);

        if (exito) {
            JOptionPane.showMessageDialog(this, "El ticket ha sido asignado exitosamente.");

            cargarIncidentesPendientes();
            actualizarContadores();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al asignar el ticket.");
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void lbVistaHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaHistorialMouseClicked

        VistaHistorial Ae = new VistaHistorial(usuario);
        Ae.setVisible(true);
        Ae.setLocationRelativeTo(null);
        this.dispose();


    }//GEN-LAST:event_lbVistaHistorialMouseClicked

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        cargarIncidentesPendientes();


    }//GEN-LAST:event_btActualizarActionPerformed

    private void lbSalirSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirSistemaMouseClicked

        LoginPanel lp = new LoginPanel();
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbSalirSistemaMouseClicked

    private void lbVistaMetricasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVistaMetricasMouseClicked
        VistaMetricas vm = new VistaMetricas(usuario);
        vm.setVisible(true);
        vm.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_lbVistaMetricasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JComboBox<Empleado> cbEmpleados;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbMenuInicio;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JLabel lbSalirSistema;
    private javax.swing.JLabel lbTicketID;
    private javax.swing.JLabel lbVistaHistorial;
    private javax.swing.JLabel lbVistaMetricas;
    private javax.swing.JLabel lblASIGNADOS;
    private javax.swing.JLabel lblEnESPERA;
    private javax.swing.JLabel lblEstadoEmpleado;
    private javax.swing.JLabel lblFinalizados;
    private javax.swing.JTable tableColaTickets;
    // End of variables declaration//GEN-END:variables
}
