<%-- 
    Document   : QuerysosuTest
    Created on : 2018/05/21, 17:20:25
    Author     : USER
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            int math = Integer.valueOf(request.getParameter("math"));
            int i = 2;
            ArrayList<String> maths = new ArrayList<String>();
            out.print(math + " = ");
            int count = 0;
            //配列mathsに割った数字を格納
            for( i = 2; i< 10; i++){
                while(math % i == 0){
                    math /= i;
                    maths.add(String.valueOf(i));
                    count++; 
                }
            }
            
            
//            while(math != 1 ) { 
//                if(math % i == 0) {
//                        math /= i;
//                        maths.add(String.valueOf(i));
//                        count++;                    
//                }else{
//                        i++;
//                } 
//            }          
            //最後尾を変数に代入する
            //maths.remove(count-1);
            if(maths.size() != 0){
                maths.get(count-1); 
            } 
            String x = " * ";
            String n = String.join(x, maths); 
            if(n != null){
                out.print(n);
                
            }
            
            if(math != 1){
                out.print(" あまり " + math);
            }
            
        %>
        <br><br>
        
        <a href="./Querysosu.jsp">戻る</a>
    </body>
</html>
