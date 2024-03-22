package com.jiat.web.servlet;

import ejb.remort.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddToCart", urlPatterns = "/add-cart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
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
            cart.addItem(name);
            resp.sendRedirect("cart");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
