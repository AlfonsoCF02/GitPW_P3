package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.pista.GestorPistas;
import business.pista.diff;

/**
 * Servlet implementation class pistasDisponiblesController
 */
public class pistasDisponiblesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pistasDisponiblesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/listarPistasFormView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nk=request.getParameter("nk");
		String dif=request.getParameter("diff");
		 try {
	            Integer.parseInt(nk);
	            
        } catch (NumberFormatException excepcion) {
        	request.getRequestDispatcher("errorPistaDisponible1.jsp").forward(request, response);
			return;
        }
		diff aux;
		if(dif.equals(diff.adult.toString())) {
			aux=diff.adult;
		}else if(dif.equals(diff.family.toString())) {
			aux=diff.family;
		}else if(dif.equals(diff.child.toString())) {
			aux=diff.child;
		}else {
			request.getRequestDispatcher("errorPistaDisponible2.jsp").forward(request, response);
			return;
		}
		GestorPistas gp=new GestorPistas();
		ArrayList<String> pistas=new ArrayList<String>();
		try {
			pistas=gp.pistasLibres(Integer.parseInt(nk), aux);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listado", pistas);
		request.getRequestDispatcher("/mvc/view/listarPistasView.jsp").forward(request, response);
		

		
	}

}
