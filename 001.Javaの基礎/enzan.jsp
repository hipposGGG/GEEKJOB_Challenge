<%-- 
    Document   : enzan
    Created on : 2018/04/28, 12:32:32
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            int num1 = 1;
            int num2 = 1;
            int num3 = 1;
            int num4 = 1;
            
            out.print(++num1 + "<br>");
            out.print(num2++ + "<br>");
            out.print(--num3 + "<br>");
            out.print(num4-- + "<br>");
           
        %>
    </body>
</html>
