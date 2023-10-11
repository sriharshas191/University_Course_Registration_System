package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
//import java.sql.*;

public class Regi extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        //RequestDispatcher rd=null;
        //PrintWriter out = res.getWriter();
        String sna=req.getParameter("dname");
        String snu=req.getParameter("dnum");
        String bn=req.getParameter("branch");
        String ye=req.getParameter("year");
        String se=req.getParameter("sem");
        HttpSession session = req.getSession();
        session.setAttribute("sna", sna);
        session.setAttribute("snu", snu);
        session.setAttribute("bn", bn);
        session.setAttribute("ye", ye);
        session.setAttribute("se", se);
        res.sendRedirect("Display");        
    }
}
