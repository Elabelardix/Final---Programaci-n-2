package com.ies9021.snr.model;

import java.util.Date;

public class Allegation {
    private int idAllegation;
    private String reason;
    private String informer;
    private String category;
    private String denounced;
    private String specifications;
    private int idUserCreate;
    private int idUserUpdate;
    private int idCategory;
    private int idEntity;
    private Date dateCreate;
    private Date dateUpdate;

    public Allegation() {}

    public Allegation(int idAllegation, String reason, String informer, String category,
                      String denounced, String specifications,
                      int idUserCreate, int idUserUpdate,
                      int idCategory, int idEntity,
                      Date dateCreate, Date dateUpdate) {
        this.idAllegation = idAllegation;
        this.reason = reason;
        this.informer = informer;
        this.category = category;
        this.denounced = denounced;
        this.specifications = specifications;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.idCategory = idCategory;
        this.idEntity = idEntity;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    // Getters y setters
    public int getIdAllegation() { return idAllegation; }
    public void setIdAllegation(int idAllegation) { this.idAllegation = idAllegation; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getInformer() { return informer; }
    public void setInformer(String informer) { this.informer = informer; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDenounced() { return denounced; }
    public void setDenounced(String denounced) { this.denounced = denounced; }
    public String getSpecifications() { return specifications; }
    public void setSpecifications(String specifications) { this.specifications = specifications; }
    public int getIdUserCreate() { return idUserCreate; }
    public void setIdUserCreate(int idUserCreate) { this.idUserCreate = idUserCreate; }
    public int getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(int idUserUpdate) { this.idUserUpdate = idUserUpdate; }
    public int getIdCategory() { return idCategory; }
    public void setIdCategory(int idCategory) { this.idCategory = idCategory; }
    public int getIdEntity() { return idEntity; }
    public void setIdEntity(int idEntity) { this.idEntity = idEntity; }
    public Date getDateCreate() { return dateCreate; }
    public void setDateCreate(Date dateCreate) { this.dateCreate = dateCreate; }
    public Date getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(Date dateUpdate) { this.dateUpdate = dateUpdate; }
}