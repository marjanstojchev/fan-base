package com.github.marjan87.fan_base.main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCConfiguration database = new JDBCConfiguration();
	Statement statement;
	ResultSet result;
	Statement insertStatement;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		request.setAttribute("username", inputUsername);
		request.setAttribute("password", inputPassword);
		int fail;
		
		database.connectToDatabase();
		try {
		statement = database.getConnection().createStatement();
		String sqlCommand = "Select Username from Users where Username = '" + inputUsername + "'";
		result = statement.executeQuery(sqlCommand);

			if(result.next()) {
				fail=1;
				request.setAttribute("fail", fail);
//				response.sendRedirect(response.encodeRedirectURL("register_fail.jsp"));
				request.getRequestDispatcher("register_result.jsp").forward(request, response);
				} else {
					fail=0;
					request.setAttribute("fail", fail);
					insertStatement = database.getConnection().createStatement();
					String insert = "Insert into Users (Username, User_Password) Values ('" + inputUsername + "', '" + inputPassword+"')" ;
					  insertStatement.executeUpdate(insert);
//					response.sendRedirect(response.encodeRedirectURL("register_fail.jsp"));
					request.getRequestDispatcher("register_result.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					result.close();
					statement.close();
					insertStatement.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		database.closeConnection();
	}

}
