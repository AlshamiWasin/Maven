package org.article.bll;

import org.article.bo.Produit;

public class TestBll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		produitManager monM= produitManager.getInstance();

		try {
			for (Produit produit : monM.getLesProduit()) {
				System.out.println(produit.toString());
			}
		} catch (BLLException e) {
			throw new RuntimeException(e);
		}


	}

}
