/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import Models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author levuh
 */
public class AddAccount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        
        DAO dao = new DAO();
        Account a = dao.checkUserNameExist(username);
            if(a==null){
                a = dao.checkEmailExist(email);
                if(a==null){
                    dao.signup(username, password, email);
                    request.setAttribute("status", "success");
                }else{
                    request.setAttribute("status", "emailExist");
                    request.getRequestDispatcher("manageAcc").forward(request, response);
                }
            }else{
                request.setAttribute("status", "failed");
//                request.setAttribute("mess1", "Username already exist!");
                request.getRequestDispatcher("manageAcc").forward(request, response);
            }
        response.sendRedirect("manageAcc");
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
