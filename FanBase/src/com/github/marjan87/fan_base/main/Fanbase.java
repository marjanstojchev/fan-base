package com.github.marjan87.fan_base.main;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Fanbase
 */
@WebServlet("/Fanbase")
public class Fanbase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement statement=null;
	ResultSet rs=null;
	 Blob image = null;
	 byte[ ] imgData = null ;
	 JDBCConfiguration database = new JDBCConfiguration();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fanbase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		database.connectToDatabase();
	
		 
		try
		{
		statement=database.getConnection().createStatement();
		String query="Select Username, Image_Name, Image from Images";
		rs =statement.executeQuery(query);
		while(rs.next())
		{
	
		image = rs.getBlob("Image");
		imgData = image.getBytes(1,(int)image.length());

		}

		// display the image

		response.setContentType("image/gif");

		OutputStream o = response.getOutputStream();

		o.write(imgData);

		o.flush();

		o.close();
			
			} catch (Exception e)
			{
				e.printStackTrace();
			} finally {
				try{
					rs.close();
					statement.close();
					database.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
