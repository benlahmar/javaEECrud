package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Manager;

/**
 * Servlet implementation class Addetudiant
 */
@WebServlet("/Addetudiant")
public class Addetudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Manager dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addetudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao=new Manager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom= request.getParameter("nom");
				String p= request.getParameter("prenom");
				String lg= request.getParameter("log");
				String ps= request.getParameter("pass");
				dao.AddEtudiant(nom, p, lg, ps);
				response.sendRedirect("addetudant.jsp");
	
	}

}
