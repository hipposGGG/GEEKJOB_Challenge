/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.record;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "mulDBcatch", urlPatterns = {"/mulDBcatch"})
public class mulDBcatch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     
    Connection db_con = null;
    PreparedStatement db_ps =null;
    ResultSet rs = null;
    Statement stat = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                try{
                // ブラウザからの情報の読み取り
                int proIDGet = Integer.parseInt(request.getParameter("profilesID"));
                String nameGet = request.getParameter("NAME");
                String telGet = request.getParameter("Tel");
                int ageGet = Integer.parseInt(request.getParameter("Age"));
                String birthdayGet = request.getParameter("Calendar");
                System.out.println(telGet);
                // 受け取るパラメータの文字コード
                request.setCharacterEncoding("UTF-8");
           
                //NetBeansによるDB接続の命令文
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db",
                    "root","1234");
                
                out.println("データベースと接続しました");
                try{
                    //取得した情報の挿入文
                    String sql = "INSERT INTO profiles(profilesID,name,tel,age,birthday) "
                        + "VALUES(?,?,?,?,?);";
                    db_ps = db_con.prepareStatement(sql);
                    
                    db_ps.setInt(1, proIDGet);
                    db_ps.setString(2, nameGet);
                    db_ps.setString(3, telGet);
                    db_ps.setInt(4, ageGet);
                    db_ps.setString(5, birthdayGet);
            
                    //更新処理及び、桁数を代入
                    int num = db_ps.executeUpdate();
                    
                    //挿入後、DBテーブルを表示
                    stat = db_con.createStatement();
                    String sql2 = "SELECT * FROM  profiles";
                    rs = stat.executeQuery(sql2);                 
                    
                    out.println("データベースの情報を出力します");
                    out.println(num + "行更新されました");
                    while(rs.next()){
                        int profilesID = rs.getInt("profilesID");
                        String name = rs.getString("name");
                        String tell = rs.getString("tel");
                        int age = rs.getInt("age");
                        String birthday = rs.getString("birthday");
                        out.println("<p>");
                        out.println("PROFILE ID:"+ profilesID + ", お名前:"+name + ", 電話番号:" + tell 
                            + ", 年齢:" + age + ", 誕生日:" + birthday);
                        out.println("</p>");
                    }
                   
                    
                    }catch (SQLException e_sql){
                        out.println("接続時にエラーが発生しました1" + e_sql.toString());
                    }catch (Exception e){
                        out.println("接続時にエラーが発生しました2" + e.toString());
                    }
                    
                }catch (SQLException e_sql){
                    out.println("接続時にエラーが発生しました1" + e_sql.toString());
                }
                rs.close();
                db_con.close();
            
            }catch (SQLException e){
                System.out.println("SQLException:" + e.getMessage());
            }catch (Exception e){
                System.out.println("Exception:" + e.getMessage());
            }
            
        }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
