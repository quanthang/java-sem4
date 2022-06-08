package com.example.t2009m1_helloworld.controller;

import com.example.t2009m1_helloworld.entity.Accounts;
import com.example.t2009m1_helloworld.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private AccountService accountService;
    public LoginServlet(){
        this.accountService = new AccountService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/users/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Accounts account = this.accountService.login(username, password);
      if (account != null){
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        System.out.println("login success with username:" + username);
        resp.sendRedirect("/products");
      }else {
          req.setAttribute("masege","Invalid information");
          req.getRequestDispatcher("/client/users/login.jsp").forward(req, resp);
      }
    }
}
