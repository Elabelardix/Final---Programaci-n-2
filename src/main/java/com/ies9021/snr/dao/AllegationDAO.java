package com.ies9021.snr.dao;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllegationDAO {

    public boolean crearAlegacion(Allegation a) {
        String sql = "INSERT INTO allegation "
                   + "(reason, informer, category, denounced, specifications, id_user_create, id_user_update, id_category, id_entity, date_create, date_update) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, a.getReason());
            ps.setString(2, a.getInformer());
            ps.setString(3, a.getCategory());
            ps.setString(4, a.getDenounced());
            ps.setString(5, a.getSpecifications());
            ps.setInt(6, 3);
            ps.setInt(7, 3);
            ps.setInt(8, 3);
            ps.setInt(9, 3);
            
            int filas = ps.executeUpdate();
            return filas > 0; // Devuelve true si insertó
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error al insertar
        }
    }

    public List<Allegation> listarAlegaciones() {
        List<Allegation> lista = new ArrayList<>();
        String sql = "SELECT * FROM allegation";
        try (Connection conn = DbConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
             
            while (rs.next()) {
                Allegation a = new Allegation();
                a.setIdAllegation(rs.getInt("id_allegation"));
                a.setReason(rs.getString("reason"));
                a.setInformer(rs.getString("informer"));
                a.setCategory(rs.getString("category"));
                a.setDenounced(rs.getString("denounced"));
                a.setSpecifications(rs.getString("specifications"));
                a.setIdUserCreate(rs.getInt("id_user_create"));
                a.setIdUserUpdate(rs.getInt("id_user_update"));
                a.setIdCategory(rs.getInt("id_category"));
                a.setIdEntity(rs.getInt("id_entity"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarAlegacion(Allegation a) {
        String sql = "UPDATE allegation SET reason=?, informer=?, category=?, denounced=?, specifications=?, id_user_update=?, id_category=?, id_entity=?, date_update=NOW() "
                   + "WHERE id_allegation=?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, a.getReason());
            ps.setString(2, a.getInformer());
            ps.setString(3, a.getCategory());
            ps.setString(4, a.getDenounced());
            ps.setString(5, a.getSpecifications());
            ps.setInt(6, a.getIdUserUpdate());
            ps.setInt(7, a.getIdCategory());
            ps.setInt(8, a.getIdEntity());
            ps.setInt(9, a.getIdAllegation());
            
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAlegacion(int id) {
        String sql = "DELETE FROM allegation WHERE id_allegation=?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}