import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Editpage")
public class Editpage extends HttpServlet{
Connection con;
ResultSet row;
PreparedStatement stmt;
public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
{
rsp.setContentType("text/html");
PrintWriter out=rsp.getWriter();

String EID=req.getParameter("ID");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	stmt=con.prepareStatement("Select * from Employees where ID=?");
	
	stmt.setString(1,EID);
	
	row=stmt.executeQuery();

	while(row.next())
    {
		out.println("<form action ='Editservlet'method='POST'>");
		out.println("<colspan=\"4\"><h1>Update Employee</h1>");
		out.println("<table cellspacing='0'width='300px'border='1'>");
	    out.println("<tr> <td>ID</td> <td><input type='text' name='ID'id='ID'value='"+row.getString(1)+"'readonly> </td> </tr>");
	    out.println("<tr> <td>Name</td> <td><input type='text' name='Name'id='Name'value='"+row.getString(2)+"'> </td> </tr>");
	    out.println("<tr> <td>Password</td> <td><input type='password' name='Password'id='Password'value='"+row.getString(3)+"'> </td> </tr>");
	    out.println("<tr> <td>Email</td> <td><input type='text' name='Email'id='Email'value='"+row.getString(4)+"'> </td> </tr>");
	    out.println("<tr> <td>Country</td> <td><input type='text' name='Country'id='Country'value='"+row.getString(5)+"'> </td> </tr>");
	    out.println("<tr> <td colspan='2'><input type='Submit' value='Edit & Save'></td> </tr>");
	    out.println("</table>");
	    out.println("</form>");
	    out.println("<p><a href=\"ViewEmployee\">Go to Employees List</a></p>");    
    }
	
   	con.close();
    } 
catch (ClassNotFoundException | SQLException e) 
{
	out.println("<font color='red'>Record failed</font>");
}
}
}