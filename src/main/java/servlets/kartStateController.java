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

/**
 * Servlet implementation class kartStateController
 */
public class kartStateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kartStateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/modifyKartView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   String id=request.getParameter("kart");
	   String estado=request.getParameter("estado");
       kartstat ks;
	   if(id!=null && !id.equals("")){
		   if(estado.equals(kartstat.disponible.toString())){
			   ks=kartstat.disponible;
		   }else if(estado.equals(kartstat.mantenimiento.toString())) {
			   ks=kartstat.mantenimiento;
		   }else if(estado.equals(kartstat.reservado.toString())){
			   ks=kartstat.reservado;
		   }else {
			   request.getRequestDispatcher("errorModify2.jsp").forward(request, response);
			   return;
		   }
	       
		   GestorKart gk=new GestorKart();
		   int s;
		try {
			s = gk.modificarKartState(Integer.parseInt(id), ks);
			if(s==0) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("errorModify1.jsp").forward(request, response);
				return;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    PrintWriter out=response.getWriter();
			out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
		}
	   }
	}

}
