package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class NewServlet extends HttpServlet 
{
    String iusn,ipas;
    public void init(ServletConfig co) throws ServletException
    {
        iusn=co.getInitParameter("user");
        ipas=co.getInitParameter("pass");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter()) 
        {
            String usn=req.getParameter("us");
            String pas=req.getParameter("pwd");  
           /* out.println("<h1>"+iusn+"</h1>");
            out.println("<h1>"+ipas+"</h1>");
            out.println("<h1>"+usn+"</h1>");
            out.println("<h1>"+pas+"</h1>");*/
            if(usn.equals(iusn))
            {
                //out.println("<h1>"+"passed"+"</h1>");
                if(pas.equals(ipas))
                {
                    out.println("<h1>"+"authorized user"+"</h1>");
                }
                //out.println("<h1>"+"passed"+"</h1>");
                else
                {
                    //out.println("<h1>"+"passed"+"</h1>");
                    out.println("<h1>"+"unauthorized user"+"</h1>");
                }
            }
            else
            {
                out.println("<h1>"+"unauthorized user"+"</h1>");
            }
        }
    }
}
