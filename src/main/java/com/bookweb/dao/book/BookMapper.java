package com.bookweb.dao.book;

import com.bookweb.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther xiaohoo
 * @Date 2018/9/26 16:15
 * @Email 1126457667@qq.com
 */
public interface BookMapper {
    /**
     * 获取图书列表
     * @param bookName 书名
     * @param bookAuther 作者
     * @param bookPublish 出版社
     * @param from 起始页
     * @param pageSize 页大小
     * @return 查询到的图书列表
     */
    public List<Book> getBookList(@Param("bookName") String bookName,
                                  @Param("bookAuther") String bookAuther,
                                  @Param("bookPublish")String bookPublish,
                                  @Param("from") int from, @Param("pageSize") int pageSize);

    /**
     * 获取总记录数，用于分页
     * @return 记录数
     */
    public int getBookCount(@Param("bookName") String bookName, @Param("bookAuther") String bookAuther,
                            @Param("bookPublish")String bookPublish);

    /**
     * 添加图书
     * @param book 添加的书对象
     * @return 操作数
     */
    public int addBook(Book book);
}
