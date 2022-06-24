package org.article.bll;

import org.article.bo.*;
import org.article.dal.DAO;
import org.article.dal.DAOfactory;
import org.article.dal.DalException;

import java.util.List;

public class produitManager {
    private static volatile produitManager instance=null;
    private static DAO<Produit> impl;
    private produitManager() {
        impl= DAOfactory.getProduitDAO();
    }
    public final static produitManager getInstance() {
        if(produitManager.instance==null)
        {
            synchronized(produitManager.class)
            {
                if(produitManager.instance==null)
                {
                    produitManager.instance=new produitManager();
                }
            }
        }
        return produitManager.instance;
    }


    public List<Produit> getLesProduit() throws BLLException
    {
        List<Produit> lesProduit=null;
        try {
            lesProduit=impl.selectAll();
        } catch (DalException e) {
            // TODO Auto-generated catch block
            throw new BLLException("Erreur lors de la récupération des éléments chimiques",e);
        }

        return lesProduit;
    }


    public void ajouteProduit(Produit produit) throws BLLException
    {
        if(produit.getRefProd()>0)
        {
            throw new BLLException("Element chimique déjà existant");
        }
        valider(produit);
        try {
            impl.insert(produit);
        } catch (DalException e) {
            // TODO Auto-generated catch block
            throw new BLLException("Erreur lors de l'ajout de l'élément chimique "+produit,e.getCause());
        }

    }

    public void supprimerProduit(Produit produit) throws BLLException {
        try {
            valider(produit);
            impl.delete(produit);
        } catch (DalException e) {
            // TODO Auto-generated catch block
            throw new BLLException("Erreur lors de la suppression de l'élément chimique "+produit,e.getCause());

        }
    }
    public void modierProduit(Produit produit) throws BLLException
    {
        valider(produit);
        try {
            impl.update(produit);
        } catch (DalException e) {
            // TODO Auto-generated catch block
            throw new BLLException("Erreur lors de la modification de l'élément chimique "+produit,e.getCause());
        }

    }


    private void valider(Produit produit) throws BLLException
    {
        boolean valide=true;
        StringBuilder sb= new StringBuilder();
        if (produit==null)
        {
            throw new BLLException("Element chimique ne peut pas être null");
        }
        if (produit.getPrixUnitaire()<1)
        {
            sb.append("Le numéro atomique doit être positif!");
            valide=false;
        }
        if (produit.getQteStock()<1)
        {
            sb.append("La masse atomique doit être positive!");
            valide=false;
        }
        if (produit instanceof Pain){
            if (((Pain) produit).getPoids()<1)
            {
                sb.append("La masse atomique doit être positive!");
                valide=false;
            }
        }
        if (produit instanceof Glace){
            if (((Glace) produit).getParfum() == null)
            {
                sb.append("La masse atomique doit être positive!");
                valide=false;
            }
        }

        if (produit instanceof Stylo){
            if (((Stylo) produit).getCouleur() == null)
            {
                sb.append("La masse atomique doit être positive!");
                valide=false;
            }
            if (((Stylo) produit).getTypeMine() == null)
            {
                sb.append("La masse atomique doit être positive!");
                valide=false;
            }
        }

        if (produit instanceof CartePostale){

            if (((CartePostale) produit).getType() == null)
            {
                sb.append("La masse atomique doit être positive!");
                valide=false;
            }

            boolean goodtype = false;

            for (TypeCartePostale value : TypeCartePostale.values()) {
                if (((CartePostale) produit).getType() == value.name()){
                    goodtype = true;
                    break;
                }
            }

            if ( goodtype == false )
            {
                sb.append("La masse atomique doit être positive!");
                valide=false;
            }



        }

        if(!valide) {
            throw new BLLException(sb.toString());
        }

    }


}