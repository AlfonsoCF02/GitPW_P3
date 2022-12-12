package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.reserva.GestorReservas;

/**
 * Servlet implementation class altaBonoController
 */
public class altaBonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaBonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/altaBonoView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo=request.getParameter("tipo");
		String email=request.getParameter("email");
		if(tipo.equals("child")) {
			
		}else if(tipo.equals("adult")) {
			
		}else if(tipo.equals("family")) {
			
		}else {
			request.getRequestDispatcher("errorBono1.jsp").forward(request, response);
			return;
		}
		GestorReservas gr=new GestorReservas();
		gr.altaBono(email, tipo);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
