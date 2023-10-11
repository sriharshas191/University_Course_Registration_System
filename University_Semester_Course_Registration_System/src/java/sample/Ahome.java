package sample;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Ahome extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String us=session.getAttribute("user").toString();
        String ana = null,yea = null,bnch = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","allahmuhammad");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from adm where aid="+"'"+us+"'");
            while(rs.next())
            {
                ana=rs.getString(2);
                bnch=rs.getString(3);
                session.setAttribute("abranch", bnch);
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>\n" +
"<meta charset=\"UTF-8\">\n" +
"  <title>Admin Home | Course Registration</title>\n" +
"  <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style2.css\">-->\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/brands.min.css\"/>\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\"/>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<title>Admin Home | Course Registration</title>");
        out.println("<style>\n" +
"body{\n" +
"       margin: 0;\n" +
"       padding: 0;\n" +
"       font-family: sans-serif;\n" +
"      }\n" +
".container{\n" +
"        position: relative;\n" +
"        width: 1100px;\n" +
"        height: 10px;\n" +
"        margin: 140px auto;\n" +
"}\n" +
"div.icon\n" +
"{\n" +
"background-color:MediumSeaGreen;\n" +
"}\n" +
".container .box{\n" +
"        position: relative;\n" +
"        width: calc(400px - 70px);\n" +
"        height: calc(300px - 30px);\n" +
"        background: #000;\n" +
"        float: left;\n" +
"        margin: 10px;\n" +
"        left:40px;\n" +
"        bottom:140px;\n" +
"        box-sizing: border-box;\n" +
"        overflow: hidden;\n" +
"        border-radius: 5px;\n" +
"}\n" +
".container .box .icon{\n" +
"     position: absolute;\n" +
"     top: 0;\n" +
"     left: 0;\n" +
"     width: 100%;\n" +
"     height: 100%;\n" +
"     background-color:MediumSeaGreen;\n" +
"     transition: 0.5s;\n" +
"     z-index: 1;\n" +
"}\n" +
".container .box:hover .icon{\n" +
"     top: 20px;\n" +
"     left: calc(50% - 40px);\n" +
"     width: 80px;\n" +
"     height: 80px;\n" +
"     border-radius: 50%;\n" +
"}\n" +
".container .box .icon .fa{\n" +
"     position: absolute;\n" +
"     top: 50%;\n" +
"     left: 50%;\n" +
"     transform: translate(-50%, -50%);\n" +
"     font-size: 80px;\n" +
"     transition: 0.5s;\n" +
"     color: #fff;\n" +
"}\n" +
".container .box:hover .icon .fa{\n" +
"   font-size:30px;\n" +
"}\n" +
".container .box .content{\n" +
"    position:absolute;\n" +
"    top:100%;\n" +
"    height:calc(100% - 100px);\n" +
"    text-align:center;\n" +
"    padding:20px;\n" +
"    box-sizing:border-box;\n" +
"    transition:0.5s;\n" +
"    opacity:0;\n" +
"}\n" +
".container .box:hover .content{\n" +
"    top:100px;\n" +
"    opacity:1;\n" +
"}\n" +
".container .box .content h3{\n" +
"   margin:0 0 10px;\n" +
"   padding:0;\n" +
"   color:#fff;\n" +
"   font-size:24px;\n" +
"}\n" +
".container .box .content p{\n" +
"   margin:0;\n" +
"   padding:0;\n" +
"   color:#fff;\n" +
"}\n" +
".container .box:nth-child(1).icon\n" +
"{\n" +
"    background:pink;\n" +
"}\n" +
".container .box:nth-child(1)\n" +
"{\n" +
"  background:orange;\n" +
"}\n" +
"* {\n" +
"  box-sizing: border-box;\n" +
"}\n" +
".grid-container {\n" +
"  display: grid;\n" +
"  grid-template-columns: auto;\n" +
"  grid-gap: 10px;\n" +
"  background-color: red;\n" +
"  padding: 10px;\n" +
"}\n" +
".grid-container > div {  \n" +
"  text-align: center;\n" +
"  padding: 20px 0;\n" +
"  font-size: 30px;\n" +
"}\n" +
".item1 {\n" +
"  grid-row: 1 / span 2;\n" +
"}\n" +
"div.item1\n" +
"{\n" +
"font-size:40px;\n" +
"}\n" +
"div.item2\n" +
"{\n" +
"font-size:50px;\n" +
"text-align:center;\n" +
"}\n" +
"h1{\n" +
"  font-size: 40px;\n" +
"}\n" +
"header{\n" +
"    //position: fixed;\n" +
"    top:5; left:5;\n" +
"    z-index: 1000;\n" +
"    height: 60%;\n" +
"    width:22rem;\n" +
"    align-items: top;\n" +
"    justify-content: center;\n" +
"    flex-flow: column;\n" +
"    text-align: center;\n" +
"}\n" +
"header h2\n" +
"{\n" +
"    text-align: center;\n" +
"    font-size: 50px;\n" +
"    color: #fbff00;\n" +
"}\n" +
"header .navbar\n" +
"{\n" +
"    width:100%;\n" +
"}\n" +
"header .navbar h3{\n" +
"    padding: 1rem;\n" +
"    margin:1.5rem 0;\n" +
"    background: #fbff00;\n" +
"    color:rgb(240, 10, 10);\n" +
"    font-size: 1.8rem;\n" +
"    border-radius:5rem;\n" +
"}\n" +
".column1 {\n" +
"  float: left;\n" +
"  width: 25%;\n" +
"  padding: 10px;\n" +
"  height: 920px;\n" +
"}\n" +
".column2 {\n" +
"  float: right;\n" +
"  width: 75%;\n" +
"  padding: 10px;\n" +
"  height: 920px;\n" +
"}\n" +
".row:after {\n" +
"  content: \"\";\n" +
"  display: table;\n" +
"  clear: both;\n" +
"}\n" +
"</style>\n" +
"</head>");
        out.println("<body>\n" +
"<div class=\"grid-container\">\n" +
"  <div class=\"item1\">COURSE REGISTRATION SYSTEM</div>\n" +
"</div>\n" +
"<div class=\"row\">\n" +
"  <div class=\"column1\" style=\"background-color:blue\">\n" +
"  <header>\n" +
"      <h2>PROFILE</h2>\n" +
"          <nav class=\"navbar\">\n" +
"              <h3>NAME : "+ana+"</h1>\n" +
"              <h3>EMP.ID : "+us+"</h1>\n" +
"              <h3>BRANCH : "+bnch+"</h1>\n" +
"            </nav>\n" +
"  </header>\n" +
"  </div>\n" +
"  <div class=\"column2\" style=\"background-color:pink\">\n" +
"    <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"ADDACCOUNT1.html\"><h3><center>ADD ACCOUNT</center></h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"     <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-users\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"addstu.jsp\"><h3>ADD STUDENT</h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"     <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-filter\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"nostu_register.jsp\"><h3>REGISTERED STUDENTS</h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"     <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-ban\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"stuno_register.jsp\"><h3>STUDENTS NOT YET REGISTER</h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"    <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-history\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"paymenthist.jsp\"><h3>PAYMENT HISTORY</h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"     <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-refresh\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"changepassword.html\"><h3>RESET PASSWORD</h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"    <div class=\"container\">\n" +
"        <div class=\"box\">\n" +
"              <div class=\"icon\"><i class=\"fa fa-sign-out\" aria-hidden=\"true\"></i></div>\n" +
"              <div class=\"content\">\n" +
"              <a href=\"index.html\"><h3>SIGN OUT!</h3></a>\n" +
"              </div>\n" +
"        </div>\n" +
"</div>\n" +
"</body>");
        out.println("</html>");
    }
}