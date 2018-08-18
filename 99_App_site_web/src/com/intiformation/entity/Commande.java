package com.intiformation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int idCommande;
	
	@Column(name="Date_commande")
	private String DateCommande;
	
	 //assosciation bidirecteionnelle avec le client
    @OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
    private Client client;
    
    //association avec le produit
  
    private List<Produit> listeProduit ;
	
	
	//ctor
	public Commande() {
		super();
	}
	public Commande(String dateCommande) {
		super();
		DateCommande = dateCommande;
	}
	public Commande(int idCommande, String dateCommande) {
		super();
		this.idCommande = idCommande;
		DateCommande = dateCommande;
	}
	//encapsulation
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public String getDateCommande() {
		return DateCommande;
	}
	public void setDateCommande(String dateCommande) {
		DateCommande = dateCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", DateCommande=" + DateCommande + ", client=" + client
				+ ", listeProduit=" + listeProduit + "]";
	}
	
	
	
	
}
