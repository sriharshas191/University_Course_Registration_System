/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

/**
 *
 * @author Muhammad Vasim
 */
public class NewServlet1 extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://loaclhost:3306/Sample","root","allahmuhammad");
                out.println("Name");
                Statement st=con.createStatement();
                String s="create table sample(name char(10),roll int(10))";
                String in="insert into sample values('vasim',1)";
                String io="insert into sample values('fayaz',2)";
                st.executeUpdate(s);
                st.executeUpdate(in);
                st.executeUpdate(io);
                String dis="select *from sample";
                ResultSet rs=st.executeQuery(dis);
                while(rs.next())
                {
                    out.println("Name:"+rs.getString(1)+"rollno:"+rs.getInt(2));
                }
                con.close();
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
