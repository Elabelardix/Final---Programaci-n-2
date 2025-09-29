package com.ies9021.snr;

public class Allegation {
    private int idAllegation;
    private int idUserCreate;
    private int idUserUpdate;
    private String dateCreate;
    private String dateUpdate;
    private int idCategory;
    private int idUser;
    private int idEntity;
    private int idClaim; // Relación con Claim

    // **Nuevo atributo**
    private String reason;

    // Constructor vacío
    public Allegation() {}

    // Constructor completo incluyendo reason
    public Allegation(int idAllegation, int idUserCreate, int idUserUpdate,
                      String dateCreate, String dateUpdate,
                      int idCategory, int idUser, int idEntity, int idClaim,
                      String reason) { // agregado
        this.idAllegation = idAllegation;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.idCategory = idCategory;
        this.idUser = idUser;
        this.idEntity = idEntity;
        this.idClaim = idClaim;
        this.reason = reason; // asignado
    }

    // Getters y Setters
    public int getIdAllegation() { return idAllegation; }
    public void setIdAllegation(int idAllegation) { this.idAllegation = idAllegation; }

    public int getIdUserCreate() { return idUserCreate; }
    public void setIdUserCreate(int idUserCreate) { this.idUserCreate = idUserCreate; }

    public int getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(int idUserUpdate) { this.idUserUpdate = idUserUpdate; }

    public String getDateCreate() { return dateCreate; }
    public void setDateCreate(String dateCreate) { this.dateCreate = dateCreate; }

    public String getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(String dateUpdate) { this.dateUpdate = dateUpdate; }

    public int getIdCategory() { return idCategory; }
    public void setIdCategory(int idCategory) { this.idCategory = idCategory; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdEntity() { return idEntity; }
    public void setIdEntity(int idEntity) { this.idEntity = idEntity; }

    public int getIdClaim() { return idClaim; }
    public void setIdClaim(int idClaim) { this.idClaim = idClaim; }

    // **Getter y Setter del nuevo atributo**
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    // Método resumen
    public void displaySummary() {
        System.out.println("Allegation ID: " + idAllegation);
        System.out.println("Claim ID: " + idClaim);
        System.out.println("Entity ID: " + idEntity);
        System.out.println("User ID: " + idUser);
        System.out.println("Reason: " + reason); // mostrar reason
        System.out.println("Created on: " + dateCreate);
        System.out.println("Updated on: " + dateUpdate);
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return "Allegation{" +
                "idAllegation=" + idAllegation +
                ", idUserCreate=" + idUserCreate +
                ", idUserUpdate=" + idUserUpdate +
                ", dateCreate='" + dateCreate + '\'' +
                ", dateUpdate='" + dateUpdate + '\'' +
                ", idCategory=" + idCategory +
                ", idUser=" + idUser +
                ", idEntity=" + idEntity +
                ", idClaim=" + idClaim +
                ", reason='" + reason + '\'' + // agregado
                '}';
    }
}