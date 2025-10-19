package com.ies9021.snr.dao;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.controller.AllegationController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class AllegationDAO {

    private Connection conn;

    public AllegationDAO(Connection conn) {
        this.conn = conn;
    }

    public void createAllegation(int idUserCreate, int idEntity, int idClaim,
            int idCategory, String description, String proofUrl) throws SQLException {

        Allegation a = new Allegation();
        a.setIdUserCreate(idUserCreate);
        a.setIdUserUpdate(idUserCreate);
        a.setIdUser(idUserCreate);
        a.setDateCreate(LocalDateTime.now());
        a.setDateUpdate(LocalDateTime.now());
        a.setIdEntity(idEntity);
        a.setIdClaim(idClaim);
        a.setIdCategory(idCategory);
        a.setDescription(description);
        a.setStatus("Pendiente");
        a.setProofUrl(proofUrl != null ? proofUrl.trim() : null);

        create(a);
    }

    public void create(Allegation a) throws SQLException {
        String sql = "INSERT INTO allegation (id_user_create, id_user_update, date_create, date_update, "
                + "id_category, id_user, id_entity, id_claim, description, status, proof_url) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, a.getIdUserCreate());
        ps.setInt(2, a.getIdUserUpdate());
        ps.setTimestamp(3, Timestamp.valueOf(a.getDateCreate()));
        ps.setTimestamp(4, Timestamp.valueOf(a.getDateUpdate()));
        ps.setInt(5, a.getIdCategory());
        ps.setInt(6, a.getIdUser());
        ps.setInt(7, a.getIdEntity());
        ps.setInt(8, a.getIdClaim());
        ps.setString(9, a.getDescription());
        ps.setString(10, a.getStatus());
        ps.setString(11, a.getProofUrl());
        ps.executeUpdate();
    }

    public List<Allegation> readAll() throws SQLException {
        List<Allegation> list = new ArrayList<>();
        String sql = "SELECT * FROM allegation";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Allegation a = new Allegation(
                    rs.getInt("id_allegation"),
                    rs.getInt("id_user_create"),
                    rs.getInt("id_user_update"),
                    rs.getTimestamp("date_create").toLocalDateTime(),
                    rs.getTimestamp("date_update").toLocalDateTime(),
                    rs.getInt("id_category"),
                    rs.getInt("id_user"),
                    rs.getInt("id_entity"),
                    rs.getInt("id_claim"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("proof_url") // 🔹 proof_url
            );
            list.add(a);
        }
        return list;
    }

    public Allegation readById(int id) throws SQLException {
        String sql = "SELECT * FROM allegation WHERE id_allegation=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Allegation(
                    rs.getInt("id_allegation"),
                    rs.getInt("id_user_create"),
                    rs.getInt("id_user_update"),
                    rs.getTimestamp("date_create").toLocalDateTime(),
                    rs.getTimestamp("date_update").toLocalDateTime(),
                    rs.getInt("id_category"),
                    rs.getInt("id_user"),
                    rs.getInt("id_entity"),
                    rs.getInt("id_claim"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("proof_url") // 🔹 proof_url
            );
        }
        return null;
    }

    public void update(Allegation a) throws SQLException {
        String sql = "UPDATE allegation SET id_user_update=?, date_update=?, id_category=?, id_user=?, "
                + "id_entity=?, id_claim=?, description=?, status=?, proof_url=? WHERE id_allegation=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, a.getIdUserUpdate());
        ps.setTimestamp(2, Timestamp.valueOf(a.getDateUpdate()));
        ps.setInt(3, a.getIdCategory());
        ps.setInt(4, a.getIdUser());
        ps.setInt(5, a.getIdEntity());
        ps.setInt(6, a.getIdClaim());
        ps.setString(7, a.getDescription());
        ps.setString(8, a.getStatus());
        ps.setString(9, a.getProofUrl()); // 🔹 proof_url
        ps.setInt(10, a.getIdAllegation());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM allegation WHERE id_allegation=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<AllegationController.EntityItem> readAllEntities() throws SQLException {
        List<AllegationController.EntityItem> entities = new ArrayList<>();
        String sql = "SELECT id_entity, entity_name FROM entity"; // tabla de entidades
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            entities.add(new AllegationController.EntityItem(
                    rs.getInt("id_entity"),
                    rs.getString("entity_name")
            ));
        }
        return entities;
    }

    public List<AllegationController.ClaimItem> readAllClaims() throws SQLException {
        List<AllegationController.ClaimItem> claims = new ArrayList<>();
        String sql = "SELECT id_claim, title FROM claim";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            claims.add(new AllegationController.ClaimItem(
                    rs.getInt("id_claim"),
                    rs.getString("title")
            ));
        }
        return claims;
    }
}