import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/Forgetpass")
public class Forgetpass extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
	{
	rsp.setContentType("text/html");
	PrintWriter out=rsp.getWriter();
	try {
		out.println("<style>");
		out.println("body{background color: Black;"
				+ "top:40%;"
				+ "left:40%;"
				+ "bottom:25%;"
				+ "position:absolute;"
				+ "font-size:large;}");
		out.println("</style>");
	out.println("<font color='green'><b>Username:Johin</b></font><br><br>");
	out.println("<font color='green'><b>Password:12345</b></font>");
     }
catch(Exception e) {
	out.println("<font color='red'>Record failed</font>");
}
	}}