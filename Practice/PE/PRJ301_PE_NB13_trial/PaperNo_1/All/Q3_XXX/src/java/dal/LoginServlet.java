package dal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
    
    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        
        if (username == null && password == null) {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            return;
        }
        
        User u = new User();
        
        if (u.checkLogin(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", u.getUser(username, password));
            out.println("<h1>Login Succesfull!</h1>");
            return;
        }
        req.setAttribute("loginMsg", "Login Failed");
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}
