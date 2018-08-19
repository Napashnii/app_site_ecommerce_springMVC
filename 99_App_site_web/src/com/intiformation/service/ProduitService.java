package com.intiformation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.dao.IAdminProduitMetier;
import com.intiformation.dao.adminProduitMetier;
import com.intiformation.entity.Produit;

@Service
@Transactional
public class ProduitService implements IProduitService{
	
	//déclaration de la couche DAO 
	@Autowired
	private IAdminProduitMetier adminProduitMetier ;
	
	/**
	 * setter pour l'injection du DAO avec Spring
	 * @param adminProduitMetier
	 */
	public void setAdminProduitMetier(IAdminProduitMetier adminProduitMetier) {
		this.adminProduitMetier = adminProduitMetier;
	}

	@Override
	public void ajoutProduit(Produit pProduit, int idCat) {
		adminProduitMetier.addProduit(pProduit, idCat);
		
	}

	@Override
	public void modifProduit(Produit pProduit) {
		adminProduitMetier.updateProduit(pProduit);
		
	}

	@Override
	public void suppProduit(int pIdProduit) {
		adminProduitMetier.deleteProduit(pIdProduit);
		
	}

	@Override
	public Produit trouverProduitById(int pIdProduit) {
		
		return adminProduitMetier.getProduitById(pIdProduit);
	}

	@Override
	public List<Produit> tousProduits() {
		
		return adminProduitMetier.getAllProduits();
	}

	@Override
	public List<Produit> findProduitsParMotCle(String mc) {
		
		return adminProduitMetier.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> findProduitsParCategorie(int idCat) {
		
		return adminProduitMetier.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> findProduitsSelectionnes() {
		
		return adminProduitMetier.produitsSelectionnes();
	}

}
