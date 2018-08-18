package com.intiformation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Categorie {
	private int idCategorie;
	private String nom;
	private String photo;
	private String description;
	
	//association avec le produit
	@OneToMany( mappedBy = "categorie", targetEntity =  Produit.class, cascade = CascadeType.ALL)
	   private List<Produit> listeProduit;
	
	//ctor
	public Categorie() {
		super();
	}
	public Categorie(String nom, String photo, String description) {
		super();
		this.nom = nom;
		this.photo = photo;
		this.description = description;
	}
	public Categorie(int idCategorie, String nom, String photo, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nom = nom;
		this.photo = photo;
		this.description = description;
	}
	//encapsulation
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nom=" + nom + ", photo=" + photo + ", description="
				+ description + ", listeProduit=" + listeProduit + "]";
	}
		
	
	

}
