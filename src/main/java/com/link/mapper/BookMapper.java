package com.link.mapper;

import com.link.pojo.Book;

import java.util.List;

public interface BookMapper {
    int insert(Book book);
    int delete(Book book);
    int update(Book book);
    List<Book> select();
    List<Book> checkInsert(String bookname);


    List<Book> checkBorrow(String bookname);
    List<Book> checkReturn(String bookname);

    int borrowUpdate(String bookname);
    int returnUpdate(String bookname);

}
