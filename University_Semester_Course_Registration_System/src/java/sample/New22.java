package sample;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class New22 extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=null;
        PrintWriter out = res.getWriter();
        String us=req.getParameter("usna");
        String pw=req.getParameter("cp");
        String npw=req.getParameter("np");
        String user = null,pwd = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from alogin where usn="+"'"+us+"'");
            while(rs.next())
            {
                user=rs.getString(1);
                pwd=rs.getString(2);
            }
            if(us.equals(user))
            {
                if(pw.equals(pwd))
                {
                    /*out.println("authorized user");*/
                    st.executeUpdate("update alogin set pwd="+"'"+npw+"'"+" where usn="+"'"+us+"'");
                    rd=req.getRequestDispatcher("alogin.html");
                    rd.forward(req, res);
                }
                else
                {
                    out.println("<center><h1 style="+"color:red;background-color:black;"+">Current Password is incorrect!</h1></center>");
                    rd=req.getRequestDispatcher("areset.html");
                    rd.include(req, res);
                    //out.println("unauthorized user");
                }
            }
            else
            {
                out.println("<center><h1 style="+"color:red;background-color:black;"+">Invalid Username!</h1></center>");
                rd=req.getRequestDispatcher("areset.html");
                    rd.include(req, res);
            }            
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
