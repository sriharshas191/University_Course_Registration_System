package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class PayCheck extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=null;
        PrintWriter out = res.getWriter();
        String cs[] =req.getParameterValues("course");
        HttpSession session = req.getSession();
        String us=session.getAttribute("user").toString();
        String yea=session.getAttribute("year").toString();
        String sem=session.getAttribute("sem").toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from payment where sid="+"'"+us+"' and yea="+yea+" and sem="+sem);
            int f=0;
            while(rs.next())
            {
              f=1;  
            } 
            if(f==0)
            {
                out.println("<html><body><h1>Please Pay the FEE</h1>\n" +
"    <a href=\"Home\"><input type=\"submit\" value=\"Return To Home\"></a>\n" +
"</body>\n" +
"\n" +
"</html>");
            }
            else
            {
                res.sendRedirect("register.html");
            }
                        
        }
        catch(Exception e)
        {
            out.println(e);
            
        }
        //out.println("<h1>Registered Successfully</h1>");
    }
}
