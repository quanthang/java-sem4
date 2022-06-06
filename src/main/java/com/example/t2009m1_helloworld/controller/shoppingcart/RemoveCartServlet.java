package com.example.t2009m1_helloworld.controller.shoppingcart;

import com.example.t2009m1_helloworld.entity.Shoppingcart;
import com.example.t2009m1_helloworld.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            Shoppingcart shoppingcart =shoppingCartHelper.getCart();
            shoppingcart.remove(productId);
            shoppingCartHelper.saveCart(shoppingcart);
            resp.sendRedirect("/shopping-cart/get");
        }catch (Exception ex){
            resp.getWriter().println(ex.getMessage());
        }
    }
}
