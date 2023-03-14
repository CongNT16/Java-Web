package dal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Discussion extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        
        if (session.getAttribute("user") == null) {
            out.println("<h1>access denied</h1>");
            return;
        } else {
            Thread th = new Thread();
            List<Thread> list = th.getAll();
            req.setAttribute("data", list);
            req.getRequestDispatcher("Discusion.jsp").forward(req, resp);
        }
        
    }
    
}
