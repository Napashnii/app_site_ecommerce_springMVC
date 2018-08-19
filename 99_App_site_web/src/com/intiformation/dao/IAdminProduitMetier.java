package com.intiformation.dao;

import java.util.List;

import com.intiformation.entity.Produit;

public interface IAdminProduitMetier {
	
	public void addProduit(Produit pProduit, int idCat);
	public void updateProduit(Produit pProduit);
	public void deleteProduit(int pIdProduit);
	public Produit getProduitById(int pIdProduit);
	public List<Produit> getAllProduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(int idCat);
	public List<Produit> produitsSelectionnes();
	

}
