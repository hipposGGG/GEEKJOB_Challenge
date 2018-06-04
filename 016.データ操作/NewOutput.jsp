<%-- 
    Document   : NewOutput
    Created on : 2018/06/04, 11:14:22
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
            out.println(request.getParameter("txtName"));        
            out.println(request.getParameter("rdoGender"));
            out.println(request.getParameter("mulText"));
            
            //セッションのインスタンス化
            HttpSession hs = request.getSession();
            //セッションへ登録
            hs.setAttribute("txtName",request.getParameter("txtName"));
            
            hs.setAttribute("rdoGender",request.getParameter("rdoGender"));
 
            hs.setAttribute("mulText",request.getParameter("mulText"));
            


        %>
    </body>
</html>
