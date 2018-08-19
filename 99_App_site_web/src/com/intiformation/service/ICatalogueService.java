package com.intiformation.service;


import java.util.List;

import com.intiformation.entity.Categorie;

public interface ICatalogueService {
	
	
	public void ajout(Categorie pCategorie);
	public void modifier(Categorie pCategorie);
	public void supprimer(int pIdCategorie);
	public List<Categorie> afficherTout();
	public Categorie getCategorieById(int pIdCategorie);
	


}
