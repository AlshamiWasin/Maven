package org.article.bo;

import java.util.ArrayList;
import java.util.List;

public class Achat {
    private long id;
    private Double montant = 0d;
    private List<Ligne> lignesAchat = new ArrayList<>();
    public Achat(Ligne ligne) {
        lignesAchat.add(ligne);
    }
    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }
    public Ligne getLigne(int index) {
        if (lignesAchat.contains(lignesAchat.get(index))){
            return lignesAchat.get(index);
        }
        return null;
    }
    public List<Ligne> getLignes() {
        return lignesAchat;
    }
    public void ajouteLigne(Produit p , int qte){
        lignesAchat.add(new Ligne(p,qte));
        calculMontant();
    }
    public void modifieLigne(int index, int nouvelleQte){
        if (lignesAchat.contains(lignesAchat.get(index))){
            lignesAchat.get(index).setQuantite(nouvelleQte);
            calculMontant();
        }else {
            System.out.println("index introuvable");
        }
    }
    public void supprimeLigne(int index){
        if (lignesAchat.contains(lignesAchat.get(index))){
            lignesAchat.remove(lignesAchat.get(index));
            calculMontant();
        }else {
            System.out.println("index introuvable");
        }
    }
    public void calculMontant(){
        montant = 0d;
        for (Ligne ligne : lignesAchat) {
            montant +=ligne.getPrix();
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Achat:");
        sb.append("\n");
        sb.append("\n");
        for (Ligne ligne: lignesAchat) {
            sb.append("ligne").append(lignesAchat.indexOf(ligne)+1).append(":     ");
            sb.append(ligne.toString());
            sb.append("\n");

        }
        sb.append("Total de l'achat :").append( String.format("%.2f", montant)  ).append(" euros");
        return sb.toString();
    }
}
