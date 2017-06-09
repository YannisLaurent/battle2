package home.yannisLaurent.battle2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import home.yannisLaurent.battle2.business.Joueur;
import home.yannisLaurent.battle2.business.Partie;
import home.yannisLaurent.battle2.business.Question;
import home.yannisLaurent.battle2.business.Verbe;
import home.yannisLaurent.battle2.service.JoueurService;
import home.yannisLaurent.battle2.service.PartieService;
import home.yannisLaurent.battle2.service.QuestionService;
import home.yannisLaurent.battle2.service.VerbeService;
import home.yannisLaurent.battle2.serviceImpl.JoueurServiceImpl;
import home.yannisLaurent.battle2.serviceImpl.PartieServiceImpl;
import home.yannisLaurent.battle2.serviceImpl.QuestionServiceImpl;
import home.yannisLaurent.battle2.serviceImpl.VerbeServiceImpl;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JoueurService js = new JoueurServiceImpl();
	PartieService ps = new PartieServiceImpl();
	QuestionService qs = new QuestionServiceImpl();
	VerbeService vs = new VerbeServiceImpl();

	public QuestionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Joueur joueur = js.connexion(request.getParameter("EMAIL"), request.getParameter("MOT_DE_PASSE"));
		Verbe verbe = vs.verbeAlea();
		Partie partie = ps.creerPartie(joueur);
		Question question = qs.creerQuestion(verbe, partie);
		request.setAttribute("question", question);
		request.setAttribute("partie", partie);
		request.getRequestDispatcher("question.jsp").forward(request, response);
		System.out.println("je suis dans le doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("je suis dans le doPost");
		int score = 0;
		Joueur joueur = js.connexion(request.getParameter("EMAIL"), request.getParameter("MOT_DE_PASSE"));

		boolean reponse = qs.verifierQuestion(request.getParameter("PRETERIT"),
				request.getParameter("PARTICIPE_PASSE"));
		if (reponse) {
			Verbe verbe = vs.verbeAlea();
			Partie partie = ps.creerPartie(joueur);
			Question question = qs.creerQuestion(verbe, partie);
			request.setAttribute("question", question);
			request.setAttribute("partie", partie);
			request.setAttribute("score", score);
			score++;
			request.getRequestDispatcher("question.jsp").forward(request, response);
			System.out.println("reponse juste");
		} else {
			System.out.println("reponse fausse !");
		}
	}
}
