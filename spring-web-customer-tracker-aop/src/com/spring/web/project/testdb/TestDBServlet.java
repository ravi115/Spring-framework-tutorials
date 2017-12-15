package com.spring.web.project.testdb;

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
 * Servlet implementation class TestDBServlet
 */
@WebServlet(description = "This servlet is just to test the database connection", urlPatterns = { "/TestDBServlet" })
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variable
		final String userName = "root";
		final String password = "root";
		
		final String jdbcURL = "jdbc:mysql://localhost:3360/web_customer_tracker?useSSL=false";
		final String driver = "com.mysql.cj.jdbc.Driver";
		
		//get connection to database
		try {
			
			//keep ready writer 
			PrintWriter out = response.getWriter();
			out.println("connecting to database......");
			
			//load the driver
			Class.forName(driver);
			
			//connect to the database
			Connection conn = DriverManager.getConnection(jdbcURL,userName,password);
			
			out.println("success!!!");
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
