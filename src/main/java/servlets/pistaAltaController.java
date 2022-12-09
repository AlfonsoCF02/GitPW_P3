package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.kart.kartstat;
import business.pista.GestorPistas;
import business.pista.diff;

/**
 * Servlet implementation class pistaAltaController
 */
public class pistaAltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pistaAltaController() {
        super();
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
		String nombre=request.getParameter("nombre");
		String disponible=request.getParameter("disponible");
		String dificultad=request.getParameter("dificultad");
		String maxkarts=request.getParameter("maxkarts");
		
		int s=0;
		diff d;
		boolean b;
		if(nombre!=null && !nombre.equals("")){
			if(dificultad.equals(diff.adult.toString())){
				d=diff.adult;
			}else if(dificultad.equals(diff.child.toString())) {
				d=diff.child;
			}else{
				d=diff.family;
			}
			if(disponible.equals("true")) {
				b=true;
			}else {
				b=false;
			}
			GestorPistas gk=new GestorPistas();
			try {
				s=gk.crearPista(nombre, b, Integer.parseInt(maxkarts), d);
				if(s==0) {
					request.setAttribute("estadocreacion", "Pista creada correctamente");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("errorALtaPista1.jsp").forward(request, response);

				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				PrintWriter out=response.getWriter();
				out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
