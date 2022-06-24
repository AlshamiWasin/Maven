package org.article.bo;

import java.util.List;

public class Auteur {
    private long id;
    private String prenom;
    private String nom;

    private List<CartePostale> listCarte;

    public Auteur() {
    }



    public Auteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    public Auteur(long id,String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.setId(id);
    }
    public Auteur(long id, String prenom, String nom ,List<CartePostale>  listCarte) {
        this(prenom,nom , listCarte);
        this.setId(id);
    }

    public Auteur(String prenom, String nom ,List<CartePostale> listCarte) {
        this.prenom = prenom;
        this.nom = nom;
        this.listCarte = listCarte;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auteur{");
        sb.append("id=").append(id);
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
