package com.example.t2009m1_helloworld.controller;

import com.example.t2009m1_helloworld.Model.MySqlUserModel;
import com.example.t2009m1_helloworld.Model.User;
import com.example.t2009m1_helloworld.entity.Account;
import com.example.t2009m1_helloworld.entity.Student;

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
       String passwordHash = req.getParameter("passwordHash");
       Integer status = Integer.parseInt(req.getParameter("status"));
       User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordHash);
        user.setStatus(status);
        MySqlUserModel mySqlUserModel = new MySqlUserModel();
        boolean result = mySqlUserModel.save(user);
        System.out.println(result);
       req.setAttribute("user", user);
       req.getRequestDispatcher("/User/Register-success.jsp").forward(req, resp);
    }
}
