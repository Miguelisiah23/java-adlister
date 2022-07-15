import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    public static int RandomNumber() {
        Random random = new Random();
        return random.nextInt(3) + 1 ;

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.getRequestDispatcher("/guess.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String random = RandomNumber() + "";
        String num = req.getParameter("num");
        System.out.println(random);
        System.out.println(num);
        if(num.equalsIgnoreCase(random)){
            res.sendRedirect("/correct?guess=correct");
        } else {
            res.sendRedirect("/incorrect?guess=wrong");
        }

    }
}
