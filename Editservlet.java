import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Editservlet")
public class Editservlet extends HttpServlet {
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
	    String a=req.getParameter("ID");
	    String b=req.getParameter("Name");
	    String c=req.getParameter("Password");
	    String d=req.getParameter("Email");
	    String e=req.getParameter("Country");
	    stmt=con.prepareStatement("Update employees set Name=?,Password=?,Email=?,Country=? where ID=?");
	    stmt.setString(1,b);
	    stmt.setString(2,c);
	    stmt.setString(3,d);
	    stmt.setString(4,e);
	    stmt.setString(5,a);
	    row=stmt.executeUpdate();
	    out.println("<text align='center'font color='Green'><b>Updated Successfully</b></font>");
	    out.println("<p><a href=\"ViewEmployee\">OK</a></p>");
	    con.close();
	    } 
	catch (ClassNotFoundException | SQLException e) 
	{
		out.println("<font color='red'>Record failed</font>");
	}

	;	
	}

	}
