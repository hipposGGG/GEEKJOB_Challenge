<%-- 
    Document   : switch
    Created on : 2018/04/28, 13:55:22
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
            int type = 2;
            switch(type){
                case 1:
                    out.print("one");
                    break;
                case 2:
                    out.print("two");
                    break;
                default:
                    out.print("想定外");
                    break;
            }
        %>
        <% out.print("<br>"); %>
        <% out.print("<br>"); %>
        <% 
            char text = 'A';
            switch(text){
                case 'A':
                    out.print("英語");
                    break;
                case 'あ':
                    out.print("日本語");
                    break;
                default:
                    out.print("");
                    break;
            }
        %>    
    </body>
</html>
