package com.ies9021.snr.dto;

public class AllegationDTO {
    private int idAllegation;
    private String entidad;
    private String reclamo;
    private String description;
    private String status;

    public AllegationDTO(int idAllegation, String entidad, String reclamo, String description, String status) {
        this.idAllegation = idAllegation;
        this.entidad = entidad;
        this.reclamo = reclamo;
        this.description = description;
        this.status = status;
    }

    // Getters y setters
    public int getIdAllegation() { return idAllegation; }
    public String getEntidad() { return entidad; }
    public String getReclamo() { return reclamo; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
}