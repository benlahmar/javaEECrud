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
 * Servlet implementation class AddeMatier
 */
@WebServlet("/AddeMatier")
public class AddeMatier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Manager dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddeMatier() {
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
		String lib=request.getParameter("lib");
		double coiff = Double.parseDouble(request.getParameter("coiff"));
		dao.AddMatiere(lib, coiff);
		response.sendRedirect("addetudant.jsp");
	}

}
