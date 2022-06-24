package org.article.dal;

import org.article.bo.Produit;
import org.article.dal.jdbc.ProduitJDCImp;

public class DAOfactory {
    public static DAO<Produit> getProduitDAO(){
        DAO<Produit> maDAO = (DAO<Produit>) new ProduitJDCImp();
        return maDAO;
    }
}
