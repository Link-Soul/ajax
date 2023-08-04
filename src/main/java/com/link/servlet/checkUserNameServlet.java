package com.link.servlet;

import com.alibaba.fastjson.JSON;
import com.link.pojo.User;
import com.link.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.alibaba.fastjson.JSONObject;


@WebServlet("/checkUserName")
public class checkUserNameServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = userService.queryUserByName(username);
        Map<String, Object> map = new HashMap<>();

        if (user!=null){
            map.put("result",true);
        }else {
            map.put("result",false);
        }
        PrintWriter pw = resp.getWriter();
        pw.write(JSON.toJSONString(map));

    }
}
