package org.article.bo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pain extends ProduitPerissable{

    private int poids;

    public Pain() {
        super();
    }

    public Pain(long refProd ,String marque, String libelle,int poids, long qteStock, float prixUnitaire) {
        super(refProd, LocalDate.now().plusDays(2), marque, libelle, qteStock, prixUnitaire);
        this.setPoids(poids);
    }

    public Pain(String marque, String libelle, long qteStock,  int poids, float prixUnitaire) {
        this(0,marque, libelle,poids,qteStock,prixUnitaire);
    }


    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }


    @Override
    public String toString() {

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        final StringBuilder sb = new StringBuilder("Pain [");
        sb.append("ref Produit=").append(getRefProd());
        sb.append(", marque=").append(getMarque());
        sb.append(", libelle=").append(getLibelle());
        sb.append(", prixUnitaire=").append(getPrixUnitaire()).append(" euros");
        sb.append(", qteStock=").append(getQteStock());
        sb.append(", dateLimiteConso=").append( getDatelimitConso().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) );
        sb.append(", poids=").append(getPoids());
        sb.append(']');
        return sb.toString();
    }
}

