package com.link.servlet.check;

import com.alibaba.fastjson.JSON;
import com.link.service.BookService;
import com.link.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkBorrow")
public class CheckBorrowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookname = req.getParameter("bookname");
        BookService bookService = new BookServiceImpl();

        int checkBorrow = bookService.checkBorrow(bookname);
        Map<String,Object> map = new HashMap<>();
        map.put("result",checkBorrow);
        PrintWriter pw = resp.getWriter();
        pw.write(JSON.toJSONString(map));
    }
}
