package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Enroll extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        /*String sna=session.getAttribute("sna").toString();
        String snu=session.getAttribute("snu").toString();
        String bn=session.getAttribute("bn").toString();
        String ye=session.getAttribute("ye").toString();
        String se=session.getAttribute("se").toString();*/
        String user = null,pwd = null;
        int n = 0;
        PrintWriter out=res.getWriter();
        String us=session.getAttribute("user").toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            /*ResultSet rs= st.executeQuery("select count(cid) from course where branch="+"'"+bn+"'"+"and years="+"'"+ye+"'"+"and sem="+"'"+se+"'");
            while(rs.next())
            {
                n=Integer.parseInt(rs.getString(1));
            }
            session.setAttribute("nco",n);*/
            out.println("<html>\n" +
"<head>\n" +
"<title> course </title>\n" +
"<style>\n" +
"body{\n" +
"margin:0;\n" +
"padding:0;\n" +
"font-family:'Raleway',sans-serif\n" +
"}\n" +
"h1{\n" +
"text-decoration:underline;\n" +
"text-decoration-color:green;\n" +
"}\n" +
"#first{\n" +
"width:400px;\n" +
"height:400px;\n" +
"box-shadow:0 0 15px rgba(14,41,57,0.12),0 2px 5px rgba(14,41,57,0.44),inset 0 -1px 2px rgba(14,41,57,0.15);\n" +
"float:left;\n" +
"padding:10px 50px 0;\n" +
"background-color:greenyellow;\n" +
"margin:2% 30%;\n" +
"border-radius:5px\n" +
"}\n" +
".one{\n" +
"display:block;\n" +
"margin-left:15px;\n" +
"margin-top:10px\n" +
"}\n" +
"table{\n" +
"border-collapse:collapse;\n" +
"width:100%;\n" +
"}\n" +
"th,td{\n" +
"padding:8px;\n" +
"text-aling:center;\n" +
"}\n" +
".submit{\n" +
"width:100px;\n" +
"margin-left:133px;\n" +
"padding:10px;\n" +
"margin-top:20px;\n" +
"background:linear-gradient(#A4A4A4,#424242);\n" +
"color:#fff;\n" +
"font-weight:700\n" +
"}\n" +
".submit:hover{\n" +
"background:linear-gradient(#424242,#A4A4A4)\n" +
"}\n" +
"</style>\n" +
"</head>");
            out.println("<body>\n" +
"<div id=\"first\">\n" +
"<form action=\"Subm\" method=\"get\">\n" +
"<h1><b>REGISTERED COURSES </b></h1>\n" +
"<label class=\"one\">\n" +
"<span><big><b>REGISTRATION NUMBER :</b></big></span>&nbsp;" +
"<big><big><b style=\"color:red;\">"+us+"</b></big></big>\n" +
"</label>\n" +
"<br><br>\n" +
"<table border=\"1\">\n" +
"<tr>\n" +
"<th><b><center>COURSE ID</center></b></th>\n" +
"<th><b><center>COURSE NAME</center></b></th>\n"+
"</tr>");
            ResultSet qs= st.executeQuery("select *from course where cid in(select cid from regis where sid='"+us+"')");
            while(qs.next())
            {
                out.println("<tr>\n" +
"<td><b><center>"+qs.getString(1)+"</center></b></td>\n" +
"<td><b><center>"+qs.getString(2)+"</center></b></td>\n"  +
"<tr>");
            }
            out.println("</table>\n" +
"</form>\n" +
"</div>\n" +
"</body>\n" +
"</html>");
        }
        catch(Exception e)
        {
            out.println(e);
        }
        
    }
}
