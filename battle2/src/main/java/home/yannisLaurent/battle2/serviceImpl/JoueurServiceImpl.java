package home.yannisLaurent.battle2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import home.yannisLaurent.battle2.business.Joueur;
import home.yannisLaurent.battle2.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {

	private List<Joueur> listeJoueurs = new ArrayList<>();

	
	public JoueurServiceImpl() {
		super();
		listeJoueurs.add(new Joueur("yass@mail.com", "Laurent", "Yannis", "123"));
	}

	@Override
	public Joueur inscription(String email, String nom, String prenom, String motDePasse) {
		Joueur joueur = new Joueur();
		joueur.setEmail(email);
		joueur.setNom(nom);
		joueur.setPrenom(prenom);
		joueur.setMotDePasse(motDePasse);
		listeJoueurs.add(joueur);
		return joueur;

	}

	@Override
	public Joueur connexion(String email, String motDePasse) {
		for (Joueur joueur : listeJoueurs) {
			if (joueur.getEmail().equals(email) && joueur.getMotDePasse().equals(motDePasse))
				return joueur;
		}
		return null;
	}

	@Override
	public List<Joueur> afficherJoueurs() {
		for(Joueur joueur : listeJoueurs){
			System.out.println(joueur);
		}
		return null;
	}

}
