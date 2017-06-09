package home.yannisLaurent.battle2.service;

import home.yannisLaurent.battle2.business.Partie;
import home.yannisLaurent.battle2.business.Question;
import home.yannisLaurent.battle2.business.Verbe;

public interface QuestionService {

	Question creerQuestion(Verbe verbe, Partie partie);
	Boolean verifierQuestion(String preterit, String participePassee);
	
	
}
