package org.article.bo;

import java.util.ArrayList;
import java.util.List;

public class CartePostale extends Produit{

    private List<Auteur> lesAuteurs = new ArrayList<>();
    private String type;

    public CartePostale() {
        super();
    }

    public CartePostale(long refProd, String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> lesAuteurs, TypeCartePostale type) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        this.lesAuteurs = lesAuteurs;
        this.type = type.name();
    }

    public CartePostale(String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> lesAuteurs, TypeCartePostale type) {
        this(0, marque, libelle, qteStock, prixUnitaire,lesAuteurs,type);
    }
    public List<Auteur> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(List<Auteur> lesAuteurs) {
        this.lesAuteurs = lesAuteurs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CartePostale [");
        sb.append("libelle=").append(getLibelle());
        sb.append(", marque=").append(getMarque());
        sb.append(", prixUnitaire=").append(getPrixUnitaire()).append(" euros");
        sb.append(", qteStock=").append(getQteStock());
        sb.append(", auteur(s)=");
        if (lesAuteurs.isEmpty()) {
            sb.append(" pas des auteurs");
        }else {
            for (Auteur auteur : lesAuteurs) {
                sb.append(auteur.toString());
            }
        } ;
        sb.append(", type=").append(type);
        sb.append(']');
        return sb.toString();
    }
}
