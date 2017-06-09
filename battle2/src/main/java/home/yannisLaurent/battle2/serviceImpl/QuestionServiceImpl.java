package home.yannisLaurent.battle2.serviceImpl;

import java.util.List;

import home.yannisLaurent.battle2.business.Partie;
import home.yannisLaurent.battle2.business.Question;
import home.yannisLaurent.battle2.business.Verbe;
import home.yannisLaurent.battle2.service.QuestionService;
import home.yannisLaurent.battle2.service.VerbeService;

public class QuestionServiceImpl implements QuestionService {

	VerbeService vs = new VerbeServiceImpl();
	@Override
	public Question creerQuestion(Verbe verbe, Partie partie) {
		Question question = new Question(partie, verbe);
		return question;
	}

	@Override
	public Boolean verifierQuestion(String preterit, String participePassee) {
		List<Verbe> listeVerbe = vs.listeVerbe();
		for(int i = 0; i < listeVerbe.size(); i++){
			if (preterit == listeVerbe.get(i).getPreterit()
					&& participePassee == listeVerbe.get(i).getParticipePasse())
				return true;
		}
		return false;

	}

}
