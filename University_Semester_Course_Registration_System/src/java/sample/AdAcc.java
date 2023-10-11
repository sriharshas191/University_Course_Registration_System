package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class AdAcc extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        String us=req.getParameter("rno");
        String pwd=req.getParameter("pas");
        PrintWriter out=res.getWriter();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            st.executeUpdate("insert into login values('"+us+"','"+pwd+"')");
            out.println("<h1>Account Created Successfully!</h1>");
        }
        catch(Exception e)
        {
            out.println(e);
        }
        
    }

}
