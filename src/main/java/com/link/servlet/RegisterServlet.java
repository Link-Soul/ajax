package com.link.servlet;

import com.alibaba.fastjson.JSON;
import com.link.pojo.User;
import com.link.service.Impl.UserServiceImpl;
import com.link.service.UserService;
import com.link.util.GetUUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String realname = req.getParameter("realname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        User user = new User();

        user.setU_id(GetUUID.getUUID());
        user.setUsername(username);
        user.setPassword(password);
        user.setRealname(realname);
        user.setPhone(phone);
        user.setEmail(email);


        int register = userService.register(user);
        PrintWriter pw = resp.getWriter();
        pw.write(JSON.toJSONString(register));
        pw.write("注册成功");
    }
}
