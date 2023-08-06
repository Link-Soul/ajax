package com.link.servlet;

import com.link.service.BookService;
import com.link.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String borrow = req.getParameter("borrow");
        BookService bookService = new BookServiceImpl();
        int borrowUpdate = bookService.borrowUpdate(borrow);
        PrintWriter pw = resp.getWriter();
        if (borrowUpdate==1){
            pw.write("borrow success");
        }else {
            pw.write("borrow false");
        }

    }
}
