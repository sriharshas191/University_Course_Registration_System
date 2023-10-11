package addsample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class FaddFac extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        String sna=req.getParameter("dname");
        String snu=req.getParameter("demail");
        String bn=req.getParameter("bnch");
        String cat=req.getParameter("cat");
        String user = null,pwd = null;
        
        PrintWriter out=res.getWriter();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            st.executeUpdate("insert into adm values('"+snu+"','"+sna+"','"+bn+"','"+cat+"')");
            out.println("<h1>Faculty Added Successfully!</h1>");
        }   
        catch(Exception e)
        {
            out.println(e);
        }
        
    }
}
