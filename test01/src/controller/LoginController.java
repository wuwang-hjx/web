package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.security.auth.message.AuthStatus;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import dao.UserDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sw = request.getParameter("sw");
		UserDao UD = new UserDao();
		//System.out.println("<------------------------------------>"+sw);
		
		if(sw.equals("init")) {
			String ts = request.getParameter("ts");
			if(ts.equals("f")) {
				response.setContentType("text/html;charset=utf-8");
				String result = UD.getname(request,response);
				PrintWriter pw = response.getWriter();
				pw.append(result);
				pw.close();		
			}else {
				UD.userexit(request,response);
			}
			
		}else {

			response.setContentType("application/json;charset=utf-8");	
			String result = "";
			try {
				result = UD.userauth(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
			PrintWriter pw = response.getWriter();
			pw.append(result);
			pw.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
