package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Subm extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=null;
        PrintWriter out = res.getWriter();
        String cs[] =req.getParameterValues("course");
        HttpSession session = req.getSession();
        String us=session.getAttribute("user").toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st = con.createStatement();
            /*ResultSet rs= st.executeQuery("select * from regis where usn="+"'"+us+"'");
            while(rs.next())
            {
                user=rs.getString(1);
                pwd=rs.getString(2);
            }   */
            for(String s : cs)
            {
                String se="insert into regis values('"+us+"','"+s+"')";
                st.executeUpdate(se);
            }
            out.println("<html><body><h1>Registered Successfully</h1>\n" +
"    <a href=\"Home\"><input type=\"submit\" value=\"Return To Home\"></a>\n" +
"</body>\n" +
"\n" +
"</html>");
            
        }
        catch(Exception e)
        {
            out.println("<html><body><h1>Already Registered </h1>\n" +
"    <a href=\"Home\"><input type=\"submit\" value=\"Return To Home\"></a>\n" +
"</body>\n" +
"\n" +
"</html>");
            
        }
        //out.println("<h1>Registered Successfully</h1>");
    }
}
