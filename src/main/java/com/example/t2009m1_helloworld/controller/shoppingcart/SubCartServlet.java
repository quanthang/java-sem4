package com.example.t2009m1_helloworld.controller.shoppingcart;

import com.example.t2009m1_helloworld.Model.MySqlProduct;
import com.example.t2009m1_helloworld.Model.ProductModel;
import com.example.t2009m1_helloworld.entity.Product;
import com.example.t2009m1_helloworld.entity.Shoppingcart;
import com.example.t2009m1_helloworld.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubCartServlet extends HttpServlet {
    private ProductModel productModel;
    public SubCartServlet(){this.productModel = new MySqlProduct();}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            Integer quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = ProductModel.finById(productId);
            if (product == null){
                resp.getWriter().println("product is not found");
                return;
            }
            if (quantity <= 0) {
                resp.getWriter().println("invalid quantity");
                return;
            }
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            Shoppingcart shoppingcart = shoppingCartHelper.getCart();
            shoppingcart.add(product, quantity);
            shoppingCartHelper.saveCart(shoppingcart);
            resp.sendRedirect("/shopping-cart/get");
        }catch (Exception ex){
            resp.getWriter().println(ex.getMessage());
        }
    }
}
