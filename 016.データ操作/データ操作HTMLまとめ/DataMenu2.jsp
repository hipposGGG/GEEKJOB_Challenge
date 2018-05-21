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
    <h2>【　学校アンケート　】</h2>
    </head>
    <body>
        <form action="./DataTest.jsp" method="post">
            <!-- formタグで括られた入力項目はこれら  -->
            <p>■名前情報 <br><input type="text" name="txtName" placeholder="ここに記入ください"></p><br>
            <p>■性別情報<br> 
                <input type="radio" name="rdoSample" value="男">男
                <input type="radio" name="rdoSample" value="女">女
            </p><br>
            <P>学年情報：
                <select name="grade">
                <option value="First">1年生</option>
                <option value="second">2年生</option>
                <option value="third">3年生</option>
                </select>
            </P>
            <p>■趣味情報 <br>
                <input type="radio" name="rdoSample2" value="スポーツ">スポーツ
                <input type="radio" name="rdoSample2" value="音楽">音楽
                <input type="radio" name="rdoSample2" value="習い事">習い事
                <input type="radio" name="rdoSample2" value="勉強">勉強
            </p>
            <textarea name="mulText" placeholder="例）野球が大好き"></textarea><br>
            
            <input type="submit" name="btnSybmit" valu="送信">
            
        </form>
    </body>
</html>
