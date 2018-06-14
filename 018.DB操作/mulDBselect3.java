/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "mulDBselect3", urlPatterns = {"/mulDBselect3"})
public class mulDBselect3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection db_con = null;
            PreparedStatement db_st =null;
            ResultSet db_data = null;
            Statement stat = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","root","1234");
                
                out.println("データベースと接続しました");
                
                try{
//                    stat = db_con.createStatement();
                    String sql = "SELECT * FROM profiles WHERE name LIKE ?";
//                    db_ps.setString(1,"%" + "sigeru" + "%");
                    
                    String data = "%sigeru%";
                    
                    
                    db_st = db_con.prepareStatement(sql);
                    db_st.setString(1,data);
                    db_data = db_st.executeQuery();
                    out.println("データベースの情報を出力します");
                    
                    while(db_data.next()){
                        String name = db_data.getString("name");
                        String tel = db_data.getString("tel");
                        int age = db_data.getInt("age");
                        String birthday = db_data.getString("birthday");
                        
                        out.println("<p>");
                        out.println("お名前:"+name + ", 電話番号:" + tel 
                                + ", 年齢:" + age + ", 誕生日:" + birthday);
                        out.println("</p>");
                    }
                    
                    
                    stat.close();
                    db_data.close();
                    db_st.close();
                    db_con.close();
                    
                }catch (SQLException e){
                        out.println("SQLException:" + e.getMessage());
                }catch (Exception e){
                        out.println("Exception:" + e.getMessage());
                }finally{
                    try{
                        if (db_con != null){
                            db_con.close();
                        }
                    }catch (SQLException e){
                out.println("SQLException:" + e.getMessage());
                    }
                }
            }catch (SQLException e_sql){
                out.println("接続時にエラーが発生しました3" + e_sql.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました4" + e.toString());
            }finally{
                if(db_con != null){
                    try{
                        db_con.close();
                        //out.println("接続時にエラーが発生しました5");
                    }catch(SQLException e_con){
                        out.println(e_con.getMessage());
                    }
                }
                if(db_st != null){
                    try{
                        db_st.close();
                        out.println("接続時にエラーが発生しました6" );
                    }catch (SQLException e_ps){
                        out.println(e_ps.getMessage());
                    }
                }
            }
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
