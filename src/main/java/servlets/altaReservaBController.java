package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.pista.GestorPistas;
import business.pista.diff;
import business.reserva.GestorReservas;
import business.reserva.ModalidadReservaBono;
import business.reserva.ModalidadReservaIndividual;
import data.BonoDAO;

/**
 * Servlet implementation class altaBonoController
 */
public class altaReservaBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaReservaBController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestorPistas gp = new GestorPistas();
		ArrayList<String> pistas=new ArrayList<String>();
		try {
			pistas=gp.listarPistas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BonoDAO b=new BonoDAO();
		String mail=request.getParameter("email");
		diff tipo1 = diff.child;
		diff tipo2 = diff.adult;
		diff tipo3 = diff.family;
		ArrayList<String> bonosC=b.listarBonos(mail, tipo1.toString());
		ArrayList<String> bonosA=b.listarBonos(mail, tipo2.toString());
		ArrayList<String> bonosF=b.listarBonos(mail, tipo3.toString());
		request.setAttribute("bonosC", bonosC);
		request.setAttribute("bonosA", bonosA);
		request.setAttribute("bonosF", bonosF);
		request.setAttribute("pistas", pistas);		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/altaReservaBView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email=request.getParameter("email");
			int nbono=Integer.parseInt(request.getParameter("nbono"));
			String fecha_str=request.getParameter("fecha");
			SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = formatFecha.parse(fecha_str);
			Date now=new Date();
			if(fecha.getTime()<now.getTime()) {
				request.getRequestDispatcher("errorFecha.jsp").forward(request, response);
				return;
			}
            java.sql.Date fechares = new java.sql.Date(fecha.getTime());
			String hora_str=request.getParameter("hora");
			hora_str+=":00";
			SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
			Date hora = formatHora.parse(hora_str);
			java.sql.Date horares = new java.sql.Date(hora.getTime());
			int duracion=Integer.parseInt(request.getParameter("duracion"));
			String pista=request.getParameter("nombrePista");
			int nninios=Integer.parseInt(request.getParameter("nninios"));
			int nadultos=Integer.parseInt(request.getParameter("nadultos"));	
			
			if(duracion==60) {
				
			}else if(duracion==90) {
				
			}else if(duracion==120) {
				
			}else {
				request.getRequestDispatcher("errorBono1.jsp").forward(request, response);
				return;
			}
			GestorReservas gr=new GestorReservas();
			ModalidadReservaBono b = new ModalidadReservaBono();
			int res = gr.reservaIndividual(b,nbono, email, horares, fechares, duracion, pista, nninios, nadultos);
			
			request.setAttribute("res", res);
			request.getRequestDispatcher("comprobarRB.jsp").forward(request, response);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception nfe) {
		    System.out.println(nfe);
		}
	}

}
