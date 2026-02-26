package com.ies9021.snr.view;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ies9021.snr.UserAllegation;
import com.ies9021.snr.view.IniciarSesion;
import com.ies9021.snr.view.CreaAlegacion;

public class Menu extends JFrame {

    private AllegationController controller;

    public Menu(AllegationController controller) {
        this.controller = controller;
        initComponents();
        setLocationRelativeTo(null);
        cargarFiltroEntidades();
        refrescarTabla();
    }

    public void refrescarTabla() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbListaAlegaciones.getModel();
            model.setRowCount(0);

            List<Allegation> lista = controller.getAllAllegations();

            Map<Integer, String> mapaEntidades = new HashMap<>();
            for (AllegationController.EntityItem e : controller.getAllEntityItems()) {
                mapaEntidades.put(e.getId(), e.getName());
            }

            Map<Integer, String> mapaClaims = new HashMap<>();
            List<AllegationController.ClaimItem> claims = controller.getAllClaimItems();
            if (claims != null) {
                for (AllegationController.ClaimItem c : claims) {
                    mapaClaims.put(c.getId(), c.getName());
                }
            }

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");

            for (Allegation a : lista) {
                model.addRow(new Object[]{
                    a.getIdAllegation(),
                    a.getIdUser(),
                    mapaEntidades.getOrDefault(a.getIdEntity(), "Entidad " + a.getIdEntity()),
                    mapaClaims.getOrDefault(a.getIdClaim(), "Reclamo " + a.getIdClaim()),
                    a.getDescription(),
                    a.getDateCreate().format(df),
                    a.getDateCreate().format(tf),
                    a.getProofUrl(),
                    a.getStatus()
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla");
        }
    }

    private void cargarFiltroEntidades() {
        try {
            List<AllegationController.EntityItem> entities = controller.getAllEntityItems();
            cbFiltroEntidades.removeAllItems();
            cbFiltroEntidades.addItem("Todas");
            for (AllegationController.EntityItem e : entities) {
                cbFiltroEntidades.addItem(e.getName());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar entidades");
        }
    }

    private void filtrarTablaPorEntidad(String selected) {
        if (selected == null) {
            return;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) tbListaAlegaciones.getModel();
            model.setRowCount(0);

            List<Allegation> lista = controller.getAllAllegations();

            Map<Integer, String> mapaEntidades = new HashMap<>();
            for (AllegationController.EntityItem e : controller.getAllEntityItems()) {
                mapaEntidades.put(e.getId(), e.getName());
            }

            Map<Integer, String> mapaClaims = new HashMap<>();
            List<AllegationController.ClaimItem> claims = controller.getAllClaimItems();
            if (claims != null) {
                for (AllegationController.ClaimItem c : claims) {
                    mapaClaims.put(c.getId(), c.getName());
                }
            }

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");

            for (Allegation a : lista) {
                String entidadNombre = mapaEntidades.getOrDefault(a.getIdEntity(), "Entidad " + a.getIdEntity());
                if (selected.equals("Todas") || entidadNombre.equals(selected)) {
                    model.addRow(new Object[]{
                        a.getIdAllegation(),
                        a.getIdUser(),
                        entidadNombre,
                        mapaClaims.getOrDefault(a.getIdClaim(), "Reclamo " + a.getIdClaim()),
                        a.getDescription(),
                        a.getDateCreate().format(df),
                        a.getDateCreate().format(tf),
                        a.getProofUrl(),
                        a.getStatus()
                    });
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrearAlegación = new javax.swing.JToggleButton();
        btnCerrarAplicación = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaAlegaciones = new javax.swing.JTable();
        btnEditarAlegación = new javax.swing.JToggleButton();
        cbFiltroEntidades = new javax.swing.JComboBox<>();
        btnRefrescarTabla = new javax.swing.JToggleButton();
        btnBorrarAlegacion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Alegaciones");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCrearAlegación.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearAlegación.setText("Presentar Alegación");
        btnCrearAlegación.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnCrearAlegación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlegaciónActionPerformed(evt);
            }
        });

        btnCerrarAplicación.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarAplicación.setText("Finalizar");
        btnCerrarAplicación.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnCerrarAplicación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarAplicaciónActionPerformed(evt);
            }
        });

        tbListaAlegaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID_usuario", "Entidad Alegando", "Reclamo Pendiente", "Alegación", "Fecha", "Hora", "Prueba URL", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tbListaAlegaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnEditarAlegación.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditarAlegación.setText("Editar Alegación");
        btnEditarAlegación.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEditarAlegación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlegaciónActionPerformed(evt);
            }
        });

        cbFiltroEntidades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbFiltroEntidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroEntidadesActionPerformed(evt);
            }
        });

        btnRefrescarTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRefrescarTabla.setText("Actualizar Tabla");
        btnRefrescarTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarTablaActionPerformed(evt);
            }
        });

        btnBorrarAlegacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBorrarAlegacion.setText("Borrar Alegación");
        btnBorrarAlegacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBorrarAlegacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAlegacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(189, 189, 189)
                                .addComponent(btnCerrarAplicación, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrearAlegación, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addComponent(btnEditarAlegación, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(btnBorrarAlegacion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cbFiltroEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefrescarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnCerrarAplicación))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearAlegación, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarAlegación, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarAlegacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltroEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescarTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearAlegaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlegaciónActionPerformed
        IniciarSesion login = new IniciarSesion(controller);
        login.setVisible(true);

        UserAllegation usuarioLogueado = login.getUsuarioLogueado();
        if (usuarioLogueado == null) {
            JOptionPane.showMessageDialog(this, "Debes iniciar sesión para crear una alegación.");
            return;
        }

        CreaAlegacion crea = new CreaAlegacion(controller, usuarioLogueado);
        crea.setVisible(true);
    }//GEN-LAST:event_btnCrearAlegaciónActionPerformed

    private void btnEditarAlegaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAlegaciónActionPerformed
        int fila = tbListaAlegaciones.getSelectedRow();
        if (fila >= 0) {
            int id = (int) tbListaAlegaciones.getValueAt(fila, 0);
            try {
                Allegation a = controller.getAllegationById(id);
                IniciarSesion1 login = new IniciarSesion1(controller, a);
                login.setVisible(true);

                UserAllegation usuarioLogueado = login.getUsuarioLogueado();
                if (usuarioLogueado == null) {
                    JOptionPane.showMessageDialog(this, "Debes iniciar sesión para crear una alegación.");
                    return;
                }
                if (a != null) {
                    CreaAlegacion editar = new CreaAlegacion(controller, a);
                    editar.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al abrir el formulario de edición.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar");
        }
    }//GEN-LAST:event_btnEditarAlegaciónActionPerformed

    private void btnCerrarAplicaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarAplicaciónActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarAplicaciónActionPerformed

    private void cbFiltroEntidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroEntidadesActionPerformed
        Object selected = cbFiltroEntidades.getSelectedItem();
        if (selected != null)
            filtrarTablaPorEntidad(selected.toString());
    }//GEN-LAST:event_cbFiltroEntidadesActionPerformed

    private void btnRefrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarTablaActionPerformed
        refrescarTabla();
    }//GEN-LAST:event_btnRefrescarTablaActionPerformed

    private void btnBorrarAlegacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAlegacionActionPerformed
        int fila = tbListaAlegaciones.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una alegación para borrar.");
            return;
        }

        int idAlegacion = (int) tbListaAlegaciones.getValueAt(fila, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea eliminar la alegación con ID " + idAlegacion + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            controller.deleteAllegation(idAlegacion);

            refrescarTabla();

            JOptionPane.showMessageDialog(this, "Alegación eliminada correctamente.");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar la alegación.");
        }
    }//GEN-LAST:event_btnBorrarAlegacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBorrarAlegacion;
    private javax.swing.JToggleButton btnCerrarAplicación;
    private javax.swing.JToggleButton btnCrearAlegación;
    private javax.swing.JToggleButton btnEditarAlegación;
    private javax.swing.JToggleButton btnRefrescarTabla;
    private javax.swing.JComboBox<String> cbFiltroEntidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListaAlegaciones;
    // End of variables declaration//GEN-END:variables
}