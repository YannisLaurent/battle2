package home.yannisLaurent.battle2.service;

import java.util.List;

import home.yannisLaurent.battle2.business.Joueur;

public interface JoueurService {

	public Joueur inscription(String email, String nom, String prenom, String motDePasse);
	
	public Joueur connexion(String email, String motDePasse);
	
	public List<Joueur> afficherJoueurs();
}
