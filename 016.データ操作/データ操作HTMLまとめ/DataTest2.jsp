<%-- 
    Document   : DataTest
    Created on : 2018/05/19, 15:20:32
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
                request.setCharacterEncoding("UTF-8");
                out.print(request.getParameter("txtName"));
                out.print(request.getParameter("rdoSample"));
                out.print(request.getParameter("grade"));
                out.print(request.getParameter("rdoSample2"));
                out.print(request.getParameter("mulText"));   
        %>
    </body>
</html>
