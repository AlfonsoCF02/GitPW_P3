package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.pista.diff;
import data.BonoDAO;

/**
 * Servlet implementation class listarBonoController
 */
public class listarBonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarBonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/mvc/view/listarBonoFormView.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BonoDAO b=new BonoDAO();
		String mail=request.getParameter("email");
		String tipo=request.getParameter("tipo");
		diff aux;
		if(tipo.equals(diff.adult.toString())) {
			aux=diff.adult;
		}else if(tipo.equals(diff.family.toString())) {
			aux=diff.family;
		}else if(tipo.equals(diff.child.toString())) {
			aux=diff.child;
		}else {
			request.getRequestDispatcher("errorPistaDisponible2.jsp").forward(request, response);
			return;
		}
		ArrayList<String> bonos=b.listarBonos(mail,aux.toString());
		request.setAttribute("listado", bonos);
		request.getRequestDispatcher("/mvc/view/listarBonoView.jsp").forward(request, response);	
	}

}
