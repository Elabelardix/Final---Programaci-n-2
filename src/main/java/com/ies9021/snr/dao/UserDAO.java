package com.ies9021.snr.dao;

import com.ies9021.snr.UserAllegation;
import java.sql.*;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    // Nuevo método para buscar por nombre y apellido
    public UserAllegation findByNameAndLastName(String name, String lastName) throws SQLException {
        String sql = "SELECT * FROM users WHERE name = ? AND last_name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name.trim());
            ps.setString(2, lastName.trim());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserAllegation user = new UserAllegation();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setName(rs.getString("name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setPassword(rs.getString("password"));
                    return user;
                } else {
                    return null;
                }
            }
        }
    }
}
