
package sample;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Home extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String us=session.getAttribute("user").toString();
        String sna = null,yea = null,bnch = null,sem = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from stu where sid="+"'"+us+"'");
            while(rs.next())
            {
                sna=rs.getString(2);
                yea=rs.getString(3);
                sem=rs.getString(4);
                bnch=rs.getString(5);
                session.setAttribute("sem",sem);
                session.setAttribute("year",yea);
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset=\"utf-8\" ? <meta name=\"viewport\" content=\"width=device-width\" initial-scale=\"1.0\">\n");
        out.println("<title>Home | Course Registration</title>");
        out.println("<style>\n" +
"        h1 {\n" +
"            background-color: rgb(233, 51, 15);\n" +
"            text-align: center;\n" +
"            align-items: top;\n" +
"            font-size: 50px;\n" +
"            height: 14vh;\n" +
"        }\n" +
"\n" +
"        body {\n" +
"            background: url(bg2.jpg);\n" +
"            padding-left: 0rem;\n" +
"            overflow: hidden;\n" +
"        }\n" +
"\n" +
"        header {\n" +
"            position: fixed;\n" +
"            top: 5;\n" +
"            left: 5;\n" +
"            z-index: 1000;\n" +
"            height: 70%;\n" +
"            width: 25rem;\n" +
"            background: #f70ed4a4;\n" +
"            display: flex;\n" +
"            align-items: top;\n" +
"\n" +
"            justify-content: center;\n" +
"            flex-flow: column;\n" +
"            text-align: center;\n" +
"        }\n" +
"\n" +
"        header h2 {\n" +
"            text-align: center;\n" +
"            font-size: 30px;\n" +
"            color: #fbff00;\n" +
"        }\n" +
"\n" +
"        header .navbar {\n" +
"            width: 100%;\n" +
"        }\n" +
"\n" +
"        header .navbar h3 {\n" +
"            display: block;\n" +
"            padding: 1rem;\n" +
"            margin: 1.5rem 0;\n" +
"            background: #fbff00;\n" +
"            color: rgb(240, 10, 10);\n" +
"            font-size: 1.8rem;\n" +
"            border-radius: 5rem;\n" +
"        }\n" +
"\n" +
"        body .container .b1 img {\n" +
"            position: relative;\n" +
"            top: 160px;\n" +
"            left: -150px;\n" +
"            right: 0;\n" +
"            width: 200px;\n" +
"            height: 200px;\n" +
"            ;\n" +
"            font-size: 30px;\n" +
"            padding-left: 30rem;\n" +
"            color: rgb(6, 230, 35);\n" +
"        }\n" +
"\n" +
"        body .container .b2 img {\n" +
"            position: relative;\n" +
"            top: -50px;\n" +
"            left: 120px;\n" +
"            right: 0;\n" +
"            width: 200px;\n" +
"            height: 200px;\n" +
"            ;\n" +
"            font-size: 30px;\n" +
"            padding-left: 30rem;\n" +
"            color: rgb(6, 230, 35);\n" +
"        }\n" +
"\n" +
"        body .container .b3 img {\n" +
"            position: relative;\n" +
"            top: -320px;\n" +
"            left: 520px;\n" +
"            right: 0;\n" +
"            width: 200px;\n" +
"            height: 200px;\n" +
"            ;\n" +
"            font-size: 30px;\n" +
"            padding-left: 30rem;\n" +
"            color: rgb(6, 230, 35);\n" +
"        }\n" +
"\n" +
"        body .container .b4 img {\n" +
"            position: relative;\n" +
"            top: -520px;\n" +
"            left: 650px;\n" +
"            right: 0;\n" +
"            width: 200px;\n" +
"            height: 200px;\n" +
"            ;\n" +
"            font-size: 30px;\n" +
"            padding-left: 30rem;\n" +
"            color: rgb(6, 230, 35);\n" +
"        }\n" +
"\n" +
"        body .container .b1 a {\n" +
"            background-color: #05ff00;\n" +
"            position: relative;\n" +
"            text-align: center;\n" +
"            left: 490px;\n" +
"            top: -100px;\n" +
"            border: none;\n" +
"            font-size: 30px;\n" +
"            text-decoration: none;\n" +
"            padding: 8px 20px;\n" +
"            display: inline-block;\n" +
"        }\n" +
"\n" +
"        body .container .b2 a {\n" +
"            background-color: #05ff00;\n" +
"            position: relative;\n" +
"            left: 760px;\n" +
"            text-align: center;\n" +
"            top: -310px;\n" +
"            border: none;\n" +
"            font-size: 30px;\n" +
"            text-decoration: none;\n" +
"            padding: 8px 20px;\n" +
"            display: inline-block;\n" +
"        }\n" +
"\n" +
"        #hi {\n" +
"            background-color: #05ff00;\n" +
"            position: relative;\n" +
"            left: 1030px;\n" +
"            top: -360px;\n" +
"            font-size: 30px;\n" +
"            padding: 8px 20px;\n" +
"            text-align: center;\n" +
"            display: inline-block;\n" +
"        }\n" +
"\n" +
"        body .container .b4 a {\n" +
"            background-color: #05ff00;\n" +
"            position: relative;\n" +
"            left: 1290px;\n" +
"            top: -780px;\n" +
"            font-size: 30px;\n" +
"            padding: 8px 20px;\n" +
"            display: inline-block;\n" +
"            text-decoration: none;\n" +
"            text-align: center;\n" +
"        }\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"        html@media (max-width:1200px) {\n" +
"                {\n" +
"                font-size: 55%\n" +
"            }\n" +
"        }\n" +
"    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>COURSE REGISTRATION SYSTEM</h1>\n" +
"    <header>\n" +
"        <h2>Student Profile</h2>\n" +
"        <nav class=\"navbar\">\n" +
"            <h3>Name : "+sna+"</h1>\n" +
"                <h3>Reg No : "+us+"</h1>\n" +
"                    <h3>Year : "+yea+"</h1>\n" +
"                        <h3>Branch : "+bnch+"</h1>\n" +
"        </nav>\n" +
"    </header>\n" +
"    <div class=\"container\">\n" +
"        <div class=\"b1\">\n" +
"            <a href=\"payment1.html\" class=\"button\">Payment</a>\n" +
"            <!-- <button type=\"button\" id=\"h1\" onsubmit=\"stuhome.html\" \">Payment</button> -->\n" +
"            <img src=\"p3.jpg\" alt=\"image not found\">\n" +
"        </div>\n" +
"        <div class=\"b2\">\n" +
"            <a href=\"PayCheck\" class=\"button\">Register</a>\n" +
"            <!-- <button type=\"button\" id=\"h2\">Register</button> -->\n" +
"            <img src=\"p2.jpg\" alt=\"image not found\">\n" +
"        </div>\n" +
"\n" +
"        <div class=\"b3\">\n" +
"            <!-- <button type=\"button\" id=\"h3\">History</button> -->\n" +
"            <form action=\"Enroll\" name=\"his\">\n" +
"                <input type=\"submit\" name=\"hii\" value=\"History\" id=\"hi\">\n" +
"            </form>\n" +
"            <img src=\"h1.jpg\" alt=\"image not found\">\n" +
"        </div>\n" +
"        <div class=\"b4\">\n" +
"            <a href=\"index.html\" class=\"button\">Signout</a>\n" +
"            <!-- <button type=\"button\" id=\"h4\">Signout</button> -->\n" +
"            <img src=\"p4.jpg\" alt=\"image not found\">\n" +
"        </div>\n" +
"    </div>");
        out.println("</body>");
        out.println("</html>");
    }
}