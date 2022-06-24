package org.article.dal.jdbc;


import java.util.List;

import org.article.bo.Auteur;
import org.article.bo.Produit;
import org.article.dal.DalException;

public class TestProduitJDBCImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuteurJDCImp auteurJdbc = new AuteurJDCImp();
		ProduitJDCImp produitJdbc = new ProduitJDCImp();
		try {
			List<Produit> maListedeProduit = produitJdbc.selectAll();

			/*Pain pain = new Pain("Boulangerie Ducoin","baguette ordinaire", 250, 800, 0.8f);
			Stylo stylo = new Stylo("Stabilo","Point 88 - la Cerisaie", 10000, 2.30f, "rose", "feutre");

			produitJdbc.insert(pain);
			produitJdbc.insert(stylo);

			List<Auteur> lesAuteursDeLaCarte = new ArrayList<>();
			lesAuteursDeLaCarte.add(auteurJdbc.selectById(7));
			lesAuteursDeLaCarte.add(auteurJdbc.selectById(8));
			CartePostale Carte = new CartePostale("Carte Sud Bretagne","La mine d'Or", 10000, 0.80f,lesAuteursDeLaCarte,TypeCartePostale.Paysage);
			produitJdbc.insert(Carte);*/

			for(Produit produit: maListedeProduit)
			{
				System.out.println(produit.toString());
			}

			/*Auteur waseem = new Auteur("waseem", "Alshami");
			Auteur thomas = new Auteur("thomas", "Gentrau");
			auteurJdbc.insert(waseem);
			auteurJdbc.insert(thomas);


			auteurJdbc.delete(auteur);


			auteurJdbc.delete(auteur);


			Auteur test = auteurJdbc.selectById(7);
			System.out.println(test);
			test.setNom("test");
			System.out.println(test);
			auteurJdbc.update(test);*/
			List<Auteur> maListedeAuteur = auteurJdbc.selectAll();


			for(Auteur auteur: maListedeAuteur)
			{
				System.out.println(auteur.toString());
			}


		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
