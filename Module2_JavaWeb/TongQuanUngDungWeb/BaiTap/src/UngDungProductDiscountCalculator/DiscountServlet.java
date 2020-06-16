package UngDungProductDiscountCalculator;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet (urlPatterns = {"/display-discount"})
public class DiscountServlet  extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String product = request.getParameter("product");
        double price = Double.parseDouble(request.getParameter("Price"));
        double discount = Double.parseDouble(request.getParameter("Discount"));
        double amount;
        double discountPrice;
        PrintWriter writer = response.getWriter();
        writer.println("<h3> Product Description: " + product + "</h3>");
        writer.println("<h3> List Price: " + price + "</h3>");
        writer.println("<h3> Discount Percent: " + discount + "</h3>");

        amount = price * discount *0.01 ;
        discountPrice = price - amount;
        writer.println("<h3>Discount Amount: " + amount + "</h3>");
        writer.println("<h3>Discount Price: " + discountPrice + "</h3>");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
