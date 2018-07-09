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
@WebServlet(name = "userDBupdate", urlPatterns = {"/userDBupdate"})
public class userDBupdate extends HttpServlet {

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
            out.println("<title>商品　更新画面</title>");            
            out.println("</head>");
            out.println("<body>");
            //　ログイン情報を初期化
            String gsNameGet = null;
            int gsIdGet = -1;
            int gsPriceGet = -1;
            // ブラウザからの情報の読み取り  
            if(request.getParameter("gsName") != null){
                gsNameGet = request.getParameter("gsName");
            }
            if(request.getParameter("gsId") != null){
                gsIdGet = Integer.parseInt(request.getParameter("gsId"));
            }
            if(request.getParameter("gsPrice") != null){
                gsPriceGet = Integer.parseInt(request.getParameter("gsPrice"));
            }
            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
            out.println("更新手続きが整いました");
            try {
                //NetBeansによるDB接続の命令文
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db",
                    "root","1234");
                
                //挿入の命令文を作成
                String sql = "INSERT INTO goods (goodName, goodID, goodPrice)VALUES(?,?,?);";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, gsNameGet);
                pstmt.setInt(2, gsIdGet);
                pstmt.setInt(3, gsPriceGet);
                
                //更新数の表示
                int num = pstmt.executeUpdate();
                out.println("<br>＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝<br>");
                out.println(num + "件更新されました");
                
                //一覧の表示
                out.println("<br>");
                out.println("データベースの情報を出力します");
                String sql2 = "SELECT  * FROM goods;";
                rs = pstmt.executeQuery(sql2);
                while(rs.next()){
                    String gsName = rs.getString("goodName");
                    int gsID = rs.getInt("goodID");
                    int gsPri = rs.getInt("goodPrice");
                    out.println("<p>");
                    out.println("商品名:"+ gsName + ", 商品ID:"+gsID + ", 商品単価:" + gsPri );
                    out.println("</p>");
                }
            
            //挿入後、DBテーブルを表示
                  

            }catch (ClassNotFoundException e){
                log("ClassNotFoundException:" + e.getMessage());
            }catch (SQLException e){
                log("SQLException:" + e.getMessage());
            }catch (Exception e){
                log("Exception:" + e.getMessage());
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
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(userDBupdate.class.getName()).log(Level.SEVERE, null, ex);
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
