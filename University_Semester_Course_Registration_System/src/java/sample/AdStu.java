package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class AdStu extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        String sna=req.getParameter("sna");
        String snu=req.getParameter("snu");
        String bn=req.getParameter("branch");
        String ye=req.getParameter("year");
        String se=req.getParameter("sem");
        String user = null,pwd = null;
        
        PrintWriter out=res.getWriter();
//        String us=session.getAttribute("user").toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
//            out.println(sna+"\n"+snu+"\n"+bn+"\n"+ye+"\n"+se);
            st.executeUpdate("insert into stu values('"+snu+"','"+sna+"',"+ye+","+se+",'"+bn+"')");
//                    insert into stu values('201FA04036','Muhammad Vasim',2,2,'CSE');
            out.println("<h1>Student Added Successfully!</h1>");
        }   
        catch(Exception e)
        {
            out.println(e);
        }
        
    }
}
