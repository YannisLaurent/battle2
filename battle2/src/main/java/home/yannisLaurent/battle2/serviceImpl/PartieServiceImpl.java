package home.yannisLaurent.battle2.serviceImpl;

import home.yannisLaurent.battle2.business.Joueur;
import home.yannisLaurent.battle2.business.Partie;
import home.yannisLaurent.battle2.service.PartieService;

public class PartieServiceImpl implements PartieService {

	@Override
	public Partie creerPartie(Joueur joueur) {
		Partie partie = new Partie(joueur);
		return partie;
	}

}
