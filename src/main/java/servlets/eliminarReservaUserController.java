package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.reserva.GestorReservas;

/**
 * Servlet implementation class eliminarReservaUserController
 */
public class eliminarReservaUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarReservaUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/eliminarReservaUserView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status=0;
		String id=request.getParameter("reserva");
		String email=request.getParameter("email");
		GestorReservas rd=new GestorReservas();
		try {
            Integer.parseInt(id);
            
        } catch (NumberFormatException excepcion) {
        	request.getRequestDispatcher("errorEliminar3.jsp").forward(request, response);
			return;
        }
		try {
			status=rd.eliminarReserva(Integer.parseInt(id),email);
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
