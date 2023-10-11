<%-- 
    Document   : stuno_register
    Created on : 10-Aug-2022, 2:15:13 am
    Author     : Muhammad Vasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forms</title>
        <style>
            /*<meta content="noindex, nofollow" name="robots">*/
            body{
                margin:0;
                padding:0;
                font-family:'Raleway',sans-serif
            }
            #id{
                background-color:yellow;
            }
            h1{

                text-decoration:underline;
                text-decoration-color:green;
            }
            #first{
                width:400px;
                height:530px;
                box-shadow:0 0 15px rgba(14,41,57,0.12),0 2px 5px rgba(14,41,57,0.44),inset 0 -1px 2px rgba(14,41,57,0.15);
                float:left;
                padding:10px 50px 0;
                background-color:greenyellow;
                margin:2% 30%;
                border-radius:5px
            }
            hr{
                border-top:1px solid #ccc;
                margin-bottom:30px
            }
            span{
                float:left;
                margin-top:8px;
                font-size:17px
            }
            .four{
                display:block;
                margin-left:9px;
                margin-top:10px
            }
            .five{
                display:block;
                margin-left:9px;
                margin-top:10px
            }
            .six{
                display:block;
                margin-left:9px;
                margin-top:10px
            }
            .seven{
                display:block;
                margin-left:9px;
                margin-top:10px
            }
            input,select{
                width:300px;
                padding:10px;
                border-radius:5px;
                border:1px solid #cbcbcb;
                box-shadow:inset 0 1px 2px rgba(0,0,0,0.18);
                font-family:Cursive
            }
            input,select{
                width:300px;
                padding:10px;
                border-radius:5px;
                border:1px solid #cbcbcb;
                box-shadow:inset 0 1px 2px rgba(0,0,0,0.18);
                font-family:Cursive
            }
            input,select{
                width:300px;
                padding:10px;
                border-radius:5px;
                border:1px solid #cbcbcb;
                box-shadow:inset 0 1px 2px rgba(0,0,0,0.18);
                font-family:Cursive
            }
            input,select{
                width:300px;
                padding:10px;
                border-radius:5px;
                border:1px solid #cbcbcb;
                box-shadow:inset 0 1px 2px rgba(0,0,0,0.18);
                font-family:Cursive
            }
            input,select{
                width:300px;
                padding:10px;
                border-radius:5px;
                border:1px solid #cbcbcb;
                box-shadow:inset 0 1px 2px rgba(0,0,0,0.18);
                font-family:Cursive
            }
            .submit{
                width:100px;
                margin-left:83px;
                padding:10px;
                margin-top:20px;
                background:linear-gradient(#A4A4A4,#424242);
                color:#fff;
                font-weight:700
            }
            .submit:hover{
                background:linear-gradient(#424242,#A4A4A4)
            }
        </style>
    </head>
    <body background-color: #DBF9FC;>
        <div id="first">
            <form action="StuNoRegist" method="post">
                <h1><b>NOT REGISTERED STUDENT DATA </b></h1>
                <label class="four">
                    <span><b>BRANCH :</b></span>&nbsp;
                    <br>
                    <br>
                    <%
                        String bn = session.getAttribute("abranch").toString();
                    %>
                    <input type="text" name="branch" value="<%=bn%>" readonly>
                </label>
                <label class="five">
                    <span><b>YEAR :</b></span>&nbsp;
                    <br>
                    <br>
                    <select name="year" required>
                        <option value="" disabled selected hidden>Choose Year...</option>
                        <option value="1">I</option>
                        <option value="2">II</option>
                        <option value="3">III</option>
                        <option value="4">IV</option>
                    </select>
                </label>
                <label class="six">
                    <span><b>SEMESTER :</b></span>&nbsp;
                    <br>
                    <br>
                    <select name="sem" required>
                        <option value="" disabled selected hidden>Choose Semester...</option>
                        <option value="1">I</option>
                        <option value="2">II</option>
                    </select>
                </label>
                <label class="seven">
                    <span><b>SECTION :</b></span>&nbsp;
                    <br>
                    <br>
                    <select name="sec" required>
                        <option value="" disabled selected hidden>Choose Section...</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="F">F</option>
                    </select>
                </label>
                <input class="submit" name="dsubmit" type="submit" value="SUBMIT">
            </form>
        </div>
    </body>
</html>

