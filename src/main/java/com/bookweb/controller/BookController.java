package com.bookweb.controller;

import com.bookweb.pojo.Book;
import com.bookweb.service.BookService;
import com.bookweb.tools.Constants;
import com.bookweb.tools.PageSupport;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther xiaohoo
 * @Date 2018/9/26 20:50
 * @Email 1126457667@qq.com
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = Logger.getLogger(BookController.class);
    @Resource
    private BookService bookService;

    @RequestMapping("/booklist.html")
    public String getBookList(Model model,
                              @RequestParam(value = "queryKeyword",required = false) String queryKeyword,
                              @RequestParam(value = "queryKeywordValue",required = false) String queryKeywordValue,
                              @RequestParam(value = "pageIndex", required = false) String pageIndex){
        logger.info("----> queryKeyword:" + queryKeyword);
        logger.info("----> queryKeywordValue:" + queryKeywordValue);
        logger.info("----> pageIndex:" + pageIndex);
        // 空值转换
        if (StringUtils.isNullOrEmpty(queryKeyword)){
            queryKeyword = "";
        }
        if (StringUtils.isNullOrEmpty(queryKeywordValue)){
            queryKeywordValue = "";
        }
        // 查询key-value转换
        String bookName = null;
        String bookAuther = null;
        String bookPublish = null;
        if (queryKeyword.equals("bookName")){
            bookName = queryKeywordValue;
        }else if (queryKeyword.equals("bookAuther")){
            bookAuther = queryKeywordValue;
        }
        if (queryKeyword.equals("bookPublish")){
            bookPublish = queryKeywordValue;
        }

        //----------------分页--------------------
        //设置页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
        // 将前段页面索引设为当前页
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/bill/syserror.html";
            }
        }
        //总数量（表）
        int totalCount	= bookService.getBookCount(bookName, bookAuther, bookPublish);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        List<Book> bookList = bookService.getBookList(bookName, bookAuther, bookPublish, currentPageNo, pageSize);
        model.addAttribute("bookList", bookList);
        model.addAttribute("bookName", bookName);
        model.addAttribute("bookAuther", bookAuther);
        model.addAttribute("bookPublish", bookPublish);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "bookList";
    }

    // 跳转到添加图书页面
    @RequestMapping("/bookadd.html")
    public String bookAdd(){
        return "bookAdd";
    }

    // 保存图书
    @RequestMapping("/bookAddSave.html")
    public String bookAddSave(@RequestParam String bookName, @RequestParam String author, @RequestParam String publish,
                              @RequestParam String pageCount, @RequestParam String price){
        logger.debug("bookName--->" + bookName);
        logger.debug("author--->" + author);
        logger.debug("publish--->" + publish);
        logger.debug("pageCount--->" + pageCount);
        logger.debug("price--->" + price);

        int _page = 0;
        float _price = 0;
        // 数据类型转换
        if (!StringUtils.isNullOrEmpty(pageCount)){
            _page = Integer.parseInt(pageCount);
        }
        if (!StringUtils.isNullOrEmpty(price)){
            _price = Float.parseFloat(price);
        }

        Book book = new Book();
        book.setBookName(bookName);
        book.setBookAuther(author);
        book.setBookPage(_page);
        book.setBookPrice(_price);
        book.setBookPublish(publish);
        book.setCreateDate(new Date());
        bookService.addBook(book);
        return "redirect:/book/booklist.html";
    }
}
