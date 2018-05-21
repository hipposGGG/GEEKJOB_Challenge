<%-- 
    Document   : QueryStringCatch
    Created on : 2018/05/21, 14:05:00
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
                int gds =10;
                int fds = 3;
                int oth = 5;

                int total = Integer.valueOf(request.getParameter("total"));
                int count = Integer.valueOf(request.getParameter("count"));
                double zei = 0;
                    if(total < 3000){
                        out.println(total + "円");
                        out.println("ポイントは" + zei + "円です");
                    }else if(total >= 3000 || total < 5000){
                        zei = total * 0.04;
                        out.println(total + "円");
                        out.println("ポイントは" + zei + "円です");
                    }else if(total >= 5000){
                        zei = total * 0.05;
                        out.println(total + "円");
                        out.println("ポイントは" + zei + "円です");
                    } 
                out.println("<br>");
                int a = Integer.valueOf(request.getParameter("type"));
                if(request.getParameter("type") != null){
                    if(a == 1 ){
                        out.println("単価は" + (total / count) +"円です");
                    }else if(a == 2 ){
                        out.println("単価は" + (total / count) + "円です");
                    }else if(a == 3 ){
                        out.println("単価は"+ (total / count) + "円です");
                    }
                }
        %>
    </body>
</html>
