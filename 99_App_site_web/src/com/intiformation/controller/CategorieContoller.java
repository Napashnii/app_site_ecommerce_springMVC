package com.intiformation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.entity.Categorie;
import com.intiformation.service.ICatalogueService;

@Controller
public class CategorieContoller {

	// declaration du service
	@Autowired
	private ICatalogueService CatalogueManged;

	// setteur pour injection
	public void setCatalogueManged(ICatalogueService catalogueManged) {
		CatalogueManged = catalogueManged;
	}

	//methode afficher toutes les categories
	@RequestMapping(value = "/categorie/liste", method = RequestMethod.GET)
	public String listeCategorie(ModelMap modele) {

		// On appele la service pour recupere la liste des categorie
		List<Categorie> listeCategorie = CatalogueManged.afficherTout();

		// donnee qu'on veut afficher à travers la vue
		modele.addAttribute("attributCategorie", listeCategorie);

		// le retour du nom logique de la vue
		return "categorie";

	}// fin de la methode afficher toutes les categories grave à la vue

	//methode de suppression
	@RequestMapping(value = "categorie/supprimer/{categorieId}", method = RequestMethod.GET)
	public String supprimeCategorie(@PathVariable("categorieId") int pIdCategorie, ModelMap modele) {
		// supprimer la categori à l'id qu'on demande
		CatalogueManged.supprimer(pIdCategorie);
		// recup de la liste des categories
		List<Categorie> listeCategorie = CatalogueManged.afficherTout();
		// donne à afficher à travers le vue
		modele.addAttribute("attributCategorie", listeCategorie);

		// renvoie de la page afficher toutes les categories
		return "redirect:/categorie/liste";

	}// fin de la methode supprimer

	/*-------------------------------------------------------------------------------------------------------------------*/
	// modification
	// 1.Affiche le formulaire de modification
	@RequestMapping(value = "/categorie/updatecategorieform", method = RequestMethod.GET)
	public ModelAndView setUpCategorieUpdate(@RequestParam("categorieid") int pCategorieId) {

	// 1. Récupération d'une categorie de la BDD (objet de commande)
	Categorie categorie = CatalogueManged.getCategorieById(pCategorieId);

	// renvois : le nom de la vue, nom de l'objet de commande, et objet de commande
	return new ModelAndView("updatecategorie", "CategorieModifCommand", categorie);
	}

	// 2. Modif de l'objet recupere par l'utilisateur
	@RequestMapping(value = "/categorie/update", method = RequestMethod.POST)
	public String updateCategorie(@ModelAttribute("CategorieModifCommand") Categorie pCategorie, ModelMap modele) {

		CatalogueManged.modifier(pCategorie);

		// Récupération de la liste des categories
		List<Categorie> listeCategorie = CatalogueManged.afficherTout();

		// Données à retourner vers la vue
		modele.addAttribute("attributCategorie", listeCategorie);

		// Renvoi du nom logique de la vue
		return "redirect:/categorie/liste";
	}// fin de la methode de mofi
	
	/*-------------------------------------------------------------------------------------------------------------------*/
	//methode de l'ajout
	
	//1. Formulaire dans une hasMap
	@RequestMapping(value= "/ajoutecategorieform", method=RequestMethod.GET)
	public ModelAndView setUpFormulaire() {
		
		// Données à retourner vers la vue 
		Map<String, Object> data = new HashMap<>();
		
		// 1. Définition de l'objet de commande
		Categorie categorie = new Categorie();		
		
		// 2. Définition du nom de l'objet de commande
		String objetDeCommande = "CategorieCommand";
		
		// 3. Association du nom à l'objet
		data.put(objetDeCommande, categorie);
		
		// 4. nom de la vue
		String viewName = "ajouterCategorie";
		
		//retourne la vue et les donnes
		return new ModelAndView(viewName, data);
	}
	
	//2.Ajout par l'utilisateur
	@RequestMapping(value= "/categorie/ajout", method=RequestMethod.POST)
	//on recupere les info saisie dans le formulaire dans l'objet de commande
	public String addCategorie(@ModelAttribute("CategorieCommand") Categorie pCategorie, ModelMap modele) {
		
		// Appel du Service pour l'ajout du fonctionnaire dans la BDD
		CatalogueManged.ajout(pCategorie);
		
		// Récupération de la liste des fonctionnaires
		List<Categorie> listeCategorie = CatalogueManged.afficherTout();
		
		// Données à retourner vers la vue
		modele.addAttribute("attributeListeCategorie", listeCategorie);
				
		// Renvoi du nom logique de la vue 
		return "redirect:/categorie/liste";
	}//fin de la methode ajout	
	
	
	

}// fin de la classe
