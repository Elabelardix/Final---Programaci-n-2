package com.ies9021.snr.dao;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.dto.AllegationDTO;
import com.ies9021.snr.config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllegationDAO {

    // Crear una nueva alegación
    public boolean crearAlegacion(Allegation a) {
        String sql = "INSERT INTO allegation "
                + "(id_user_create, id_user_update, id_category, id_user, id_entity, id_claim, date_create, date_update) "
                + "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, a.getIdUserCreate());
            ps.setInt(2, a.getIdUserUpdate());
            ps.setInt(3, a.getIdCategory());
            ps.setInt(4, a.getIdUser());
            ps.setInt(5, a.getIdEntity());
            ps.setInt(6, a.getIdClaim());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todas las alegaciones (entidad Allegation)
    public List<Allegation> listarAlegaciones() {
        List<Allegation> lista = new ArrayList<>();
        String sql = "SELECT * FROM allegation";
        try (Connection conn = DbConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Allegation a = new Allegation();
                a.setIdAllegation(rs.getInt("id_allegation"));
                a.setIdUserCreate(rs.getInt("id_user_create"));
                a.setIdUserUpdate(rs.getInt("id_user_update"));
                a.setDateCreate(rs.getString("date_create"));
                a.setDateUpdate(rs.getString("date_update"));
                a.setIdCategory(rs.getInt("id_category"));
                a.setIdUser(rs.getInt("id_user"));
                a.setIdEntity(rs.getInt("id_entity"));
                a.setIdClaim(rs.getInt("id_claim"));
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Listar alegaciones como DTO (4 campos)
    public List<AllegationDTO> listarAlegacionesDTO() {
        List<AllegationDTO> lista = new ArrayList<>();
        String sql = "SELECT "
                + "a.id_allegation, "
                + "c.description AS claimDescription, "
                + "e.entity_name AS denouncedName, "
                + "cat.type_category AS categoryName "
                + "FROM allegation a "
                + "JOIN claim c ON a.id_claim = c.id_claim "
                + "JOIN entity e ON a.id_entity = e.id_entity "
                + "JOIN category cat ON a.id_category = cat.id_category";

        try (Connection conn = DbConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                AllegationDTO dto = new AllegationDTO(
                        rs.getInt("id_allegation"),
                        rs.getString("claimDescription"),
                        rs.getString("denouncedName"),
                        rs.getString("categoryName")
                );
                lista.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Listar entidades para combo box
    public List<String> listarEntidades() {
        List<String> entidades = new ArrayList<>();
        String sql = "SELECT id_entity, entity_name FROM entity";

        try (Connection conn = DbConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id_entity");
                String nombre = rs.getString("entity_name");
                entidades.add(id + " - " + nombre); // ComboBox
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entidades;
    }

    // Actualizar una alegación
    public boolean actualizarAlegacion(Allegation a) {
        String sql = "UPDATE allegation SET id_user_update=?, id_category=?, id_user=?, id_entity=?, id_claim=?, date_update=NOW() "
                + "WHERE id_allegation=?";
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, a.getIdUserUpdate());
            ps.setInt(2, a.getIdCategory());
            ps.setInt(3, a.getIdUser());
            ps.setInt(4, a.getIdEntity());
            ps.setInt(5, a.getIdClaim());
            ps.setInt(6, a.getIdAllegation());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una alegación
    public boolean eliminarAlegacion(int id) {
        String sql = "DELETE FROM allegation WHERE id_allegation=?";
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
