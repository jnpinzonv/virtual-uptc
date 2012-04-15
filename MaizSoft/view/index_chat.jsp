<!--
/*
 *
 * Web Chat Module
 * Copyright (c) 2010 Osama Mohammad Oransa
 *
 */
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Chat Login</title>
    </head>
    <body>
       <center>
       
           <img src="css/images_chat/company.png"/>
           <h2>Welcome in Web Chat</h2>
        	<form action="ChatServlet" method="post">
            <input type="hidden" name="step" value="1">
            <% if(request.getAttribute("ERROR")!=null){%>
                <font color="red">Invalid username or password</font>
            <% }else if(request.getAttribute("ERROR")!=null){%>
                <font color="red">Session Expired, please relogin</font>
            <% } %>
            <table>
                <tr>
                    <td>Username</td>
                    <td><input id="username" name="username" value="Osama" style="width: 150pt"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input id="password" name="password" type="password" value="osama" style="width: 150pt"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center><button type="submit" value="login" style="width: 80pt">Login</button></center>
                    </td>
                </tr>
            </table>
        </form>
       </center>
    </body>
</html>
