import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PickColorServlet", urlPatterns = "/pickcolor")
public class PickColorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/pickcolor.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
      String color = req.getParameter("color");
      res.sendRedirect("/viewcolor?color=" + color);

    }
}
