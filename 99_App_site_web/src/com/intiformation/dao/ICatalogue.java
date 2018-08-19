package com.intiformation.dao;

import java.util.List;

import com.intiformation.entity.Categorie;

public interface ICatalogue {
	
	public void addCategorie(Categorie pCategorie);
	public void updateCategorie(Categorie pCategorie);
	public void deleteCategorie(int pIdCategorie);
	public Categorie getCategorieById(int pIdCategorie);
	public List<Categorie> getAllCategorie();
	
	//public void ajouterUser (user u); 
	//public void attribuerRole (Role r, Long userID); 

}
