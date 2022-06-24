package org.article.bo;

public class Ligne {
    private long id;
    private Produit produit;
    private int quantite;
    public Ligne(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }
    public Ligne(long id,Produit produit,int quantite) {
        this(produit,quantite);
        this.setId(id);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public Produit getProduit() {
        return produit;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public Double getPrix(){
        double prix =produit.getPrixUnitaire()*getQuantite();
        return prix;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ligne{");
        sb.append("produit=").append(produit.toString());
        sb.append(", quantite=").append(quantite);
        sb.append(", prix=").append(produit.getPrixUnitaire()*quantite).append(" euros");
        sb.append('}');
        return sb.toString();
    }
}
