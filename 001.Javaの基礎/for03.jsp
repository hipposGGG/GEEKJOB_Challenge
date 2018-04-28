<%-- 
    Document   : for03
    Created on : 2018/04/28, 16:43:46
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
            int num = 0;
            for(int i=0; i<=100; i++){
                num = num + i;
            }
            out.print(num);
        %>
    </body>
</html>
