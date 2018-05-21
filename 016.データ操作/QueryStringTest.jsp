<%-- 
    Document   : QueryStringTest
    Created on : 2018/05/21, 13:43:56
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
        <form action="./QueryStringCatch.jsp" method="get">
            <p>
                総合計：<br>
                <input type="text" name="total"><br>
                購入品目：
                <select name="type">
                    <option value="1">雑　貨</option>
                    <option value="2">生鮮食品</option>
                    <option value="3">その他</option>
                </select><br>
                個数：<br>
                <input type="text" name="count"><br>
            </p>  
       
        <input type="submit" name="btnSybmit" valu="送信">
        </form>
    </body>
</html>
