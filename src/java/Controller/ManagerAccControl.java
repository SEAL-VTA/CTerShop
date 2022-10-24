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
import java.util.List;

/**
 *
 * @author levuh
 */
public class ManagerAccControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("acc");
        if(a==null){
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else if(a.getIsAdmin() != 1){
                response.sendRedirect("home");
        }else{
            String indexPage = request.getParameter("index");
            if(indexPage==null){
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            DAO dao = new DAO();
            int count = dao.getTotalAccount();
            int endPage = count/5;
            if(count % 5 != 0){
                endPage++;
            }
            List<Account> list = dao.pagingAccount(index);

            request.setAttribute("listA", list);
            request.setAttribute("endP", endPage);
            request.setAttribute("tag1", index);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
