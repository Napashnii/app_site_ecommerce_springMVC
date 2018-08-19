package com.intiformation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intiformation.entity.Categorie;
import com.intiformation.entity.Produit;

@Repository
public class adminProduitMetier implements IAdminProduitMetier {
	
	//déclaration de la session factory d'hibernate
	@Autowired
	private SessionFactory sessionProd ;
	
	/**
	 * setter de sessionProd pour l'injection de spring
	 * @param sessionProd
	 */
	public void setSessionProd(SessionFactory sessionProd) {
		this.sessionProd = sessionProd;
	}

	//ajout dans la bdd : récupérer une catégorie et ajouter dans cette catégorie
	@Transactional
	@Override
	public void addProduit(Produit pProduit, int idCat) {
		sessionProd.getCurrentSession().get(Categorie.class, idCat);
		sessionProd.getCurrentSession().save(pProduit);
		
	}

	//modification
	@Override
	@Transactional
	public void updateProduit(Produit pProduit) {
		sessionProd.getCurrentSession().update(pProduit);
		
	}

	//supprimer
	@Override
	@Transactional
	public void deleteProduit(int pIdProduit) {
		Produit produit = sessionProd.getCurrentSession().get(Produit.class, pIdProduit);
		sessionProd.getCurrentSession().delete(produit);
		
	}

	//trouver un produit par ID
	@Override
	@Transactional
	public Produit getProduitById(int pIdProduit) {
		
		return sessionProd.getCurrentSession().get(Produit.class, pIdProduit);
	}

	//liste de tous les produits
	@Override
	@Transactional
	public List<Produit> getAllProduits() {
		
		return sessionProd.getCurrentSession().createQuery("FROM produit AS p").list();
	}

	//trouver produit par mots clés
	@Override
	@Transactional
	public List<Produit> produitsParMotCle(String mc) {
		
		return sessionProd.getCurrentSession().createQuery("SELECT p FROM produit p WHERE p.mc = :pDescription").list();
	}

	//trouver un produit par cat
	@Override
	@Transactional
	public List<Produit> produitsParCategorie(int idCat) {
		
		return sessionProd.getCurrentSession().createQuery("SELECT p FROM produit p WHERE p.idCat = :pIdCategorie").list();
	}

	//trouver un produit par selection(booleen)
	@Override
	@Transactional
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return sessionProd.getCurrentSession().createQuery("SELECT p FROM produit p WHERE p.selectionne = ?true").list();
	}

}
