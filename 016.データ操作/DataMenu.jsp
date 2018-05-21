<%-- 
    Document   : DataManu
    Created on : 2018/05/19, 14:41:28
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>コントロールサンプル</title>
    </head>
    <body>
        <form action="./DataTest.jsp" method="post">
            <!-- formタグで括られた入力項目はこれら  -->
            <p>名前情報 <input type="text" name="txtName"></p><br>
            <p>性別情報 
                <input type="radio" name="rdoSample" value="男">男
                <input type="radio" name="rdoSample" value="女">女
            </p><br>
            <p>趣味情報 <textarea name="mulText"></textarea></p><br>
            <input type="submit" name="btnSybmit" valu="送信">
            
        </form>
    </body>
</html>
