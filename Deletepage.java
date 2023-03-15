import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Deletepage")
public class Deletepage extends HttpServlet {
	Connection con;
	int row;
	PreparedStatement stmt;
	public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
	{
	rsp.setContentType("text/html");
	PrintWriter out=rsp.getWriter();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	    String a=req.getParameter("ID"); 
	    stmt=con.prepareStatement("Delete from employees where ID=?");
	    stmt.setString(1,a);
	    row=stmt.executeUpdate();
	    out.println("<font color='Green'>Deleted Successfully</font>");
	    out.println("<p><a href=\"ViewEmployee\">OK</a></p>");
	    con.close();
	    } 
	catch (ClassNotFoundException | SQLException e) 
	{
		out.println("<font color='red'>Record failed</font>");
	}
}
}
