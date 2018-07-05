/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.recordSelOr;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
                String nameGet = null;
                int ageGet = 0;
                String bdGet = null;
                try{
                
                
                // ブラウザからの情報の読み取り
                if(request.getParameter("Name") != null){
                    nameGet = request.getParameter("Name");
                }
                if(Integer.parseInt(request.getParameter("Age")) != 0){
                    ageGet = Integer.parseInt(request.getParameter("Age"));
                }
                if(request.getParameter("Calendar") != null){
                    bdGet = request.getParameter("Calendar");
                }
                
                // 受け取るパラメータの文字コード
                request.setCharacterEncoding("UTF-8");
           
                //NetBeansによるDB接続の命令文
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db",
                    "root","1234");
                
                out.println("データベースと接続しました");
                out.println("<br>");
                try{

                    //挿入後、DBテーブルを表示
                    stat = db_con.createStatement();
                    String sql2 = "SELECT * FROM  profiles WHERE name=? OR age=? OR birthday=?;";
                    db_ps = db_con.prepareStatement(sql2);
                    db_ps.setString(1, nameGet);
                    db_ps.setInt(2, ageGet);
                    db_ps.setString(3, bdGet);

                    
                    rs = db_ps.executeQuery();         

                    
                    out.println("データベースの情報を出力します");

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
                    out.println("接続時にエラーが発生しました3" + e_sql.toString());
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
