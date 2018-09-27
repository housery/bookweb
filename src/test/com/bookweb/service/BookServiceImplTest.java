package com.bookweb.service;

import com.bookweb.pojo.Book;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther xiaohoo
 * @Date 2018/9/26 17:13
 * @Email 1126457667@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})

public class BookServiceImplTest {
    private Logger logger = Logger.getLogger(BookServiceImplTest.class);
    @Autowired
    private BookService bookService;

    @Test
    public void getBookList() {
        List<Book> bookList = bookService.getBookList(null,null,null,1,5);
        for (Book book: bookList) {
            logger.debug("------->" + book.getBookName());
        }
    }

    @Test
    public void getBookCount() {
        // logger.debug("---------->" + bookService.getBookCount());
    }

    @Test
    public void addBook() {
    }
}