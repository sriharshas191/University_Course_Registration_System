package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class New1 extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=null;
        PrintWriter out = res.getWriter();
        String us=req.getParameter("Username");
        String pw=req.getParameter("password");
        String user = null,pwd = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from login where usn="+"'"+us+"'");
            while(rs.next())
            {
                user=rs.getString(1);
                pwd=rs.getString(2);
            }
            if(us.equals(user))
            {
                if(pw.equals(pwd))
                {
                    //out.println("authorized user");
                    //rd=req.getRequestDispatcher("home.html");
                    //rd.forward(req, res);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    res.sendRedirect("Home");
                }
                else
                {
                    //out.println("unauthorized user");
                    out.println("<center><h1 style="+"color:red;background-color:black;"+">Incorrect Password!</h1></center>");
                    rd=req.getRequestDispatcher("login.html");
                    rd.include(req, res);
                }
            }
            else
            {
                //out.println("unauthorized user");
                out.println("<center><h1 style="+"color:red;background-color:black;"+">Invalid Username!</h1></center>");
                rd=req.getRequestDispatcher("login.html");
                    rd.include(req, res);
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
