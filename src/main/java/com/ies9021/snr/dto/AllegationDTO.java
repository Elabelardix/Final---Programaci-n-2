package com.ies9021.snr.dto;

public class AllegationDTO {

    private int idAllegation;
    private String claimDescription;
    private String denouncedName;
    private String categoryName;

    public AllegationDTO(int idAllegation, String claimDescription, String denouncedName,
                         String categoryName) {
        this.idAllegation = idAllegation;
        this.claimDescription = claimDescription;
        this.denouncedName = denouncedName;
        this.categoryName = categoryName;
    }

    public int getIdAllegation() { return idAllegation; }
    public String getClaimDescription() { return claimDescription; }
    public String getDenouncedName() { return denouncedName; }
    public String getCategoryName() { return categoryName; }
}