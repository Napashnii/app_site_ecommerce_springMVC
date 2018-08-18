package com.intiformation.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@javax.persistence.Entity

public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private int idClient;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="telephone")
	private String telephone;

	//Association entre personne et adressse
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "commande_id", referencedColumnName = "idCommande")
    private Commande commande;
	
	//ctor
	public Client(String nom, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	public Client(int idClient, String nom, String adresse, String telephone) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Client() {
		super();
	}
	//encapsulation
	
		public String getNom() {
			return nom;
		}
		public int getIdClient() {
			return idClient;
		}
		public void setIdClient(int idClient) {
			this.idClient = idClient;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		
				public Commande getCommande() {
			return commande;
		}

		public void setCommande(Commande commande) {
			this.commande = commande;
		}

		@Override
		public String toString() {
			return "Client [idClient=" + idClient + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone
					+ ", commande=" + commande + "]";
		}

	
}
