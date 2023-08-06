package com.link.servlet;

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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        String booknameDelete = req.getParameter("booknameUpdate");
        int statusUpdate = Integer.parseInt(req.getParameter("statusUpdate"));
        Book book = new Book();
        book.setBookname(booknameDelete);
        book.setStatus(statusUpdate);
        int update = bookService.update(book);
        PrintWriter pw = resp.getWriter();

        if (update==1){
            pw.write("update success");
        }else {
            pw.write("update false");
        }
    }
}
