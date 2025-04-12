package com.fst.second.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fst.second.entities.Compte;
import static com.fst.second.ThirdApplication.comptes;

@Controller
@RequestMapping("comptes")
public class BanqueController {
@RequestMapping("liste")
public String ListeComptes(Model model) {
	model.addAttribute("comptes", comptes);
	return "listeComptes";
}
@PostMapping("add")
public String ajouter(@RequestParam("titulaire") String titulaire,
		@RequestParam("solde")double solde)
{
	int id = comptes.size();
	id++;
	Compte c = new Compte (titulaire,solde);
	c.setId(id);
	comptes.add(c);
	return "redirect:liste";
}
@GetMapping("add")
public String add() {
	return"ajouter";
}
@GetMapping("/details/{id}")
public String detailsCompte(@PathVariable ("id") int id, Model model) {
	
    for (Compte c : comptes) {
        if (c.getId() == id) {
        	
        	model.addAttribute("c", c);
        	
        }
    }
    
    return "detailsCompte";
}
@PostMapping("/depot/{id}")
public String depot(@PathVariable("id") int id, @RequestParam double montant) {
    for (Compte c : comptes) {
        if (c.getId() == id && montant > 0) {
            c.setSolde(c.getSolde() + montant);
            break;
        }
    }
    return "redirect:../details/{id}" ;
}
@PostMapping("/retrait/{id}")
public String retrait(@PathVariable int id, @RequestParam double montant) {
    for (Compte c : comptes) {
        if (c.getId() == id && montant > 0 && c.getSolde() >= montant) {
            c.setSolde(c.getSolde() - montant);
            break;
        }
    }
    return "redirect:../details/{id}";
}
@GetMapping("index")
public String index() {
	return "index";
}

}
