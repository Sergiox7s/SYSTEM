package Interfaz.SoporteEquipo;

import Interfaz.Admin.VistaMetricas;
import Modelo.Entidades.Empleado;
import Modelo.Entidades.Usuario;
import Servicio.GestionIncidente;
import java.awt.Image;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class VistaPersonal extends javax.swing.JFrame {

    private GestionIncidente gestionIncidente;
    private Usuario usuario;
    private Empleado empleado;
    private javax.swing.JFrame ventanaAnterior;
    private int añoActual = java.time.Year.now().getValue(); // Obtiene el año actual

    public VistaPersonal(Usuario usuario,Empleado empleado , javax.swing.JFrame ventanaAnterior) {
        this.usuario = usuario;
        this.empleado = empleado;
        this.ventanaAnterior = ventanaAnterior;
        this.gestionIncidente = new GestionIncidente();
        initComponents();
        if (empleado != null) {
            jLabelTitulo.setText("Reporte Anual - " + empleado.getNombre() + " " + empleado.getApellido());
        }

        panelGrafico.setLayout(new java.awt.BorderLayout());
        panelGrafico.setPreferredSize(new java.awt.Dimension(600, 400));
        cargarEstadisticas();
        SetImageLabel(jLabel14, "/Img/cieloblanco.jpg");
    }

    private void cargarEstadisticas() {
        try {
             int idParaConsulta = (empleado != null) ? empleado.getIdEmpleado() : usuario.getId();
        Map<Integer, Integer> estadisticas = gestionIncidente.obtenerEstadisticasPorMes(añoActual, idParaConsulta);

            int total = estadisticas.values().stream().mapToInt(Integer::intValue).sum();

            // Actualizar campos con porcentaje y cantidad
            for (int mes = 1; mes <= 12; mes++) {
                int cantidad = estadisticas.getOrDefault(mes, 0);
                double porcentaje = total > 0 ? (cantidad * 100.0 / total) : 0;

                String texto = String.format("%.1f%% (%d)", porcentaje, cantidad);

                switch (mes) {
                    case 1 ->
                        campoEnero.setText(texto);
                    case 2 ->
                        campoFebrero.setText(texto);
                    case 3 ->
                        campoMarzo.setText(texto);
                    case 4 ->
                        campoAbril.setText(texto);
                    case 5 ->
                        campoMayo.setText(texto);
                    case 6 ->
                        campoJunio.setText(texto);
                    case 7 ->
                        campoJulio.setText(texto);
                    case 8 ->
                        campoAgosto.setText(texto);
                    case 9 ->
                        campoSeptiembre.setText(texto);
                    case 10 ->
                        campoOctubre.setText(texto);
                    case 11 ->
                        campoNoviembre.setText(texto);
                    case 12 ->
                        campoDiciembre.setText(texto);
                }
            }

            mostrarGraficoEnPanel(estadisticas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar estadísticas: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarGraficoEnPanel(Map<Integer, Integer> estadisticas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        for (int mes = 1; mes <= 12; mes++) {
            dataset.addValue(estadisticas.getOrDefault(mes, 0), "Incidentes", meses[mes - 1]);
        }
        
        //NUEVO: Título personalizado con nombre de empleado
        String titulo = (empleado != null) 
                ? "Incidentes de " + empleado.getNombre() + " - Año " + añoActual
                : "Incidentes Completados por Mes - Año " + añoActual;

        JFreeChart chart = ChartFactory.createBarChart(
                "Incidentes Completados por Mes - Año " + añoActual,
                "Mes",
                "Cantidad de Incidentes",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        // Limpiar y actualizar el panel
        panelGrafico.removeAll();
        panelGrafico.add(chartPanel, java.awt.BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();

    }

    public void SetImageLabel(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        campoEnero = new javax.swing.JTextField();
        campoFebrero = new javax.swing.JTextField();
        campoMarzo = new javax.swing.JTextField();
        campoAbril = new javax.swing.JTextField();
        campoMayo = new javax.swing.JTextField();
        campoJunio = new javax.swing.JTextField();
        campoJulio = new javax.swing.JTextField();
        campoAgosto = new javax.swing.JTextField();
        campoSeptiembre = new javax.swing.JTextField();
        campoOctubre = new javax.swing.JTextField();
        campoNoviembre = new javax.swing.JTextField();
        campoDiciembre = new javax.swing.JTextField();
        panelGrafico = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Graficos De Incidentes por Mes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 32, 300, 25));

        jLabel2.setText("ENERO %");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 75, 65, 27));

        jLabel3.setText("FEBRERO %");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 108, 65, 27));

        jLabel4.setText("MARZO %");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 141, 65, 27));

        jLabel5.setText("ABRIL %");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 174, 65, 27));

        jLabel6.setText("MAYO %");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 207, 65, 27));

        jLabel7.setText("JUNIO %");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 240, 65, 27));

        jLabel8.setText("JULIO %");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 273, 65, 27));

        jLabel9.setText("AGOSTO %");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 306, 65, 27));

        jLabel10.setText("SETIEMBRE %");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 339, -1, 29));

        jLabel11.setText("OCTUBRE %");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 374, 65, 29));

        jLabel12.setText("NOVIEMBRE %");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 409, -1, 29));

        jLabel13.setText("DICIEMBRE %");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 444, 78, 29));

        jLabelTitulo.setText("jLabel15");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        campoEnero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEneroActionPerformed(evt);
            }
        });
        jPanel1.add(campoEnero, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 77, 90, -1));

        campoFebrero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFebreroActionPerformed(evt);
            }
        });
        jPanel1.add(campoFebrero, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 110, 90, -1));

        campoMarzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMarzoActionPerformed(evt);
            }
        });
        jPanel1.add(campoMarzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 143, 90, -1));

        campoAbril.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAbrilActionPerformed(evt);
            }
        });
        jPanel1.add(campoAbril, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 176, 90, -1));

        campoMayo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMayoActionPerformed(evt);
            }
        });
        jPanel1.add(campoMayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 209, 90, -1));

        campoJunio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoJunioActionPerformed(evt);
            }
        });
        jPanel1.add(campoJunio, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 242, 90, -1));

        campoJulio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoJulioActionPerformed(evt);
            }
        });
        jPanel1.add(campoJulio, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 275, 90, -1));

        campoAgosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAgostoActionPerformed(evt);
            }
        });
        jPanel1.add(campoAgosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 308, 90, -1));

        campoSeptiembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSeptiembreActionPerformed(evt);
            }
        });
        jPanel1.add(campoSeptiembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 342, 90, -1));

        campoOctubre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOctubreActionPerformed(evt);
            }
        });
        jPanel1.add(campoOctubre, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 377, 90, -1));

        campoNoviembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNoviembreActionPerformed(evt);
            }
        });
        jPanel1.add(campoNoviembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 412, 90, -1));

        campoDiciembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDiciembreActionPerformed(evt);
            }
        });
        jPanel1.add(campoDiciembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 447, 90, -1));

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jPanel1.add(panelGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 75, 760, 480));

        btnAtras.setText("ATRAS");
        btnAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 120, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cieloBlanco.jpg"))); // NOI18N
        jLabel14.setText("asdas");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoEneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEneroActionPerformed

    private void campoFebreroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFebreroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFebreroActionPerformed

    private void campoMarzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMarzoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMarzoActionPerformed

    private void campoAbrilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAbrilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAbrilActionPerformed

    private void campoMayoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMayoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMayoActionPerformed

    private void campoJunioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoJunioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoJunioActionPerformed

    private void campoJulioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoJulioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoJulioActionPerformed

    private void campoAgostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAgostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAgostoActionPerformed

    private void campoSeptiembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSeptiembreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSeptiembreActionPerformed

    private void campoOctubreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoOctubreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOctubreActionPerformed

    private void campoNoviembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNoviembreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNoviembreActionPerformed

    private void campoDiciembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDiciembreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDiciembreActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        regresarAVistaAnterior();

    }//GEN-LAST:event_btnAtrasActionPerformed

    private void regresarAVistaAnterior() {
        // Cierra la ventana actual
        this.dispose(); // Cierra la ventana actual
    
        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true); // Muestra la ventana anterior
            ventanaAnterior.setLocationRelativeTo(null); // Centra la ventana
        } else {
            // Si no hay ventana anterior definida, abre VistaMetricas por defecto
            new VistaMetricas(this.usuario).setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JTextField campoAbril;
    private javax.swing.JTextField campoAgosto;
    private javax.swing.JTextField campoDiciembre;
    private javax.swing.JTextField campoEnero;
    private javax.swing.JTextField campoFebrero;
    private javax.swing.JTextField campoJulio;
    private javax.swing.JTextField campoJunio;
    private javax.swing.JTextField campoMarzo;
    private javax.swing.JTextField campoMayo;
    private javax.swing.JTextField campoNoviembre;
    private javax.swing.JTextField campoOctubre;
    private javax.swing.JTextField campoSeptiembre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables
}
