package com.inti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Vol;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class ouvrirFermerVol
 */
@WebServlet("/ofVol")
public class ouvrirFermerVol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger();
	private Session s;

	public ouvrirFermerVol() {
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
		s = HibernateUtil.getSessionFactory().openSession();
		log.debug("Connexion à la BDD et configuration d'hibernate depuis ouverture/fermeture vol");

		this.getServletContext().getRequestDispatcher("/WEB-INF/ouvertureFermetureVol.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			s.beginTransaction();
			log.info("Début ouverture/fermeture vol");

			int idVol = Integer.parseInt(request.getParameter("idVol"));

			Vol v2 = s.get(Vol.class, idVol);
			
			if (v2 != null) {
				if (request.getParameter("ouvrirFermer").equals("fermer")) {
					v2.setoFreservation("fermer");
				}
				else {
					v2.setoFreservation("ouvert");
				}
			} else {
				log.error("id Vol incorrect");
			}
			s.save(v2);

			s.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur enregistrement vol");

			s.getTransaction().rollback();
		}
		doGet(request, response);
	}

}
