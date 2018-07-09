/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoge;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "userDBcatch", urlPatterns = {"/userDBcatch"})
public class userDBcatch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected Connection conn = null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    Statement stat = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ログイン画面</title>");            
            out.println("</head>");
            out.println("<body>");
            //　ログイン情報を初期化
            String nameGet = null;
            String passGet = null;
            
            // ブラウザからの情報の読み取り  
            if(request.getParameter("Name") != null){
                nameGet = request.getParameter("Name");
            }
            if(request.getParameter("Pass") != null){
                passGet = request.getParameter("Pass");
            }
            
            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
            //NetBeansによるDB接続の命令文
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db",
                "root","1234");
            out.println("データベースと接続完了");
            out.println("<br>");
            }catch (ClassNotFoundException e){
                log("ClassNotFoundException:" + e.getMessage());
            }catch (SQLException e){
                log("SQLException:" + e.getMessage());
            }catch (Exception e){
                log("Exception:" + e.getMessage());
            }
            if (nameGet.equals("shuhei") && passGet.equals("baseball")) {
                out.println("ログインされました");
            }else{
                out.println("【ログインできませんでした。もう一度入力し直してください】");
            }
            out.println("<form method=\"POST\" action=\"./userDBupdate\">");
            out.println("<table>");
            out.println("<tr><td>商品名：</td>");
            out.println("<td><input type=text name=\"gsName\" size=20></td></tr>");
            out.println("<tr><td>商品ID：</td>");
            out.println("<td><input type=text name=\"gsId\" size=20></td></tr>");
            out.println("<tr><td>商品単価：</td>");
            out.println("<td><input type=text name=\"gsPrice\" size=20></td></tr>");
            out.println("<body>");
            out.println("</table>");
            out.println("<input type=\"submit\" value=\"  入力する  \">");
            out.println("</form>");
            
            //完了時の接続解除
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                log("SQLException:" + e.getMessage());
            }finally{
                pstmt.close();
                rs.close();
                stat.close();
            }
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(userDBcatch.class.getName()).log(Level.SEVERE, null, ex);
        }
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
