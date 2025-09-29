package com.ies9021.snr.view;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BorrarAlegation extends javax.swing.JFrame {

    private final AllegationController controller;
    private List<Allegation> listaAlegaciones;
    private Allegation seleccionada;

    public BorrarAlegation() {
        controller = new AllegationController();
        initComponents();  // No tocar
        configurarFrame();
        cargarInformantes();
    }

    private void configurarFrame() {
        setTitle("Borrar Alegación");
        setLocationRelativeTo(null);
    }

    private void cargarInformantes() {
        txtInformante.removeAllItems();
        listaAlegaciones = controller.listarAlegaciones();
        seleccionada = null;

        for (Allegation a : listaAlegaciones) {
            String idUsuario = String.valueOf(a.getIdUser());
            if (!comboContains(idUsuario)) {
                txtInformante.addItem(idUsuario);
            }
        }
        if (txtInformante.getItemCount() > 0) {
            txtInformante.setSelectedIndex(0);
            actualizarSeleccion();
        }
    }

    private boolean comboContains(String valor) {
        for (int i = 0; i < txtInformante.getItemCount(); i++) {
            if (txtInformante.getItemAt(i).equals(valor)) {
                return true;
            }
        }
        return false;
    }

    private void actualizarSeleccion() {
        String idUsuarioStr = (String) txtInformante.getSelectedItem();
        seleccionada = null;

        if (idUsuarioStr != null && listaAlegaciones != null) {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            for (Allegation a : listaAlegaciones) {
                if (a.getIdUser() == idUsuario) {
                    seleccionada = a; 
                    break;
                }
            }
        }
    }

    private void borrarUsuarioSeleccionado() {
        if (seleccionada != null) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea borrar todas las alegaciones de este usuario?",
                    "Confirmar borrado",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                int idUsuario = seleccionada.getIdUser();
                // Eliminamos directamente
                listaAlegaciones.stream()
                        .filter(a -> a.getIdUser() == idUsuario)
                        .forEach(a -> controller.eliminarAlegacion(a.getIdAllegation()));

                JOptionPane.showMessageDialog(this, "Usuario y sus alegaciones borradas correctamente.");
                cargarInformantes();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuario seleccionado.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtInformante = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        txtInformante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        txtInformante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformanteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 36)); // NOI18N
        jLabel1.setText("Borrar Alegación");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel2.setText("Seleccionar Alegación a borrar:");

        btnBorrar.setFont(new java.awt.Font("Segoe UI Emoji", 2, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtInformante, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInformante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBorrar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtInformanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformanteActionPerformed
        actualizarSeleccion();
    }//GEN-LAST:event_txtInformanteActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        borrarUsuarioSeleccionado();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txtInformante;
    // End of variables declaration//GEN-END:variables
}
