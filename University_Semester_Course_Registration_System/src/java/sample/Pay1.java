package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Pay1 extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        //RequestDispatcher rd=null;
        PrintWriter out = res.getWriter();
        String sna=req.getParameter("sna");
        String regno=req.getParameter("regno");
        String bn=req.getParameter("bn");
        String yea=req.getParameter("yea");
        String sem=req.getParameter("sem");        
        String acc=req.getParameter("account");        
        String code=req.getParameter("code");        
        String rup=req.getParameter("rupee");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st = con.createStatement();
            String ste="insert into payment(sid,sname,bnch,yea,sem,acc,ifsc,amo) values('"+regno+"','"+sna+"','"+bn+"',"+yea+","+sem+","+acc+",'"+code+"',"+rup+")";
            st.executeUpdate(ste);
            ResultSet rs = st.executeQuery("select last_insert_id()");
            int q = 0;
            while(rs.next())
            {
                q = rs.getInt("last_insert_id()");
            }
//            out.println("<h1>Paid successfully</h1>");
//            out.println(" <a href=\"Home\"><input type=\"submit\" value=\"Return To Home\"></a>\n" +
//"</body>\n" +
//"\n" +
//"</html>");
            out.println("<html>\n" +
"<head>\n" +
"<title> course </title>");
            out.println("<style>\n" +
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
"th,td{\n" +
"padding:8px;\n" +
"}\n" +
"</style>");
            out.println("</head>\n" +
"<body>\n" +
"<div id=\"first\">\n" +
"<br><br>\n" +
"<table border=\"2\">\n" +
"<center>\n" +
"<tr>\n" +
"<th colspan=\"2\"><h1>PAYMENT RECEIPT</h1></th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th><b>STUDENT NAME :</b></th>\n" +
"<td><b>"+sna+"</b></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<th><b>REGISTRATION NUMBER :</b></th>\n" +
"<td><b>"+regno+"</b></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<th><b>AMOUNT :</b></th>\n" +
"<td><b>"+rup+"</b></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<th><b>TRANSACTION NO :</b></th>\n" +
"<td><b>"+q+"</b></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<th colspan=\"2\"><a href=\"Home\"><button>Return To Home</button></a></th>\n" +
"</tr>\n" +
"</center>\n" +
"</table>\n" +
"</div>\n" +
"</body>\n" +
"</html>");
        }
        catch(Exception e)
        {
            out.println(e);
        }
//        res.sendRedirect("Display");        
    }
}
