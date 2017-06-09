package home.yannisLaurent.battle2.business;

import java.util.ArrayList;
import java.util.List;

public class Partie {
	private Joueur joueur;
	private List<Question> questions = new ArrayList<>();

	public Partie(Joueur joueur) {
		this.joueur = joueur;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	@Override
	public String toString() {
		return "Partie [joueur=" + joueur + ", questions=" + questions + "]";
	}

}
