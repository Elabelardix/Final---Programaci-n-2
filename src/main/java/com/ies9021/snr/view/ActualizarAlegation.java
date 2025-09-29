package com.ies9021.snr.view;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;

import javax.swing.*;
import java.util.List;

public class ActualizarAlegation extends javax.swing.JFrame {

    private AllegationController controller;
    private List<Allegation> listaAlegaciones;
    private Allegation seleccionada;

    private JTextArea txtMotivoActualizado;

    public ActualizarAlegation() {
        initComponents();
        controller = new AllegationController();

        // Crear y agregar txtMotivoActualizado al panel
        txtMotivoActualizado = new JTextArea(3, 20);
        JScrollPane scrollMotivo = new JScrollPane(txtMotivoActualizado);
        jPanel2.add(scrollMotivo);
        jPanel2.revalidate();
        jPanel2.repaint();

        cargarAlegaciones();
        cargarEntidades();
        cargarCategorias();

        this.setLocationRelativeTo(null);

        // Listener para actualizar los campos al seleccionar
        txtAllegacionActualizar.addActionListener(evt -> cargarSeleccion());

        // Listener del botón actualizar
        btnActualizar.addActionListener(evt -> actualizarAlegacion());
    }

    private void cargarAlegaciones() {
        cbCargarReclamoAActualizar.removeAllItems();
        listaAlegaciones = controller.listarAlegaciones(); // Trae todas las alegaciones pendientes
        if (listaAlegaciones != null) {
            for (Allegation a : listaAlegaciones) {
                cbCargarReclamoAActualizar.addItem(a.getIdAllegation() + " - " + a.getReason());
            }
        }
    }

    private void cargarEntidades() {
        cbEntidadDenunciada.removeAllItems();

        // Obtener todas las entidades desde el controller
        List<String> entidades = controller.listarEntidades(); // debe devolver "id - entity_name"
        for (String entidad : entidades) {
            cbEntidadDenunciada.addItem(entidad);
        }
    }

    private void cargarCategorias() {
        cbCategoríaAllegación.removeAllItems();
        String[] categorias = {
            "Error en el servicio", "Retraso en la entrega", "Producto defectuoso",
            "Cobro indebido", "Atención al cliente inadecuada", "Documentación incompleta",
            "Duplicado de reclamo", "Fraude o intento de fraude", "Otro"
        };
        for (String cat : categorias) {
            cbCategoríaAllegación.addItem(cat);
        }
    }

    private void cargarSeleccion() {
        String seleccionadoStr = (String) txtAllegacionActualizar.getSelectedItem();
        if (seleccionadoStr != null && listaAlegaciones != null) {
            int id = Integer.parseInt(seleccionadoStr.replace("Allegation #", ""));
            seleccionada = listaAlegaciones.stream()
                    .filter(a -> a.getIdAllegation() == id)
                    .findFirst()
                    .orElse(null);

            if (seleccionada != null) {
                txtMotivoActualizado.setText(seleccionada.getReason());

                // Seleccionar entidad en el combo
                for (int i = 0; i < cbEntidadDenunciada.getItemCount(); i++) {
                    String item = cbEntidadDenunciada.getItemAt(i);
                    if (item.startsWith(seleccionada.getIdEntity() + " -")) {
                        cbEntidadDenunciada.setSelectedIndex(i);
                        break;
                    }
                }

                cbCategoríaAllegación.setSelectedIndex(seleccionada.getIdCategory() - 1);
            } else {
                txtMotivoActualizado.setText("");
                cbEntidadDenunciada.setSelectedIndex(-1);
                cbCategoríaAllegación.setSelectedIndex(-1);
            }
        }
    }

