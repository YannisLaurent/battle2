package home.yannisLaurent.battle2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.yannisLaurent.battle2.business.Joueur;
import home.yannisLaurent.battle2.business.Verbe;
import home.yannisLaurent.battle2.service.JoueurService;
import home.yannisLaurent.battle2.service.VerbeService;
import home.yannisLaurent.battle2.serviceImpl.JoueurServiceImpl;
import home.yannisLaurent.battle2.serviceImpl.VerbeServiceImpl;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JoueurService js = new JoueurServiceImpl();
	VerbeService vs = new VerbeServiceImpl();

	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Joueur joueur = js.inscription(request.getParameter("EMAIL"), request.getParameter("NOM"),
				request.getParameter("PRENOM"), request.getParameter("MOT_DE_PASSE"));
		request.setAttribute("joueur", joueur);
		Verbe verbe = vs.verbeAlea();
		request.setAttribute("verbe", verbe);
		if (joueur != null) {
			request.getRequestDispatcher("question.jsp").forward(request, response);
		}
	}
}
