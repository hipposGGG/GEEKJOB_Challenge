<%-- 
    Document   : for02
    Created on : 2018/04/28, 16:36:26
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
            
            String text = "焼肉";
            for(int i=0; i<30; i++){
                text = (text + "焼肉<br>");
            }
            out.print(text);
        %>
    </body>
</html>
