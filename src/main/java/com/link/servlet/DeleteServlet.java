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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        Book book = new Book();
        String booknameDelete = req.getParameter("booknameDelete");
        book.setBookname(booknameDelete);
        int delete = bookService.delete(book);
        PrintWriter pw = resp.getWriter();

        if (delete==1){
            pw.write("delete success");
        }else {
            pw.write("delete false");
        }
    }
}
