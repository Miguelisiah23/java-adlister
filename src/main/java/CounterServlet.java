import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet",urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int count;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String reset = req.getParameter("reset");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if(reset != null){
            count = 0;
            res.sendRedirect("/count");
        } else {
            count++;
        }
        out.println("<h1>Page count is: " + count);

    }
}
