package com.github.marjan87.fan_base.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       private String USERNAME="marjanstojchev";
//       private String PASSWORD="marjan";
private JDBCConfiguration database = new JDBCConfiguration();
private ResultSet result;
private Statement statement;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		
		database.connectToDatabase();
		try {
		statement = database.getConnection().createStatement();
		String sqlCommand = "Select Username, User_Password from Users where Username = '" + inputUsername + "'"
				+ " and User_Password ='" + inputPassword + "'";
		result = statement.executeQuery(sqlCommand);

			if(result.next()) {
				session.setAttribute("username", inputUsername);
				response.sendRedirect(response.encodeRedirectURL("index.jsp"));
				} else {
					response.sendRedirect(response.encodeRedirectURL("login_fail.jsp"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					result.close();
					statement.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		database.closeConnection();
//		userInfo.userQuery("Mariano", "Bombarda");
//		String username = userInfo.getUsers().get(0).getUsername();
//		String password = userInfo.getUsers().get(0).getPassword();

//	if (password.equals(PASSWORD) && username.equals(USERNAME))
	
			
			
	
	
	
//	PrintWriter out = response.getWriter();
//
//	out.println("<html><body><span>Welcome<span>&nbsp;<strong>"
//			+ userId + "</strong></body></html>");
	}

}
