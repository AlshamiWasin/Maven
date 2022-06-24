package org.article.bo;

public class Produit {
    private long refProd;
    private String marque;
    private String libelle;
    private long qteStock;
    private float prixUnitaire;
    public Produit() {
    }
    public Produit(String marque , String libelle, long qteStock, float prixUnitaire) {
        this.libelle = libelle;
        this.marque = marque;
        this.prixUnitaire = prixUnitaire;
        this.qteStock = qteStock;
    }
    public Produit(long refProd, String marque ,String libelle, long qteStock, float prixUnitaire) {
        this(marque,libelle,qteStock,prixUnitaire);
        this.setRefProd(refProd);
    }
    public long getRefProd() {
        return refProd;
    }
    public void setRefProd(long refProd) {
        this.refProd = refProd;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public float getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public long getQteStock() {
        return qteStock;
    }
    public void setQteStock(long qteStock) {
        this.qteStock = qteStock;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produit{");
        sb.append("refProd=").append(refProd);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", prixUnitaire=").append(prixUnitaire);
        sb.append(", qteStock=").append(qteStock);
        sb.append('}');
        return sb.toString();
    }
}
