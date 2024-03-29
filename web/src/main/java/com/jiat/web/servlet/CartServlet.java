package com.jiat.web.servlet;

import ejb.remort.Cart;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Cart cart;
        try {
            InitialContext context = new InitialContext();
            HttpSession session = req.getSession();
            if (session.getAttribute("cart-session") == null) {
                cart = (Cart) context.lookup("java:global/ear/app/CartBean");
                session.setAttribute("cart-session", cart);
            } else {
                cart = (Cart) session.getAttribute("cart-session");
            }

            Map<String, Object> items = cart.getItems();

            resp.getWriter().write(items.toString());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
