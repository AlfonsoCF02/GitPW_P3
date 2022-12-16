package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.pista.GestorPistas;
import data.KartDAO;

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
		KartDAO kd = new KartDAO();
		ArrayList<String> karts=new ArrayList<String>();
		try {
			karts=kd.listarKarts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GestorPistas gp = new GestorPistas();
		ArrayList<String> pistas=new ArrayList<String>();
		try {
			pistas=gp.listarPistas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pistas", pistas);		
		request.setAttribute("karts", karts);
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
            Integer.parseInt(kart);
            
        } catch (NumberFormatException excepcion) {
        	request.getRequestDispatcher("errorAsociar4.jsp").forward(request, response);
			return;
        }
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
	    }else if(status==-5) {
	    	request.getRequestDispatcher("errorAsociar5.jsp").forward(request, response);
			return;
	    }
	}

}
