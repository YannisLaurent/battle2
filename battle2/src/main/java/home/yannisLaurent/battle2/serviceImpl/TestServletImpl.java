package home.yannisLaurent.battle2.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import home.yannisLaurent.battle2.business.Verbe;
import home.yannisLaurent.battle2.service.JoueurService;
import home.yannisLaurent.battle2.service.QuestionService;
import home.yannisLaurent.battle2.service.VerbeService;

public class TestServletImpl {

	public static void main(String[] args) {

		JoueurService js = new JoueurServiceImpl();
		VerbeService vs = new VerbeServiceImpl();
		QuestionService qs = new QuestionServiceImpl();

		js.inscription("email", "nom", "prenom", "motDePasse");
		System.out.println(js.afficherJoueurs());
		List<Verbe> listeVerbe = new ArrayList<>();
		Verbe v0 = new Verbe("awake", "awoke", "awoken");
		Verbe v1 = new Verbe("become", "became", "become");
		Verbe v2 = new Verbe("cut", "cut", "cut");
		listeVerbe.add(v0);
		listeVerbe.add(v1);
		listeVerbe.add(v2);

		List<Verbe> listeVerbe2 = vs.listeVerbe();

		Random verbeRandom = new Random();
		int r = verbeRandom.nextInt(3);
		System.out.println(listeVerbe.get(r));

		System.out.println(listeVerbe2.get(r));
		System.out.println(qs.verifierQuestion("became", "become"));
	}
	

}
