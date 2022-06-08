package com.example.t2009m1_helloworld.controller;



import com.example.t2009m1_helloworld.entity.Accounts;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentName = req.getParameter("currentName");
        req.setAttribute("currentName",currentName);
        req.getRequestDispatcher("/User/Register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      String email = req.getParameter("email");
      String confirmPassword = req.getParameter("confirmPassword");
      String fullName = req.getParameter("fullName");
      Accounts accounts = Accounts.AccountBuilder.anAccount()
              .withUsername(username)
              .withPassword(password)
              .withEmail(email)
              .withConfirmPassword(confirmPassword)
              .withFullName(fullName)
              .build();
      if (!accounts.isValid()){
          req.setAttribute("account", accounts);

          req.setAttribute("erros", getError());
          req.getRequestDispatcher("/User/Register.jsp").forward(req, resp);
          return;
      }
      accounts = accountService.register(accounts);
      req.setAttribute("account",accounts);
      req.getRequestDispatcher("/User/Register-success.jsp").forward(req, resp);
    }


}
