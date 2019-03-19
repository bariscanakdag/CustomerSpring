package com.baris.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="hbstudent";
		String pass="hbstudent";
		
		String jdbc="jdbc:mysql://localhost:3306/web_customer_tracker?useSLL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out=response.getWriter();
			out.println("Connection database : " + jdbc);
			Class.forName(driver);
			Connection myConnection =DriverManager.getConnection(jdbc,user,pass);			
			out.println("Succes");
			myConnection.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
