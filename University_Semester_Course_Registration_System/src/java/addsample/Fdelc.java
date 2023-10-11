package addsample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Fdelc extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        String snu=req.getParameter("regdno");
        String bn=req.getParameter("bnch");
        String user = null,pwd = null;
        
        PrintWriter out=res.getWriter();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            st.executeUpdate("delete from course where cid='"+snu+"' and branch='"+bn+"'");
            out.println("<h1>course Deleted Successfully!</h1>");
        }   
        catch(Exception e)
        {
            out.println(e);
        }
        
    }
}
