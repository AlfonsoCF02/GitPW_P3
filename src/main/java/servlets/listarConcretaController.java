package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.reserva.GestorReservas;

/**
 * Servlet implementation class listarConcretaController
 */
public class listarConcretaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarConcretaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/listarReservasConcretasFormView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fechaux1=request.getParameter("fech1");
		String fechaux2=request.getParameter("fech2");
		String email=request.getParameter("email");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = null;
		try {
			parsed = format.parse(fechaux1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        java.sql.Date fech1 = new java.sql.Date(parsed.getTime());
        try {
			parsed = format.parse(fechaux2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date fech2 = new java.sql.Date(parsed.getTime());
		if(!fech2.after(fech1)) {
			request.getRequestDispatcher("errorListarConcreta1.jsp").forward(request, response);
	    	return;
	    }
		GestorReservas g=new GestorReservas();
		ArrayList<String> res=new ArrayList<String>();
		try {
			res=g.verResConcreta(fech1, fech2, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listado", res);
		request.getRequestDispatcher("/mvc/view/listarReservasConcretasView.jsp").forward(request, response);
	}

}
