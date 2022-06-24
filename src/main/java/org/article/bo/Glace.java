package org.article.bo;

import java.time.LocalDate;

public class Glace extends ProduitPerissable{
    private long id;
    private String parfum;
    private int temperatureConservation;
    public Glace() {
    }
    public Glace(long refProd,LocalDate datelimitConso, String marque, String libelle, int temperatureConservation, String parfum, long qteStock, float prixUnitaire) {
        super(refProd,datelimitConso, marque, libelle, qteStock, prixUnitaire);
        this.setParfum(parfum);
        this.setTemperatureConservation(temperatureConservation);
    }
    public Glace(LocalDate datelimitConso, String marque, String libelle, int temperatureConservation, String parfum, long qteStock, float prixUnitaire) {
        this(0,datelimitConso, marque, libelle,temperatureConservation,parfum, qteStock, prixUnitaire);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getParfum() {
        return parfum;
    }
    public void setParfum(String parfum) {
        this.parfum = parfum;
    }
    public int getTemperatureConservation() {
        return temperatureConservation;
    }
    public void setTemperatureConservation(int temperatureConservation) {
        this.temperatureConservation = temperatureConservation;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CartePostale [");
        sb.append("libelle=").append(getLibelle());
        sb.append(", marque=").append(getMarque());
        sb.append(", prixUnitaire=").append(getPrixUnitaire()).append(" euros") ;
        sb.append(", qteStock=").append(getQteStock());
        sb.append(", dateLimiteConso=").append(getDatelimitConso());
        sb.append(", parfum=").append(getParfum());
        sb.append(", temperatureConservation=").append(getTemperatureConservation());
        sb.append(']');
        return sb.toString();
    }
}
