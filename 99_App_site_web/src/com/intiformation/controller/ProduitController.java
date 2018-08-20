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

import com.intiformation.entity.Produit;
import com.intiformation.service.IProduitService;

@Controller
public class ProduitController {

	// déclaration du service produit
	@Autowired
	private IProduitService produitManager;

	/**
	 * setter pour injection
	 * 
	 * @param produitManager
	 */
	public void setProduitManager(IProduitService produitManager) {
		this.produitManager = produitManager;
	}

	// afficher tous les produits
	// =========================================================================
	@RequestMapping(value = "/produit/liste", method = RequestMethod.GET)
	public String listeProduits(ModelMap modele) {

		// appel du service pour recup la liste des produits
		List<Produit> listeProduits = produitManager.tousProduits();

		// données à afficher sur la vue
		modele.addAttribute("attributeProduit", listeProduits);

		// retour du nom de la vue contenues dans le dossier de vues
		return "gestionProduits";

	}// fin afficher tout

	// supprimer
	// -----------------------------------------------------------------------------------
	@RequestMapping(value = "produit/suppprimer/{produitId}", method = RequestMethod.GET)
	public String supprimeProduit(@PathVariable("produitId") int pIdProduit, ModelMap modele) {

		// supprimer le produit grace à l'id
		produitManager.suppProduit(pIdProduit);

		// recup la liste des produits
		List<Produit> listeProduits = produitManager.tousProduits();

		// données à afficher sur la vue
		modele.addAttribute("attributeProduit", listeProduits);

		// retour du nom de la vue "gestionProduits.jsp" contenues dans le dossier de
		// vues
		return "gestionProduits";

	} // fin supprimer

	// modification
	// ----------------------------------------------------------------------------------------------------------------
	/* 1. formulaire de modification */
	@RequestMapping(value = "/produit/updateproduitform", method = RequestMethod.GET)
	public ModelAndView setUpProduitUpdate(@RequestParam("produitid") int pProduitId) {

		// recup du produit de la bdd
		Produit produit = produitManager.trouverProduitById(pProduitId);

		/**
		 * updateproduit : nom de la vue "produitModifCommand" : nom de l'objet de
		 * commande produit : objet de la commande
		 */
		return new ModelAndView("updateproduit", "produitModifCommand", produit);
	}

	/* 2. modif du produit recupéré */
	@RequestMapping(value = "/produit/update", method = RequestMethod.POST)
	public String updateProduit(@ModelAttribute("produitModifCommand") Produit pProduit, ModelMap modele) {
		produitManager.modifProduit(pProduit);

		// recup la liste des produits
		List<Produit> listeProduits = produitManager.tousProduits();

		// données à afficher sur la vue
		modele.addAttribute("attributeProduit", listeProduits);

		// retour du nom de la vue "gestionProduits.jsp" contenues dans le dossier de
		// vues
		return "gestionProduits";

	}// fin modifier

	// ajouter
	// ============================================================================================================
	/* 1. formulaire d'ajout */
	@RequestMapping(value = "/ajouterproduitform", method = RequestMethod.GET)
	public ModelAndView setProduitForm() {

		// Données à retourner vers la vue
		Map<String, Object> data = new HashMap<>();

		// def de l'obj produit
		Produit produit = new Produit();

		// addition a la hashmap data / "produitCommand" est le nom de l'objet de
		// commande
		data.put("produitCommand", produit);

		// "ajouterProduit" : nom de la view
		return new ModelAndView("ajouterProduit", data);

	}

	/* 02. ajout du produit dans la bdd */
	@RequestMapping(value = "/produit/ajout", method = RequestMethod.POST)
	public String addProduit(@ModelAttribute("produitCommand") Produit pProduit, ModelMap modele) {

		// appel de produitManager pour l'ajout
		produitManager.ajoutProduit(pProduit);

		// recup la liste des produits
		List<Produit> listeProduits = produitManager.tousProduits();

		// données à afficher sur la vue
		modele.addAttribute("attributeProduit", listeProduits);

		// retour du nom de la vue "gestionProduits.jsp" contenues dans le dossier de
		// vues
		return "gestionProduits";

	} // fin ajouter

	// afficher les produits par mc
	// =========================================================================
	@RequestMapping(value = "/produit/liste/mc", method = RequestMethod.GET)
	public String listeProduitsMc(ModelMap modele, String mc) {

		// appel du service pour recup la liste des produits
		List<Produit> listeProduits = produitManager.findProduitsParMotCle(mc);

		// données à afficher sur la vue
		modele.addAttribute("attributeProduit", listeProduits);

		// renvoi  la page : afficher les produits par mc
				return "redirect:/produit/liste/mc";

	}// fin afficher liste produit par mc

	// afficher les produits par  int cat
	// =========================================================================
	@RequestMapping(value = "/produit/liste/cat", method = RequestMethod.GET)
	public String listeProduitsCat(ModelMap modele, int idCat) {

		// appel du service pour recup la liste des produits
		List<Produit> listeProduits = produitManager.findProduitsParCategorie(idCat);

		// données à afficher sur la vue
		modele.addAttribute("attributeProduit", listeProduits);

		// renvoi  la page : afficher les produits par categorie
		return "redirect:/produit/liste/cat";

	}// fin afficher liste produit par cat
	
	// afficher les produits par boolean selectionne
		// =========================================================================
		@RequestMapping(value = "/produit/liste/selection", method = RequestMethod.GET)
		public String listeProduitsSelectionnes(ModelMap modele) {

			// appel du service pour recup la liste des produits
			List<Produit> listeProduits = produitManager.findProduitsSelectionnes();

			// données à afficher sur la vue
			modele.addAttribute("attributeProduit", listeProduits);

			// renvoi  la page : afficher les produits par categorie
			return "redirect:/produit/liste/selection";

		}// fin afficher liste produit par selectionne

}// fin classe
