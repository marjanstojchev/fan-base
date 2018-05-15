package com.github.marjan87.fan_base.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConfiguration {
 private String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
 private String DATABASE_URL="jdbc:mysql://localhost/fanbase";
 private String USER_NAME="root";
 private String PASSWORD="marjan";
 
 Connection connection = null;
// Statement statement = null;
// ResultSet resultSet =null;
// 
// public void readFromDatabase() {
//	 try {
//	  statement = connection.createStatement();
//	  String sqlCommand ="Select * from Users";
//	resultSet=statement.executeQuery(sqlCommand);
//		  
//		  while (resultSet.next()) {
//			  int id = resultSet.getInt("User_Id");
//			  String name =resultSet.getString("Username");
//			  String password = resultSet.getString("User_Password");
//			  
//			  System.out.println("id: " + id+ ", name: " +name+", password: "+password+ "."); 
//		  } 
//	 } catch (Exception e) {
//			  e.printStackTrace();
//		  } finally {
//			  try {
//			  resultSet.close();
//			  statement.close();
//			  statement.close();
//			  } catch (Exception e) {
//				  e.printStackTrace();
//			  }
//		  }
		  
// }

 public Connection getConnection() {
	 return connection;
 }
 public void connectToDatabase() {

  try {
	  Class.forName(JDBC_DRIVER);
	  connection = DriverManager.getConnection(DATABASE_URL,USER_NAME,PASSWORD);
	  System.out.println("Conected!");
  } catch (Exception e) {
	  e.printStackTrace();
	  }
 }

public void closeConnection()
	{
		try
		{
			if (connection != null)
			{
				if (!connection.isClosed())
				{
					connection.close();
				}
			}
		
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		
		}
	}
 
// public static void main(String[] args) {
//	JDBCConfiguration database = new JDBCConfiguration();
//	database.connectToDatabase();
//	database.readFromDatabase();
//	database.closeConnection();
//	
//	
//}

}
