package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.kart.kartstat;
import business.pista.GestorPistas;

/**
 * Servlet implementation class kartAltaController
 */
@WebServlet("/kartAltaController")
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo=request.getParameter("tipo");
	    String estado=request.getParameter("estado");
       kartstat ks;
	   if(tipo!=null && !tipo.equals("")){
		   if(estado.equals(kartstat.disponible.toString())){
			   ks=kartstat.disponible;
		       else if(estado.equals(kartstat.mantenimiento.toString())) {
					   ks=kartstat.mantenimiento;

		       }else{
				   ks=kartstat.reservado;
		       }
	        }
		   GestorPistas gk=new GestorPistas();
		   gk.crearKart(null, tipo, ks);
		   if(sw){
		   	request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
		   }else{
	    	PrintWriter out=response.getWriter();
	    	out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
	       }
	   }
	}
}
