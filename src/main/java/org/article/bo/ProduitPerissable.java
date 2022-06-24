package org.article.bo;

import java.time.LocalDate;

public class ProduitPerissable extends Produit{

    private LocalDate datelimitConso;

    public ProduitPerissable() {
        super();
    }

    public ProduitPerissable(long refProd, LocalDate datelimitConso, String marque, String libelle, long qteStock, float prixUnitaire) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        this.datelimitConso = datelimitConso;
    }
    public ProduitPerissable(LocalDate datelimitConso, String marque, String libelle, long qteStock, float prixUnitaire) {
        super(marque, libelle, qteStock, prixUnitaire);
        this.datelimitConso = datelimitConso;
    }
    public LocalDate getDatelimitConso() {
        return datelimitConso;
    }
    public void setDatelimitConso(LocalDate datelimitConso) {
        this.datelimitConso = datelimitConso;
    }
}
