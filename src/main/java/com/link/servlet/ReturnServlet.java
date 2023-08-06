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

@WebServlet("/return")
public class ReturnServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reTurn = req.getParameter("return");
        BookService bookService = new BookServiceImpl();
        int returnUpdate = bookService.returnUpdate(reTurn);
        PrintWriter pw = resp.getWriter();
        if (returnUpdate==1){
            pw.write("return success");
        }else {
            pw.write("return false");
        }
    }

}