    private void actualizarAlegacion() {
        if (seleccionada != null) {
            seleccionada.setReason(txtMotivoActualizado.getText());

            // Obtener ID de entidad seleccionado
            String seleccionadoEntidad = (String) cbEntidadDenunciada.getSelectedItem();
            if (seleccionadoEntidad != null) {
                int idEntity = Integer.parseInt(seleccionadoEntidad.split(" - ")[0]);
                seleccionada.setIdEntity(idEntity);
            }

            seleccionada.setIdCategory(cbCategoríaAllegación.getSelectedIndex() + 1);

            boolean exito = controller.actualizarAlegacion(seleccionada);
            if (exito) {
                JOptionPane.showMessageDialog(this, "La alegación fue actualizada con éxito.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la alegación.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una alegación.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAllegaciónActualizada = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        txtAllegacionActualizar = new javax.swing.JComboBox<>();
        cbCargarReclamoAActualizar = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        cbCategoríaAllegación = new javax.swing.JComboBox<>();
        cbEntidadDenunciada = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel1.setText("Reclamo a Actualizar");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel2.setText("Allegación");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel3.setText("Categoría");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel7.setText("Entidad Denunciada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAllegaciónActualizada.setColumns(20);
        txtAllegaciónActualizada.setRows(5);
        jScrollPane2.setViewportView(txtAllegaciónActualizada);

        btnActualizar.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        btnActualizar.setText("Actualizar Alegación");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txtAllegacionActualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        txtAllegacionActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAllegacionActualizarActionPerformed(evt);
            }
        });

        cbCargarReclamoAActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargarReclamoAActualizarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        btnVolver.setText("Finalizar");
        btnVolver.setActionCommand("Salir");
        btnVolver.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cbCategoríaAllegación.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Error en el servicio", "Retraso en la entrega", "Producto defectuoso", "Cobro indebido", "Atención al cliente inadecuada", "Documentación incompleta", "Duplicado de reclamo", "Fraude o intento de fraude", "Otro" }));
        cbCategoríaAllegación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoríaAllegaciónActionPerformed(evt);
            }
        });

        cbEntidadDenunciada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntidadDenunciadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtAllegacionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnActualizar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbCargarReclamoAActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbCategoríaAllegación, javax.swing.GroupLayout.Alignment.LEADING, 0, 301, Short.MAX_VALUE)
                                    .addComponent(cbEntidadDenunciada, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cbCargarReclamoAActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(cbEntidadDenunciada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(cbCategoríaAllegación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAllegacionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarAlegacion();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbCargarReclamoAActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargarReclamoAActualizarActionPerformed
        String seleccionadoStr = (String) cbCargarReclamoAActualizar.getSelectedItem();
        if (seleccionadoStr != null && listaAlegaciones != null) {
            int idAllegation = Integer.parseInt(seleccionadoStr.split(" - ")[0]);
            seleccionada = listaAlegaciones.stream()
                    .filter(a -> a.getIdAllegation() == idAllegation)
                    .findFirst()
                    .orElse(null);

            if (seleccionada != null) {
                txtMotivoActualizado.setText(seleccionada.getReason());
                cbEntidadDenunciada.setSelectedItem(String.valueOf(seleccionada.getIdEntity()));
                cbCategoríaAllegación.setSelectedIndex(seleccionada.getIdCategory() - 1);
            }
        }
    }//GEN-LAST:event_cbCargarReclamoAActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbCategoríaAllegaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoríaAllegaciónActionPerformed
        if (cbEntidadDenunciada.getSelectedItem() != null)
            System.out.println(cbEntidadDenunciada.getSelectedItem().toString());
    }//GEN-LAST:event_cbCategoríaAllegaciónActionPerformed

    private void cbEntidadDenunciadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntidadDenunciadaActionPerformed
        if (cbEntidadDenunciada.getSelectedItem() != null)
            System.out.println(cbEntidadDenunciada.getSelectedItem().toString());
    }//GEN-LAST:event_cbEntidadDenunciadaActionPerformed

    private void txtAllegacionActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAllegacionActualizarActionPerformed
        cargarSeleccion();
    }//GEN-LAST:event_txtAllegacionActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbCargarReclamoAActualizar;
    private javax.swing.JComboBox<String> cbCategoríaAllegación;
    private javax.swing.JComboBox<String> cbEntidadDenunciada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> txtAllegacionActualizar;
    private javax.swing.JTextArea txtAllegaciónActualizada;
    // End of variables declaration//GEN-END:variables
}
