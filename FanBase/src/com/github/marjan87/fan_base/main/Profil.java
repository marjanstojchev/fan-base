package com.github.marjan87.fan_base.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Profil
 */

@WebServlet("/Profil")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = "D:/Uploads"
)
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCConfiguration database = new JDBCConfiguration();
	PreparedStatement statement;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String description = request.getParameter("description");
		String name = request.getParameter("name");
		String username = null;
		InputStream inputStream = null; // input stream of the upload file

		HttpSession session = request.getSession();
		if (session != null && session.isNew() == false) {
			username = (String) session.getAttribute("username");

			database.connectToDatabase();

			// obtains the upload file part in this multipart request
			Part filePart = request.getPart("photo");
			if (filePart != null) {
				// prints out some information for debugging
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());
				System.out.println(username);
				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
			}

			String message = null; // message will be sent back to client

			try {

				// constructs SQL statement
				String query = "INSERT INTO Images (Username, Image_Name, Description, Image) values (?, ?, ?, ?)";
//				String query = "INSERT INTO Test (Image) values (?)";
				statement = database.getConnection().prepareStatement(query);
				if (username != null) {
					statement.setString(1, username);
				}
				statement.setString(2, name);
				statement.setString(3, description);

				if (inputStream != null) {
					// fetches input stream of the upload file for the blob column
					statement.setBlob(4, inputStream);
				}

				// sends the statement to the database server
				int row = statement.executeUpdate();
				if (row > 0) {
					message = "File uploaded and saved into database";
				}
			} catch (SQLException ex) {
				message = "ERROR: " + ex.getMessage();
				ex.printStackTrace();
			} finally {

				try {
					statement.close();
					database.closeConnection();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
