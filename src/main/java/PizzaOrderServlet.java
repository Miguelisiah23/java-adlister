import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    req.getRequestDispatcher("/pizza-order.jsp").forward(req,res);
}

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

    String crust = req.getParameter("crust");
    String cheese = req.getParameter("cheese");
    String sauce = req.getParameter("sauce");
    String[] toppings = req.getParameterValues("toppings");
    String address = req.getParameter("address");

    req.setAttribute("crust",crust);
    req.setAttribute("cheese",cheese);
    req.setAttribute("sauce",sauce);
    req.setAttribute("toppings",toppings);

    System.out.println("You chose: "+ crust + " crust with "+ cheese + ", " + sauce + " sauce with " + Arrays.toString(toppings) + " delivered to " + address);

}
}
