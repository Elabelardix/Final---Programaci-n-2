package com.ies9021.snr;

import java.time.LocalDateTime;

public class Allegation {

    private int idAllegation;
    private int idUserCreate;
    private int idUserUpdate;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private int idCategory;
    private int idUser;
    private int idEntity;
    private int idClaim;
    private String description;
    private String status;
    private String proofUrl; // 🔹 NUEVO: URL de prueba

    // Constructor vacío
    public Allegation() {
    }

    // Constructor completo
    public Allegation(int idAllegation, int idUserCreate, int idUserUpdate,
                      LocalDateTime dateCreate, LocalDateTime dateUpdate,
                      int idCategory, int idUser, int idEntity, int idClaim,
                      String description, String status, String proofUrl) { // 🔹 proofUrl agregado
        this.idAllegation = idAllegation;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.idCategory = idCategory;
        this.idUser = idUser;
        this.idEntity = idEntity;
        this.idClaim = idClaim;
        this.description = description;
        this.status = status;
        this.proofUrl = proofUrl; // 🔹 asignar
    }

    // Getters y Setters
    public int getIdAllegation() { return idAllegation; }
    public void setIdAllegation(int idAllegation) { this.idAllegation = idAllegation; }

    public int getIdUserCreate() { return idUserCreate; }
    public void setIdUserCreate(int idUserCreate) { this.idUserCreate = idUserCreate; }

    public int getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(int idUserUpdate) { this.idUserUpdate = idUserUpdate; }

    public LocalDateTime getDateCreate() { return dateCreate; }
    public void setDateCreate(LocalDateTime dateCreate) { this.dateCreate = dateCreate; }

    public LocalDateTime getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(LocalDateTime dateUpdate) { this.dateUpdate = dateUpdate; }

    public int getIdCategory() { return idCategory; }
    public void setIdCategory(int idCategory) { this.idCategory = idCategory; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdEntity() { return idEntity; }
    public void setIdEntity(int idEntity) { this.idEntity = idEntity; }

    public int getIdClaim() { return idClaim; }
    public void setIdClaim(int idClaim) { this.idClaim = idClaim; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getProofUrl() { return proofUrl; } // 🔹 getter
    public void setProofUrl(String proofUrl) { this.proofUrl = proofUrl; } // 🔹 setter

    @Override
    public String toString() {
        return "Allegation{" +
                "idAllegation=" + idAllegation +
                ", idUserCreate=" + idUserCreate +
                ", idUserUpdate=" + idUserUpdate +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                ", idCategory=" + idCategory +
                ", idUser=" + idUser +
                ", idEntity=" + idEntity +
                ", idClaim=" + idClaim +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", proofUrl='" + proofUrl + '\'' + // 🔹 mostrar en toString
                '}';
    }
}