package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.pista.GestorPistas;

/**
 * Servlet implementation class asociarKartPistaController
 */
public class asociarKartPistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public asociarKartPistaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("mvc/view/asociarKartPistaView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kart=request.getParameter("kart");
	    String pista=request.getParameter("pista");
	    GestorPistas gp=new GestorPistas();
	    int status = 0;
	    try {
			status=gp.asociarKartPista(Integer.parseInt(kart), pista);
		} catch (NumberFormatException | FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if(status==0) {
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    }else if(status==-1) {
	    	request.setAttribute("kart", kart);
	    	request.getRequestDispatcher("errorAsociar1.jsp").forward(request, response);
			return;
	    }else if(status==-2) {
	    	request.getRequestDispatcher("errorAsociar2.jsp").forward(request, response);
			return;
	    }else if(status==-3) {
	    	request.getRequestDispatcher("errorAsociar3.jsp").forward(request, response);
			return;
	    }
	}

}
