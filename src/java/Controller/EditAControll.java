/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author levuh
 */
@WebServlet(name = "EditAControll", urlPatterns = {"/editAccount"})
public class EditAControll extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String isSell = request.getParameter("isSell");
        String isAdmin = request.getParameter("isAdmin");
        String email = request.getParameter("email");
        DAO dao = new DAO();
        
        dao.editAccount(user, pass, isSell, isAdmin, email, id);
        response.sendRedirect("manageAcc");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
