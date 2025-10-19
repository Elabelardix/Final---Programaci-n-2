package com.ies9021.snr;

import com.ies9021.snr.config.DbConnection;
import com.ies9021.snr.dao.AllegationDAO;
import com.ies9021.snr.controller.AllegationController;
import com.ies9021.snr.view.Menu;

import javax.swing.*;
import java.sql.Connection;

public class SNR {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Connection conn = DbConnection.getConnection();
                if (conn == null) {
                    JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
                    return;
                }
                AllegationDAO dao = new AllegationDAO(conn);
                AllegationController controller = new AllegationController(dao);
                Menu frame = new Menu(controller);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage());
            }
        });
    }
}