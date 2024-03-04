package com.example;

class Article {
    private String code;
    private String designation;
    private double prixU;
    private String rayon;

    public Article(String code, String designation, double prixU, String rayon) {
        this.code = code;
        this.designation = designation;
        this.prixU = prixU;
        this.rayon = rayon;
        
    }

    // Getters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getRayon() {
        return rayon;
    }
    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public double getPrixU() {
        return prixU;
    }
    public void setPrixU(double prixU ) {
        this.prixU=prixU;
}
public String getDesignation() {
    return designation;
}
}