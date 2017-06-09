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
 * Servlet implementation class Connexion
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JoueurService js = new JoueurServiceImpl();
	VerbeService vs = new VerbeServiceImpl();
	PartieService ps = new PartieServiceImpl();
	QuestionService qs = new QuestionServiceImpl();

	public ConnexionServlet() {
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
		request.setAttribute("joueur", joueur);
		request.setAttribute("question", question);
		request.setAttribute("partie", partie);
		if (joueur != null) {
			request.getRequestDispatcher("QuestionServlet").forward(request, response);
		} else {
			System.out.println("Joueur innexistant ! Inscrivez vous !");
			// request.setAttribute("erreur", "Saisies incorrectes");
			// request.getRequestDispatcher("index.jsp").forward(request,
			// response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
