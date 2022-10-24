/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Login;

import DAL.DAO;
import Models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author levuh
 */
public class SignUpControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("re_pass");
        
        if(user==null||user.equals("")){
            request.setAttribute("status", "Invalid username");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(email==null||email.equals("")){
            request.setAttribute("status", "Invalid email");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(pass==null||pass.equals("")){
            request.setAttribute("status", "Invalid password");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(re_pass==null||re_pass.equals("")){
            request.setAttribute("status", "Invalid repass");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(!pass.equals(re_pass)){
            request.setAttribute("status", "Wrong repass");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }else{
            DAO dao = new DAO();
            Account a = dao.checkUserNameExist(user);
            if(a==null){
                a = dao.checkEmailExist(email);
                if(a==null){
                    dao.signup(user, pass, email);
                    request.setAttribute("status", "success");
                }else{
                    request.setAttribute("status", "emailExist");
                    request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("status", "failed");
//                request.setAttribute("mess1", "Username already exist!");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
