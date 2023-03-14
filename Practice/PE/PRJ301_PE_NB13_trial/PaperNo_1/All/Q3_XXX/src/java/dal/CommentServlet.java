package dal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class CommentServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment = req.getParameter("input");
        int tId = Integer.parseInt(req.getParameter("tId"));
        
        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("user");
    
        Answer a = new Answer();
        a.addComment(u.getUsername(), comment, tId);
        req.getRequestDispatcher("discuss").forward(req, resp);
    }
    
}
