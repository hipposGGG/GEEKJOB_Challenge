<%-- 
    Document   : whille
    Created on : 2018/05/08, 13:13:47
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
           int i = 1000;
           int cou = 0;
           while(i > 100){
               i = i/2;
               cou++;
           }
           out.print(i + "の表示は"+ cou+"回のループ処理の結果です");
           
//           String key = "1";
//           int count = 0;
//           while(key.equals("100000") == false) {
//                key = key + "0";
//                count++;
//            }
//
//            out.print(count + "回ループしました！");
            
        %>
    </body>
</html>
