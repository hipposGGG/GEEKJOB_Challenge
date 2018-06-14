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
@WebServlet(name = "mulDBins", urlPatterns = {"/mulDBins"})
public class mulDBins extends HttpServlet {

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
            PreparedStatement db_ps =null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","root","1234");
                
                out.println("データベースと接続しました");
                try{
                    String sql = "INSERT INTO profiles VALUES(7,'yamamoto syun','080-4455-1234',23,'1981-12-27')";
                    
                    db_ps = db_con.prepareStatement(sql);
                    
                    int num = db_ps.executeUpdate();
                    
                    out.println("データベースに情報を入力しました");
                    out.println(num + "行更新されました");
                }catch (SQLException e_sql){
                    out.println("接続時にエラーが発生しました1" + e_sql.toString());
                }catch (Exception e){
                    out.println("接続時にエラーが発生しました2" + e.toString());
                }
                db_con.close();
                db_ps.close();
            }catch (SQLException e_sql){
                out.println("接続時にエラーが発生しました3" + e_sql.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました4" + e.toString());
            }finally{
                if(db_con != null){
                    try{
                        db_con.close();
                        out.println("接続時にエラーが発生しました5");
                    }catch(SQLException e_con){
                        out.println(e_con.getMessage());
                    }
                }
                if(db_ps != null){
                    try{
                        db_ps.close();
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
