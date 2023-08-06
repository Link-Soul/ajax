package com.link.servlet;

import com.alibaba.fastjson.JSON;
import com.link.pojo.Book;
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
import java.util.List;
import java.util.Map;

@WebServlet("/checkBookName")
public class CheckBookNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        String checkBookName = req.getParameter("bookname");
        List<Book> books= bookService.checkInsert(checkBookName);
        Map<String,Object> map = new HashMap<>();

        map.put("result",books.size());

        PrintWriter pw = resp.getWriter();
        pw.write(JSON.toJSONString(map));


    }
}
