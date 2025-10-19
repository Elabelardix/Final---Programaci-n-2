package com.ies9021.snr.controller;

import com.ies9021.snr.dao.AllegationDAO;
import com.ies9021.snr.Allegation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import com.ies9021.snr.UserAllegation;
import com.ies9021.snr.dao.UserDAO;
import java.sql.Connection;

public class AllegationController {

    private final AllegationDAO dao;

    public AllegationController(AllegationDAO dao) {
        this.dao = dao;
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
        a.setProofUrl(proofUrl);
        a.setStatus("Pendiente");

        dao.create(a);
    }

    public void updateAllegation(int idAllegation, int idUserUpdate,
            String description, String status, String proofUrl) throws SQLException {

        Allegation a = dao.readById(idAllegation);

        if (a != null) {
            a.setIdUserUpdate(idUserUpdate);
            a.setDateUpdate(LocalDateTime.now());
            a.setDescription(description);
            a.setStatus(status);
            a.setProofUrl(proofUrl); // 🔹 asignamos la URL
            dao.update(a);
        } else {
            System.err.println("No se encontró la alegación con ID: " + idAllegation);
        }
    }

    public class UserController {

        private final UserDAO userDAO;

        public UserController(Connection conn) {
            this.userDAO = new UserDAO(conn);
        }

        public boolean login(String nombre, String apellido, String password) throws SQLException {
            UserAllegation user = userDAO.findByNameAndLastName(nombre, apellido);
            return user != null && user.getPassword().equals(password);
        }

        public UserAllegation getUser(String nombre, String apellido) throws SQLException {
            return userDAO.findByNameAndLastName(nombre, apellido);
        }
    }

    public List<Allegation> getAllAllegations() throws SQLException {
        return dao.readAll();
    }

    public void deleteAllegation(int id) throws SQLException {
        dao.delete(id);
    }

    public Allegation getAllegationById(int id) throws SQLException {
        return dao.readById(id);
    }

    // 🔹 Clases internas para ComboBox
    public static class EntityItem {

        private int id;
        private String name;

        public EntityItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class ClaimItem {

        private int id;
        private String name;

        public ClaimItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    // 🔹 Traer todas las entidades
    public List<EntityItem> getAllEntityItems() throws SQLException {
        return dao.readAllEntities();
    }

    // 🔹 NUEVO: Traer todos los reclamos
    public List<ClaimItem> getAllClaimItems() throws SQLException {
        return dao.readAllClaims();
    }
}
