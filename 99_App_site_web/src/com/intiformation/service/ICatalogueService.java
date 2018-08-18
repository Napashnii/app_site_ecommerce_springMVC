package com.intiformation.service;


import com.intiformation.entity.Categorie;

public interface ICatalogueService {
	
	
	public void ajout(Categorie pCategorie);
	public void modifier(Categorie pCategorie);
	public void supprimer(int pIdCategorie);


}
