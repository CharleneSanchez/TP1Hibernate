package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Client;
import com.inti.model.CompagnieAerienne;
import com.inti.model.Passager;
import com.inti.model.Reservation;
import com.inti.model.Vol;
import com.inti.util.HibernateUtil;

@WebServlet("/reservation")
public class reservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger log = LogManager.getLogger();
	private Session s;

	public reservationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		s = HibernateUtil.getSessionFactory().openSession();
		log.debug("Connexion à la BDD et configuration d'hibernate depuis commande");

		this.getServletContext().getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			s.beginTransaction();
			log.info("Début enregistrement réservation");
			
			Vol v = s.get(Vol.class, Integer.parseInt(request.getParameter("numVol")));
			
			if (v != null && v.getoFreservation().equals("ouvert")) {

				Reservation r1 = new Reservation(LocalDate.now());
				r1.setClient(s.get(Client.class, Integer.parseInt(request.getParameter("idClient"))));
				r1.setPassager(s.get(Passager.class, Integer.parseInt(request.getParameter("idPassager"))));
				r1.setVol(s.get(Vol.class, Integer.parseInt(request.getParameter("numVol"))));

				s.save(r1);
				s.getTransaction().commit();
			} else {
				log.error("vol indisponible");
				s.getTransaction().rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur enregistrement réservation");

			s.getTransaction().rollback();
		}
		doGet(request, response);
	}

}
