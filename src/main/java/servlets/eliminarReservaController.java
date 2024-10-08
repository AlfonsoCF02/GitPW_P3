package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.reserva.GestorReservas;
import data.ReservaChildDAO;

/**
 * Servlet implementation class eliminarReservaController
 */
public class eliminarReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarReservaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestorReservas g=new GestorReservas();
		ArrayList<String> res=new ArrayList<String>();
		try {
			res=g.verResFuturas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("reservas", res);		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/eliminarReservaView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status=0;
		String id=request.getParameter("reserva");
		GestorReservas rd=new GestorReservas();
		try {
            Integer.parseInt(id);
            
        } catch (NumberFormatException excepcion) {
        	request.getRequestDispatcher("errorEliminar3.jsp").forward(request, response);
			return;
        }
		try {
			status=rd.eliminarReserva(Integer.parseInt(id));
			if(status==0) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			if(status==-1){
				request.getRequestDispatcher("errorEliminar1.jsp").forward(request, response);
				return;
			}
			if(status==-3){
				request.getRequestDispatcher("errorEliminar2.jsp").forward(request, response);
				return;
			}if(status==-2) {
				request.getRequestDispatcher("errorEliminar4.jsp").forward(request, response);
				return;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
