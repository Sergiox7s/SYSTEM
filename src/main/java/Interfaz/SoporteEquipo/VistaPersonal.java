package Interfaz.SoporteEquipo;

import Modelo.Entidades.Usuario;
import Servicio.GestionIncidente;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class VistaPersonal extends javax.swing.JFrame {

    private GestionIncidente gestionIncidente;
    private Usuario usuario;
    private int añoActual = java.time.Year.now().getValue(); // Obtiene el año actual

    public VistaPersonal(Usuario usuario) {
        this.usuario = usuario;
        this.gestionIncidente = new GestionIncidente();
        initComponents();
        cargarEstadisticas();
    }

        private void cargarEstadisticas() {
        try {
            Map<Integer, Integer> estadisticas = gestionIncidente.obtenerEstadisticasPorMes(añoActual, usuario.getId());
            
            // Calcular total de incidentes para porcentajes
            int total = estadisticas.values().stream().mapToInt(Integer::intValue).sum();
            
            // Actualizar campos de texto con los porcentajes
            for (int mes = 1; mes <= 12; mes++) {
                int cantidad = estadisticas.getOrDefault(mes, 0);
                double porcentaje = total > 0 ? (cantidad * 100.0 / total) : 0;
                
                switch (mes) {
                    case 1 -> campoEnero.setText(String.format("%.1f%%", porcentaje));
                    case 2 -> campoFebrero.setText(String.format("%.1f%%", porcentaje));
                    case 3 -> campoMarzo.setText(String.format("%.1f%%", porcentaje));
                    case 4 -> campoAbril.setText(String.format("%.1f%%", porcentaje));
                    case 5 -> campoMayo.setText(String.format("%.1f%%", porcentaje));
                    case 6 -> campoJunio.setText(String.format("%.1f%%", porcentaje));
                    case 7 -> campoJulio.setText(String.format("%.1f%%", porcentaje));
                    case 8 -> campoAgosto.setText(String.format("%.1f%%", porcentaje));
                    case 9 -> campoSeptiembre.setText(String.format("%.1f%%", porcentaje));
                    case 10 -> campoOctubre.setText(String.format("%.1f%%", porcentaje));
                    case 11 -> campoNoviembre.setText(String.format("%.1f%%", porcentaje));
                    case 12 -> campoDiciembre.setText(String.format("%.1f%%", porcentaje));
                }
            }
            
            // Mostrar gráfico
            mostrarGrafico(estadisticas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar estadísticas: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarGrafico(Map<Integer, Integer> estadisticas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        for (int mes = 1; mes <= 12; mes++) {
            int cantidad = estadisticas.getOrDefault(mes, 0);
            dataset.addValue(cantidad, "Incidentes", meses[mes - 1]);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "Incidentes Completados por Mes - Año " + añoActual,
            "Mes",
            "Cantidad de Incidentes",
            dataset
        );
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        
        // Crear ventana para el gráfico
        javax.swing.JFrame frameGrafico = new javax.swing.JFrame("Estadísticas de Incidentes");
        frameGrafico.setContentPane(chartPanel);
        frameGrafico.pack();
        frameGrafico.setLocationRelativeTo(this);
        frameGrafico.setVisible(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Graficos De Incidentes por Mes");

        jLabel2.setText("ENERO %");

        jLabel3.setText("FEBRERO %");

        jLabel4.setText("MARZO %");

        jLabel5.setText("ABRIL %");

        jLabel6.setText("MAYO %");

        jLabel7.setText("JUNIO %");

        jLabel8.setText("JULIO %");

        jLabel9.setText("AGOSTO %");

        jLabel10.setText("SETIEMBRE %");

        jLabel11.setText("OCTUBRE %");

        jLabel12.setText("NOVIEMBRE %");

        jLabel13.setText("DICIEMBRE %");

        campoEnero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEneroActionPerformed(evt);
            }
        });

        campoFebrero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFebreroActionPerformed(evt);
            }
        });

        campoMarzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMarzoActionPerformed(evt);
            }
        });

        campoAbril.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAbrilActionPerformed(evt);
            }
        });

        campoMayo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMayoActionPerformed(evt);
            }
        });

        campoJunio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoJunioActionPerformed(evt);
            }
        });

        campoJulio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoJulioActionPerformed(evt);
            }
        });

        campoAgosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAgostoActionPerformed(evt);
            }
        });

        campoSeptiembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSeptiembreActionPerformed(evt);
            }
        });

        campoOctubre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOctubreActionPerformed(evt);
            }
        });

        campoNoviembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNoviembreActionPerformed(evt);
            }
        });

        campoDiciembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDiciembreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoEnero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoFebrero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMarzo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAbril, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMayo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoJunio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoJulio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAgosto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoSeptiembre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoOctubre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNoviembre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDiciembre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoEnero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoFebrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMarzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAbril, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMayo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoJunio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoJulio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAgosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoSeptiembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoOctubre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNoviembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDiciembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables
}
