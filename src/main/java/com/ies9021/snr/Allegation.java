package com.ies9021.snr;

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

    public Allegation() {
    }

    public Allegation(int idAllegation, String reason, String informer, String category,
                      String denounced, String specifications,
                      int idUserCreate, int idUserUpdate,
                      int idCategory, int idEntity) {
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
    }

    public int getIdAllegation() {
        return idAllegation;
    }

    public void setIdAllegation(int idAllegation) {
        this.idAllegation = idAllegation;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getInformer() {
        return informer;
    }

    public void setInformer(String informer) {
        this.informer = informer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDenounced() {
        return denounced;
    }

    public void setDenounced(String denounced) {
        this.denounced = denounced;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public int getIdUserCreate() {
        return idUserCreate;
    }

    public void setIdUserCreate(int idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public int getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(int idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(int idEntity) {
        this.idEntity = idEntity;
    }

    public void updateReason(String newReason) {
        if (newReason != null && !newReason.isEmpty()) {
            this.reason = newReason;
        }
    }

    public void updateSpecifications(String newSpecs) {
        if (newSpecs != null && !newSpecs.isEmpty()) {
            this.specifications = newSpecs;
        }
    }

    public void updateDenounced(String newDenounced) {
        if (newDenounced != null && !newDenounced.isEmpty()) {
            this.denounced = newDenounced;
        }
    }

    public void displaySummary() {
        System.out.println("Allegation ID: " + idAllegation);
        System.out.println("Reason: " + reason);
        System.out.println("Informer: " + informer);
        System.out.println("Denounced: " + denounced);
        System.out.println("Category: " + category);
        System.out.println("Entity ID: " + idEntity);
        System.out.println("-----------------------------");
    }

    public boolean isValid() {
        return reason != null && !reason.isEmpty()
            && informer != null && !informer.isEmpty()
            && denounced != null && !denounced.isEmpty();
    }

    public void updateAll(String reason, String informer, String category,
                          String denounced, String specifications,
                          int idUserUpdate, int idCategory, int idEntity) {
        updateReason(reason);
        this.informer = informer;
        this.category = category;
        updateDenounced(denounced);
        updateSpecifications(specifications);
        this.idUserUpdate = idUserUpdate;
        this.idCategory = idCategory;
        this.idEntity = idEntity;
    }

    @Override
    public String toString() {
        return "Allegation{" +
                "idAllegation=" + idAllegation +
                ", reason='" + reason + '\'' +
                ", informer='" + informer + '\'' +
                ", category='" + category + '\'' +
                ", denounced='" + denounced + '\'' +
                ", specifications='" + specifications + '\'' +
                ", idUserCreate=" + idUserCreate +
                ", idUserUpdate=" + idUserUpdate +
                ", idCategory=" + idCategory +
                ", idEntity=" + idEntity +
                '}';
    }

    public Object getDateCreate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getDateUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}