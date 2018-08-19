package com.intiformation.service;

import java.util.List;

import com.intiformation.entity.Produit;

public interface IProduitService {
	
	public void ajoutProduit(Produit pProduit);
	public void modifProduit(Produit pProduit);
	public void suppProduit(int pIdProduit);
	public Produit trouverProduitById(int pIdProduit);
	public List<Produit> tousProduits();
	public List<Produit> findProduitsParMotCle(String mc);
	public List<Produit> findProduitsParCategorie(int idCat);
	public List<Produit> findProduitsSelectionnes();

}
