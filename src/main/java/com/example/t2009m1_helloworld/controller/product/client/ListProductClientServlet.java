package com.example.t2009m1_helloworld.controller.product.client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListProductClientServlet extends HttpServlet {
    private Object productModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("products", productModel.finAll());
        req.getRequestDispatcher("/client/products/list.jsp");
    }
}
