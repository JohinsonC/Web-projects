import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Employee")
public class Employee extends HttpServlet{
Connection con;
int row;
PreparedStatement stmt;
public void doPost(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
{
rsp.setContentType("text/html");
PrintWriter out=rsp.getWriter();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		stmt=con.prepareStatement("Insert into employees(ID,Name,Password,Email,Country) Values(?,?,?,?,?)");
		String ID=req.getParameter("ID");
		String Name=req.getParameter("Name");
		String Password=req.getParameter("Password");
		String Email=req.getParameter("Email");
		String Country=req.getParameter("Country");
		stmt.setString(1,ID);
		stmt.setString(2,Name);
		stmt.setString(3,Password);
		stmt.setString(4,Email);
		stmt.setString(5,Country);
		row=stmt.executeUpdate();
		out.println("<font color='green'>Record Added</font>");
		out.println("<p><a href=\"register.html\">OK</a></p>");
		con.close();
	
	} catch (ClassNotFoundException | SQLException e) {
		out.println("<font color='red'>Record failed</font>");
	}
	
	;	
}

}