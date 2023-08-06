package com.link.service;

import com.link.pojo.Book;

import java.util.List;

public interface BookService {
    int insert(Book book);
    int delete(Book book);
    int update(Book book);
    List<Book> select();
    List<Book> checkInsert(String bookname);
    int checkBorrow(String bookname);
    int checkReturn(String bookname);
    int borrowUpdate(String bookname);
    int returnUpdate(String bookname);

}
