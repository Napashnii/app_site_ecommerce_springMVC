package com.intiformation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intiformation.entity.Categorie;

@Repository
public class CatalogueDAO implements ICatalogue {

	// Déclaration de la sessionFactory d'hibernate
	@Autowired
	private SessionFactory sessionFactory;

	// ajout dans la bdd
	@Override
	@Transactional
	public void addCategorie(Categorie pCategorie) {
		sessionFactory.getCurrentSession().save(pCategorie);

	}

	@Override
	@Transactional
	public void updateCategorie(Categorie pCategorie) {
		sessionFactory.getCurrentSession().update(pCategorie);

	}

	// suppression
	@Override
	@Transactional
	public void deleteCategorie(int pIdCategorie) {
		Categorie categorie = sessionFactory.getCurrentSession().get(Categorie.class, pIdCategorie);

		sessionFactory.getCurrentSession().delete(categorie);
	}

	@Override
	@Transactional
	public Categorie getCategorieById(int pIdCategorie) {
		return sessionFactory.getCurrentSession().get(Categorie.class,pIdCategorie);
	}

	@Override
	@Transactional
	public List<Categorie> getAllCategorie() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM categorie").list();
	}
	

	/**
	 * Setter de la sessionFactory pour l'injection de Spring
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}



