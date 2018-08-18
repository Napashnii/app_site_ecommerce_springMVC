package com.intiformation.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.dao.ICatalogue;
import com.intiformation.entity.Categorie;

@Transactional
@Service
public class CatalogueService implements ICatalogueService {

	// declaration de la couche DAO
	@Autowired 
	private ICatalogue catalogueDAO;
	
	/**
	 * setter pour l'injection du DAO avec spring
	 * @param fonctionnaireDAO
	 */
	public CatalogueService(ICatalogue catalogueDAO) {
		super();
		this.catalogueDAO = catalogueDAO;
	}

	@Override
	public void ajout(Categorie pCategorie) {
		catalogueDAO.addCategorie(pCategorie);

	}

	@Override
	public void modifier(Categorie pCategorie) {
		catalogueDAO.updateCategorie(pCategorie);	

	}

	@Override
	public void supprimer(int pIdCategorie) {
		catalogueDAO.deleteCategorie(pIdCategorie);
	}

}
