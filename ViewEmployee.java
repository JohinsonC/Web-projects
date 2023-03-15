import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet{
Connection con;
ResultSet row;
Statement stmt;
public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
{
rsp.setContentType("text/html");
PrintWriter out=rsp.getWriter();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		stmt=con.createStatement();
		row=stmt.executeQuery("Select * from employees");
		out.println("<p><a href=\"register.html\">Add new Employee</a></p>");
		out.println("<th colspan=\"4\"><h1>Employee List</h1></th>");
		out.println("<table cellspacing='0'width='350px'border='1'>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Password</th>");
		out.println("<th>Email</th>");
		out.println("<th>Country</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		while(row.next())
		{
			out.println("<tr>");
			out.println("<td>"+row.getString(1)+"</td>");
			out.println("<td>"+row.getString(2)+"</td>");
			out.println("<td>"+row.getString(3)+"</td>");
			out.println("<td>"+row.getString(4)+"</td>");
			out.println("<td>"+row.getString(5)+"</td>");
			out.println("<td>"+"<p><a href='Editpage?ID="+row.getString(1)+"'>Edit</a></p>"+"</td>");
			out.println("<td>"+"<p><a href='Deletepage?ID="+row.getString(1)+"'>Delete</a></p>"+"</td>");
			out.println("</tr>");
		}	
		out.println("</table>");
		con.close();
	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		out.println("<font color='red'>Record failed</font>");
	}
}
}