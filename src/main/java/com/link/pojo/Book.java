package com.link.pojo;

import com.link.mapper.BookMapper;
import com.link.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Book  {
   private String bookname;
   private int status;

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", status=" + status +
                "}";
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
