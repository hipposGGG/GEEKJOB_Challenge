<%-- 
    Document   : NewInput
    Created on : 2018/06/04, 11:06:41
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
        <form action="./NewOutput.jsp" method="post">
            <!-- formタグで括られた入力項目はこれら -->
            <p>
            名前 <input type="text" name="txtName"><br><br>
            男<input type="radio" name="rdoGender" value="rdoMen">
            女<input type="radio" name="rdoGender" value="rdoWomen"><br><br>
            <b>趣味<b><br>
            <textarea name="mulText"></textarea><br><br>
            <input type="submit" name="btnSubmit"><br>
            </p>
            
        </form>
    </body>
</html>
