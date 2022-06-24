package org.article.bo;

import java.time.LocalDate;

public class Stylo extends Produit{

    private String couleur;
    private String typeMine;

    public Stylo() {
        super();
    }

    public Stylo(long refProd ,String marque, String libelle, long qteStock, float prixUnitaire,String couleur, String typeMin) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        this.setCouleur(couleur);
        this.setTypeMine(typeMin);
    }

    public Stylo(String marque, String libelle, long qteStock, float prixUnitaire, String couleur, String typeMine) {
        this(0,marque, libelle,qteStock,prixUnitaire,couleur,typeMine);
    }


    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getTypeMine() {
        return typeMine;
    }

    public void setTypeMine(String typeMine) {
        this.typeMine = typeMine;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stylo [");
        sb.append("marque=").append(getMarque());
        sb.append(", libelle=").append(getLibelle());
        sb.append(", prixUnitaire=").append(getPrixUnitaire()).append(" euros");
        sb.append(", qteStock=").append(getQteStock());
        sb.append(", couleur=").append(couleur);
        sb.append(", typeMine=").append(typeMine);
        sb.append(']');
        return sb.toString();
    }
}
