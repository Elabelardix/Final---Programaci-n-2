package com.ies9021.snr.view;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;
import com.ies9021.snr.UserAllegation;

import javax.swing.*;
import java.util.List;
import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CreaAlegacion extends javax.swing.JFrame {

    private AllegationController controller;
    private Allegation currentAllegation;
    private List<AllegationController.EntityItem> entities;
    private List<AllegationController.ClaimItem> claims;
    private UserAllegation usuarioLogueado;

    // Constructor para crear con usuario logueado
    public CreaAlegacion(AllegationController controller, UserAllegation usuarioLogueado) {
        this.controller = controller;
        this.usuarioLogueado = usuarioLogueado;
        this.currentAllegation = null;
        initComponents();
        cargarCombos();
        setLocationRelativeTo(null);
    }

    // 🔹 Constructor para crear una nueva alegación
    public CreaAlegacion(AllegationController controller) {
        this.controller = controller;
        this.currentAllegation = null;
        initComponents();
        cargarCombos();
        setLocationRelativeTo(null);
    }

    // 🔹 Constructor para editar una alegación existente
    private javax.swing.JLabel lblPreview;

    public CreaAlegacion(AllegationController controller, Allegation a) {
        this.controller = controller;
        this.currentAllegation = a;
        initComponents();
        cargarCombos();

        lblPreview = new javax.swing.JLabel();
        lblPreview.setBounds(520, 250, 150, 150);
        lblPreview.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
        lblPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreview.setText("Sin imagen");
        jPanel1.add(lblPreview);

        if (a != null) {
            cargarAlegacion(a);
            if (a.getProofUrl() != null && !a.getProofUrl().isEmpty()) {
                try {
                    ImageIcon icono = new ImageIcon(a.getProofUrl());
                    Image imagenEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    lblPreview.setIcon(new ImageIcon(imagenEscalada));
                    lblPreview.setText(null);
                } catch (Exception e) {
                }
            }
        }
        setLocationRelativeTo(null);
    }

    // Cargar combos desde el controller
    private void cargarCombos() {
        try {
            entities = controller.getAllEntityItems();
            DefaultComboBoxModel<String> modelEntity = new DefaultComboBoxModel<>();
            for (AllegationController.EntityItem e : entities) {
                modelEntity.addElement(e.getName());
            }
            cbEntidad.setModel(modelEntity);

            claims = controller.getAllClaimItems();
            DefaultComboBoxModel<String> modelClaim = new DefaultComboBoxModel<>();
            for (AllegationController.ClaimItem c : claims) {
                modelClaim.addElement(c.getName());
            }
            cbReclamoPendiente.setModel(modelClaim);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los combos");
        }
    }

    // Cargar los datos de una alegación existente
    public void cargarAlegacion(Allegation a) {
        this.currentAllegation = a;
        txtAlegación.setText(a.getDescription());
        txtPruebaConURL.setText(a.getProofUrl()); // 🔹 usar proofUrl

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId() == a.getIdEntity()) {
                cbEntidad.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId() == a.getIdClaim()) {
                cbReclamoPendiente.setSelectedIndex(i);
                break;
            }
        }
    }

    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            txtPruebaConURL.setText(selectedFile.getAbsolutePath());
        }
    }

    private int getSelectedEntityId() {
        int index = cbEntidad.getSelectedIndex();
        return index >= 0 ? entities.get(index).getId() : -1;
    }

    private int getSelectedClaimId() {
        int index = cbReclamoPendiente.getSelectedIndex();
        return index >= 0 ? claims.get(index).getId() : -1;
    }

    private String getAlegacionDescription() {
        return txtAlegación.getText();
    }

    private String getPruebaURL() {
        return txtPruebaConURL.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbEntidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbReclamoPendiente = new javax.swing.JComboBox<>();
        txtAlegación = new javax.swing.JTextField();
        btnVolver = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        txtPruebaConURL = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JToggleButton();
        btnSeleccionarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cargar Alegación");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Entidad");

        cbEntidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEntidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Reclamo Pendiente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Alegación");

        cbReclamoPendiente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReclamoPendiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbReclamoPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReclamoPendienteActionPerformed(evt);
            }
        });

        txtAlegación.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAlegación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlegaciónActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Prueba");

        txtPruebaConURL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPruebaConURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPruebaConURLActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setText("Cargar Alegación");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSeleccionarImagen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSeleccionarImagen.setText("Cargar Imagen");
        btnSeleccionarImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41)
                                .addComponent(txtPruebaConURL, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSeleccionarImagen)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(cbEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbReclamoPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAlegación, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(182, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbReclamoPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlegación, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPruebaConURL, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntidadActionPerformed

    }//GEN-LAST:event_cbEntidadActionPerformed

    private void cbReclamoPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReclamoPendienteActionPerformed

    }//GEN-LAST:event_cbReclamoPendienteActionPerformed

    private void txtAlegaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlegaciónActionPerformed

    }//GEN-LAST:event_txtAlegaciónActionPerformed

    private void txtPruebaConURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPruebaConURLActionPerformed

    }//GEN-LAST:event_txtPruebaConURLActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            int IDentity = getSelectedEntityId();
            int claimId = getSelectedClaimId();
            String description = getAlegacionDescription();
            String prueba = getPruebaURL();

            if (description.isEmpty() || prueba.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            int idUser = usuarioLogueado != null ? usuarioLogueado.getIdUser() : 1;
            int idCategory = 1;

            if (currentAllegation == null) {
                controller.createAllegation(idUser, IDentity, claimId, idCategory, description, prueba);
                JOptionPane.showMessageDialog(this, "Alegación creada con éxito.");
            } else {
                controller.updateAllegation(
                        currentAllegation.getIdAllegation(),
                        idUser,
                        description,
                        "Pendiente",
                        prueba
                );
                JOptionPane.showMessageDialog(this, "Alegación actualizada con éxito.");
            }

            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la alegación.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));

        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            txtPruebaConURL.setText(archivoSeleccionado.getAbsolutePath());
            try {
                ImageIcon icono = new ImageIcon(archivoSeleccionado.getAbsolutePath());
                Image imagenEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                lblPreview.setIcon(new ImageIcon(imagenEscalada));
                lblPreview.setText(null);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnGuardar;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JToggleButton btnVolver;
    private javax.swing.JComboBox<String> cbEntidad;
    private javax.swing.JComboBox<String> cbReclamoPendiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAlegación;
    private javax.swing.JTextField txtPruebaConURL;
    // End of variables declaration//GEN-END:variables
}
