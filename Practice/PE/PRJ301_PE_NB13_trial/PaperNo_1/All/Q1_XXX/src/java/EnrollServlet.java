
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EnrollServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String source = req.getParameter("source");
        String level = req.getParameter("level");
        String date = req.getParameter("date");

        PrintWriter out = resp.getWriter();

        out.println("<h3>Student Name: " + name + "</h3>");
        out.println("<h3>Financial Source:" + source + "</h3>");
        out.println("<h3>Level: " + level + "</h3>");
        out.println("<h3>DOE: " + date + "</h3>");
    }

}
