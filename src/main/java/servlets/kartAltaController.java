package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.kart.GestorKart;
import business.kart.kartstat;
import business.pista.GestorPistas;

/**
 * Servlet implementation class kartAltaController
 */
public class kartAltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public kartAltaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/kartAltaView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   String tipo=request.getParameter("tipo");
	   String estado=request.getParameter("estado");
       kartstat ks;
	   int s = 0;

       boolean b;
	   if(tipo!=null && !tipo.equals("")){
		   if(estado.equals(kartstat.disponible.toString())){
			   ks=kartstat.disponible;
		   }else if(estado.equals(kartstat.mantenimiento.toString())) {
			   ks=kartstat.mantenimiento;
		   }else{
			   ks=kartstat.reservado;
		   }
	       if(tipo.equals("true")) {
	    	   b=true;
	       }else {
	    	   b=false;
	       }
		   GestorKart gk=new GestorKart();
		try {
			s = gk.crearKart(null, b, ks);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    PrintWriter out=response.getWriter();
			out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
		}
	   }
	   if(s==0) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
	   }
	}
}
