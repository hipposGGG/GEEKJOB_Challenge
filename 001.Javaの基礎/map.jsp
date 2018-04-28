<%-- 
    Document   : map
    Created on : 2018/04/28, 15:04:23
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
        <%@page import="java.util.*" %>
        <% 
            HashMap<String, String> user1 = new HashMap<String,String>();
            HashMap<String, String> user2 = new HashMap<String,String>();
            HashMap<String, String> user3 = new HashMap<String,String>();
            HashMap<String, String> user4 = new HashMap<String,String>();
            
            user1.put("1", "AAA");  
            user2.put("hello", "world!"); 
            user3.put("soeda", "33");   
            user4.put("20", "20"); 
            
            ArrayList<HashMap> data =new ArrayList<HashMap>();
            
            data.add(user1);
            data.add(user2);
            data.add(user3);
            data.add(user4);
            
            out.print(user1 + "<br>" + user2 + "<br>" + user3 + "<br>" +user4 );
                   
            //HashMap<String, String> data2 = new HashMap<String,Integer>();
        %>
    </body>
</html>
