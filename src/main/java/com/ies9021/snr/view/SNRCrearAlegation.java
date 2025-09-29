package com.ies9021.snr.view;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;
import com.ies9021.snr.config.DbConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SNRCrearAlegation extends JFrame {

    private AllegationController controller;

    public SNRCrearAlegation() {
        initComponents();
        controller = new AllegationController();
        cargarClaims();
        cargarEntidades();
    }

    private void cargarClaims() {
        cbCargarReclamo.removeAllItems();
        String sql = "SELECT id_claim, description FROM claim";

        try (Connection conn = DbConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int idClaim = rs.getInt("id_claim");
                String desc = rs.getString("description");
                cbCargarReclamo.addItem(idClaim + " - " + desc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "⚠️ Error al cargar reclamos: " + e.getMessage());
        }
    }

    private void cargarEntidades() {
        cbEntidadDenunciada.removeAllItems();
        for (String entidad : controller.listarEntidades()) {
            cbEntidadDenunciada.addItem(entidad);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAllegación = new javax.swing.JTextArea();
        btnCargar = new javax.swing.JButton();
        btnCancelarAlegacion = new javax.swing.JButton();
        cbCargarReclamo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cbEntidadDenunciada = new javax.swing.JComboBox<>();
        cbCategoríaAllegación = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel1.setText("Reclamo pendiente");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel2.setText("Allegación");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel3.setText("Entidad Denunciada");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel4.setText("Categoría");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAllegación.setColumns(20);
        txtAllegación.setRows(5);
        jScrollPane2.setViewportView(txtAllegación);

        btnCargar.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        btnCargar.setText("Cargar Alegation");
        btnCargar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnCancelarAlegacion.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        btnCancelarAlegacion.setText("Cancelar");
        btnCancelarAlegacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnCancelarAlegacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlegacionActionPerformed(evt);
            }
        });

        cbCargarReclamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargarReclamoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jButton1.setText("Finalizar");
        jButton1.setActionCommand("Salir");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbEntidadDenunciada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntidadDenunciadaActionPerformed(evt);
            }
        });

        cbCategoríaAllegación.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Error en el servicio", "Retraso en la entrega", "Producto defectuoso", "Cobro indebido", "Atención al cliente inadecuada", "Documentación incompleta", "Duplicado de reclamo", "Fraude o intento de fraude", "Otro" }));
        cbCategoríaAllegación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoríaAllegaciónActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarAlegacion)
                        .addGap(58, 58, 58)
                        .addComponent(btnCargar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbCategoríaAllegación, javax.swing.GroupLayout.Alignment.LEADING, 0, 300, Short.MAX_VALUE)
                            .addComponent(cbEntidadDenunciada, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbCargarReclamo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cbCargarReclamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cbEntidadDenunciada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(cbCategoríaAllegación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarAlegacion)
                    .addComponent(btnCargar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        try {
            Allegation alle = new Allegation();

            String claimSel = cbCargarReclamo.getSelectedItem().toString();
            alle.setIdClaim(Integer.parseInt(claimSel.split(" - ")[0]));

            String entidadSel = cbEntidadDenunciada.getSelectedItem().toString();
            alle.setIdEntity(Integer.parseInt(entidadSel.split(" - ")[0]));

            int categoriaId = cbCategoríaAllegación.getSelectedIndex() + 1;
            alle.setIdCategory(categoriaId);

            alle.setIdUser(3);
            alle.setIdUserCreate(3);
            alle.setIdUserUpdate(3);

            if (controller.crearAlegacion(alle)) {
                JOptionPane.showMessageDialog(this, "✅ La alegación fue cargada con éxito");
                this.dispose();
                new SNRFrameAlegation().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Error al cargar la alegación");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "⚠️ Error inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnCancelarAlegacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlegacionActionPerformed
        this.dispose();
        new SNRFrameAlegation().setVisible(true);
    }//GEN-LAST:event_btnCancelarAlegacionActionPerformed

    private void cbCargarReclamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargarReclamoActionPerformed
        if (cbEntidadDenunciada.getSelectedItem() != null) {
            System.out.println("Entidad seleccionada: " + cbEntidadDenunciada.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbCargarReclamoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbEntidadDenunciadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntidadDenunciadaActionPerformed
        cbEntidadDenunciada.removeAllItems();
        for (String entidad : controller.listarEntidades()) {
            cbEntidadDenunciada.addItem(entidad);
        }
    }//GEN-LAST:event_cbEntidadDenunciadaActionPerformed

    private void cbCategoríaAllegaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoríaAllegaciónActionPerformed
        if (cbCategoríaAllegación.getSelectedItem() != null) {
            String categoria = cbCategoríaAllegación.getSelectedItem().toString();
            System.out.println(categoria);
        }
    }//GEN-LAST:event_cbCategoríaAllegaciónActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarAlegacion;
    private javax.swing.JButton btnCargar;
    private javax.swing.JComboBox<String> cbCargarReclamo;
    private javax.swing.JComboBox<String> cbCategoríaAllegación;
    private javax.swing.JComboBox<String> cbEntidadDenunciada;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAllegación;
    // End of variables declaration//GEN-END:variables
}
