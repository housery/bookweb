package com.bookweb.service;

import com.bookweb.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther xiaohoo
 * @Date 2018/9/26 16:58
 * @Email 1126457667@qq.com
 */
public interface BookService {

    public List<Book> getBookList(String bookName, String bookAuther,
                                  String bookPublish, int currentPageNo, int pageSize);

    public int getBookCount(String bookName, String bookAuther, String bookPublish);

    public int addBook(Book book);
}
