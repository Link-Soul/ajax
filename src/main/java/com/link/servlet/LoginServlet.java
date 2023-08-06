package com.link.servlet;

import com.link.pojo.User;
import com.link.service.Impl.UserServiceImpl;
import com.link.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        PrintWriter pw = resp.getWriter();
        if (login!=null){
            resp.sendRedirect("/ajax_war_exploded/book.html");
            //pw.write("yes");
        }else {
            pw.write("no");
        }


    }
}
