package com.ies9021.snr.view;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.List;

public class ActualizarAlegation extends javax.swing.JFrame {

    private AllegationController controller;
    private List<Allegation> listaAlegaciones;
    private Allegation seleccionada;

    public ActualizarAlegation() {
        initComponents();
        controller = new AllegationController();
        cargarInformantes(); // carga los nombres en txtIdActualizar
        this.setLocationRelativeTo(null); // centrar ventana
    }

    private void cargarInformantes() {
        txtIdActualizar.removeAllItems();
        listaAlegaciones = controller.listarAlegaciones();
        if (listaAlegaciones != null) {
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) txtIdActualizar.getModel();
            for (Allegation a : listaAlegaciones) {
                String nombre = a.getInformer();
                if (nombre == null) {
                    continue;
                }
                // evitamos duplicados
                if (model.getIndexOf(nombre) == -1) {
                    txtIdActualizar.addItem(nombre);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivoActualizado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInformanteActualizado = new javax.swing.JTextArea();
        txtCategoriaActualizada = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDenunciadoActualizado = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtEspecificacionesActualizadas = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        txtIdActualizar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel1.setText("Motivo");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel2.setText("Informante");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel3.setText("Denunciado");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel4.setText("Specificaciones");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel7.setText("Categoría");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(104, 104, 104))
        );

        txtMotivoActualizado.setColumns(20);
        txtMotivoActualizado.setRows(5);
        jScrollPane1.setViewportView(txtMotivoActualizado);

        txtInformanteActualizado.setColumns(20);
        txtInformanteActualizado.setRows(5);
        jScrollPane2.setViewportView(txtInformanteActualizado);

        txtCategoriaActualizada.setFont(new java.awt.Font("Segoe UI Emoji", 2, 14)); // NOI18N
        txtCategoriaActualizada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Falta de mantenimiento", "Deficiencia en la señalización", "Problemas de accesibilidad", "Condiciones de higiene y limpieza", "Fallas en iluminación y seguridad", "Organización deficiente del servicio", "Demoras o tiempos de espera excesivos", "Escasez de recursos o equipamiento", "Riesgos para la salud y seguridad", "Falta de personal capacitado", "Incumplimiento de normativas", " " }));
        txtCategoriaActualizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActualizadaActionPerformed(evt);
            }
        });

        txtDenunciadoActualizado.setColumns(20);
        txtDenunciadoActualizado.setRows(5);
        jScrollPane4.setViewportView(txtDenunciadoActualizado);

        txtEspecificacionesActualizadas.setColumns(20);
        txtEspecificacionesActualizadas.setRows(5);
        jScrollPane5.setViewportView(txtEspecificacionesActualizadas);

        btnActualizar.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        btnActualizar.setText("Actualizar Alegación");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txtIdActualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        txtIdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtCategoriaActualizada, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtIdActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnActualizar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtCategoriaActualizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(txtIdActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCategoriaActualizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActualizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActualizadaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         if (seleccionada != null) {
            seleccionada.setReason(txtMotivoActualizado.getText());
            seleccionada.setInformer(txtInformanteActualizado.getText());
            seleccionada.setCategory((String) txtCategoriaActualizada.getSelectedItem());
            seleccionada.setDenounced(txtDenunciadoActualizado.getText());
            seleccionada.setSpecifications(txtEspecificacionesActualizadas.getText());
            controller.actualizarAlegacion(seleccionada);

            JOptionPane.showMessageDialog(this, "La alegación fue actualizada con éxito");
            this.dispose();
            new SNRFrameAlegation().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un informante antes de actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtIdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActualizarActionPerformed
        String nombre = (String) txtIdActualizar.getSelectedItem();
        if (nombre != null && listaAlegaciones != null) {
            seleccionada = null;
            for (Allegation a : listaAlegaciones) {
                if (nombre.equals(a.getInformer())) {
                    seleccionada = a;
                    txtMotivoActualizado.setText(a.getReason());
                    txtInformanteActualizado.setText(a.getInformer());
                    txtCategoriaActualizada.setSelectedItem(a.getCategory());
                    txtDenunciadoActualizado.setText(a.getDenounced());
                    txtEspecificacionesActualizadas.setText(a.getSpecifications());
                    break;
                }
            }
            if (seleccionada == null) {
                txtMotivoActualizado.setText("");
                txtInformanteActualizado.setText("");
                txtCategoriaActualizada.setSelectedIndex(0);
                txtDenunciadoActualizado.setText("");
                txtEspecificacionesActualizadas.setText("");
            }
        } else {
            seleccionada = null;
        }
    }//GEN-LAST:event_txtIdActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> txtCategoriaActualizada;
    private javax.swing.JTextArea txtDenunciadoActualizado;
    private javax.swing.JTextArea txtEspecificacionesActualizadas;
    private javax.swing.JComboBox<String> txtIdActualizar;
    private javax.swing.JTextArea txtInformanteActualizado;
    private javax.swing.JTextArea txtMotivoActualizado;
    // End of variables declaration//GEN-END:variables
}
