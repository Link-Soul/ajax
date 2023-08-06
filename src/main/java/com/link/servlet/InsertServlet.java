package com.link.servlet;

import com.link.mapper.BookMapper;
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

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        Book book = new Book();
        String booknameDelete = req.getParameter("booknameInsert");
        book.setStatus(1);
        book.setBookname(booknameDelete);
        int insert = bookService.insert(book);
        PrintWriter pw = resp.getWriter();

        if (insert==1){
            pw.write("alter(insert success)");
        }else {
            pw.write("insert false");
        }

    }
}
