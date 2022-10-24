
package Controller;

import DAL.DAO;
import Models.Category;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levuh
 */
public class HomeControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String indexPage = request.getParameter("index");
        if(indexPage==null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        DAO dao = new DAO();
        int count = dao.getTotalProduct();
        int endPage = count/6;
        if(count % 6 != 0){
            endPage++;
        }
        List<Product> list = dao.getAllProduct(index);
        Product last = dao.getLast();
        List<Category> listC = dao.getAllCategory();
        
        request.setAttribute("listC", listC);
        request.setAttribute("listP", list);
        request.setAttribute("p", last);
        request.setAttribute("endP", endPage);
        request.setAttribute("tag1", index);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
