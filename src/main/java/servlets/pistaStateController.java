package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.kart.GestorKart;
import business.kart.kartstat;
import business.pista.GestorPistas;
import business.pista.diff;

/**
 * Servlet implementation class pistaStateController
 */
public class pistaStateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pistaStateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/modifyPistaView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String pista=request.getParameter("pista");
		   String estado=request.getParameter("disponible");
	       diff d;
		   if(pista!=null && !pista.equals("")){
			   if(!estado.equals("true") && !estado.equals("false")) {
				   request.getRequestDispatcher("errorModifyPista1.jsp").forward(request, response);
					return;
			   }
			   GestorPistas gk=new GestorPistas();
			   int s;
			try {
				s = gk.modificarPistaState(pista, estado);
				if(s==0) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("errorModifyPista2.jsp").forward(request, response);
					return;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    PrintWriter out=response.getWriter();
				out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
			}
		   }	}

}
