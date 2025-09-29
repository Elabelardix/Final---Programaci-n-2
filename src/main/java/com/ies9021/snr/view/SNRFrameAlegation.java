package com.ies9021.snr.view;

import com.ies9021.snr.controller.AllegationController;

public class SNRFrameAlegation extends javax.swing.JFrame {
private AllegationController controller;
    public SNRFrameAlegation() {
        controller = new AllegationController(); // Inicializar controller
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCrearAlegationFrame = new javax.swing.JButton();
        btnListarAlegacionesFrame = new javax.swing.JButton();
        btnActualizarAlegationFrame = new javax.swing.JButton();
        btnBorrarAlegationFrame = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFinalizarPrograma = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCrearAlegationFrame.setFont(new java.awt.Font("Segoe UI Emoji", 2, 24)); // NOI18N
        btnCrearAlegationFrame.setText("Crear alegación");
        btnCrearAlegationFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnCrearAlegationFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlegationFrameActionPerformed(evt);
            }
        });

        btnListarAlegacionesFrame.setFont(new java.awt.Font("Segoe UI Emoji", 2, 24)); // NOI18N
        btnListarAlegacionesFrame.setText("Lista de alegaciones");
        btnListarAlegacionesFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnListarAlegacionesFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlegacionesFrameActionPerformed(evt);
            }
        });

        btnActualizarAlegationFrame.setFont(new java.awt.Font("Segoe UI Emoji", 2, 24)); // NOI18N
        btnActualizarAlegationFrame.setText("Actualizar alegación");
        btnActualizarAlegationFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnActualizarAlegationFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAlegationFrameActionPerformed(evt);
            }
        });

        btnBorrarAlegationFrame.setFont(new java.awt.Font("Segoe UI Emoji", 2, 24)); // NOI18N
        btnBorrarAlegationFrame.setText("Borrar alegación");
        btnBorrarAlegationFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBorrarAlegationFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAlegationFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListarAlegacionesFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnCrearAlegationFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarAlegationFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarAlegationFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnCrearAlegationFrame)
                .addGap(60, 60, 60)
                .addComponent(btnListarAlegacionesFrame)
                .addGap(71, 71, 71)
                .addComponent(btnActualizarAlegationFrame)
                .addGap(65, 65, 65)
                .addComponent(btnBorrarAlegationFrame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        jLabel1.setText("SNR - Allegations");

        btnFinalizarPrograma.setFont(new java.awt.Font("Segoe UI Emoji", 2, 18)); // NOI18N
        btnFinalizarPrograma.setText("Finalizar");
        btnFinalizarPrograma.setActionCommand("Salir");
        btnFinalizarPrograma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnFinalizarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarProgramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarPrograma)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setMaximumSize(new java.awt.Dimension(300, 300));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarProgramaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFinalizarProgramaActionPerformed

    private void btnCrearAlegationFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlegationFrameActionPerformed
        SNRCrearAlegation pantalla = new SNRCrearAlegation();
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }//GEN-LAST:event_btnCrearAlegationFrameActionPerformed

    private void btnListarAlegacionesFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlegacionesFrameActionPerformed
    ListarAlegaciones pantalla = new ListarAlegaciones(controller); // ✔ pasar controller
    pantalla.setVisible(true);
    pantalla.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnListarAlegacionesFrameActionPerformed

    private void btnActualizarAlegationFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAlegationFrameActionPerformed
        ActualizarAlegation pantalla = new ActualizarAlegation();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnActualizarAlegationFrameActionPerformed

    private void btnBorrarAlegationFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAlegationFrameActionPerformed
        BorrarAlegation pantalla = new BorrarAlegation();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBorrarAlegationFrameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarAlegationFrame;
    private javax.swing.JButton btnBorrarAlegationFrame;
    private javax.swing.JButton btnCrearAlegationFrame;
    private javax.swing.JButton btnFinalizarPrograma;
    private javax.swing.JButton btnListarAlegacionesFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
    
}
