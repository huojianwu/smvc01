package com.zking.service.impl;

import com.zking.mapper.BookMapper;
import com.zking.model.Book;
import com.zking.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insert(Book record) {
        return 0;
    }

    @Override
    public int insertSelective(Book record) {
        return 0;
    }

    @Override
    public Book selectByPrimaryKey(Integer bookId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return 0;
    }

    @Override
    public List<Book> list(Book book) {
        return bookMapper.list(book);
    }
}
