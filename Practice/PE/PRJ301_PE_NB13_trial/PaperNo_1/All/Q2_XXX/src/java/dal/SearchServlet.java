package dal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        
        if (name != null) {
            Student s = new Student();
            
            List<Student> list = s.filter(name);
            req.setAttribute("data", list);
        }
        
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
    
}
