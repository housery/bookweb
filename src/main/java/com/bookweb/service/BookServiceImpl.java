package com.bookweb.service;

import com.bookweb.dao.book.BookMapper;
import com.bookweb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther xiaohoo
 * @Date 2018/9/26 16:59
 * @Email 1126457667@qq.com
 */
@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList(String bookName, String bookAuther, String bookPublish, int currentPageNo, int pageSize) {
        int from = (currentPageNo-1)*pageSize;
        return bookMapper.getBookList(bookName, bookAuther, bookPublish, from, pageSize);
    }

    @Override
    public int getBookCount(String bookName, String bookAuther, String bookPublish) {
        return bookMapper.getBookCount(bookName, bookAuther, bookPublish);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }
}
