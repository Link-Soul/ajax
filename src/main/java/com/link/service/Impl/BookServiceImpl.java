package com.link.service.Impl;

import com.link.mapper.BookMapper;
import com.link.pojo.Book;
import com.link.service.BookService;
import com.link.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private SqlSession sql = GetSqlSession.getSql();
    BookMapper mapper = sql.getMapper(BookMapper.class);


    @Override
    public int insert(Book book) {
        int insert = mapper.insert(book);
        sql.commit();
        return insert;
    }

    @Override
    public int delete(Book book) {
        int delete = mapper.delete(book);
        sql.commit();
        return delete;
    }

    @Override
    public int update(Book book) {
        int update = mapper.update(book);
        sql.commit();
        return update;
    }

    @Override
    public List<Book> select() {
        return mapper.select();
    }

    @Override
    public List<Book> checkInsert(String bookname) {
        List<Book> bookList;

        bookList = mapper.checkInsert(bookname);
        return bookList;
    }

    @Override
    public int checkBorrow(String bookname) {
        List<Book> checkBorrow = mapper.checkBorrow(bookname);

        if (checkBorrow.size()==0){
            return -1;
        } else if (checkBorrow.size()==1&&checkBorrow.get(0).getStatus()==0) {
            return 0;
        }else {
            return 1;
        }

    }

    @Override
    public int checkReturn(String bookname) {
        List<Book> checkReturn = mapper.checkReturn(bookname);

        if (checkReturn.size()==0){
            return -1;
        } else if (checkReturn.size()==1&&checkReturn.get(0).getStatus()==0) {
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int borrowUpdate(String bookname) {
        int update = mapper.borrowUpdate(bookname);
        sql.commit();
        return update;
    }

    @Override
    public int returnUpdate(String bookname) {
        int update = mapper.returnUpdate(bookname);
        sql.commit();
        return update;
    }
}
