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

import com.inti.model.Aeroport;
import com.inti.model.Ville;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class AeroportVilleServlet
 */
@WebServlet("/Aeroport")
public class AeroportVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger();
	private Session s;
	
    
    public AeroportVilleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		s = HibernateUtil.getSessionFactory().openSession();
		log.debug("Connexion à la BDD et configuration d'hibernate depuis compagnie");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/creerAerooportVille.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			s.beginTransaction();
			log.info("Début enregistrement Aeroport");
			
			Ville v = new Ville(request.getParameter("ville"));
			s.save(v);
			
			Aeroport ae1 = new Aeroport(request.getParameter("nomAeroport"),v);
			s.save(ae1);
			
			s.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur enregistrement aeroport-ville");
			
			s.getTransaction().rollback();
		}
		doGet(request, response);
	}

}
