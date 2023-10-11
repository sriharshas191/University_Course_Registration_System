package addsample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Acheck extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=null;
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        String us=session.getAttribute("user").toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from adm where aid="+"'"+us+"'");
            String f=null;
            while(rs.next())
            {
                f=rs.getString("category");
            } 
            if("m".equals(f))
            {
                res.sendRedirect("MAhome");
            }
            else if("a".equals(f))
            {
                res.sendRedirect("Ahome");
            }
                        
        }
        catch(Exception e)
        {
            out.println(e);
            
        }
        //out.println("<h1>Registered Successfully</h1>");
    }
}
