package com.bookweb.pojo;

import java.util.Date;

public class Book {

  private long bookId;
  private String bookName;
  private String bookAuther;
  private String bookPublish;
  private int bookPage;
  private double bookPrice;
  private Date createDate;


  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }


  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }


  public String getBookAuther() {
    return bookAuther;
  }

  public void setBookAuther(String bookAuther) {
    this.bookAuther = bookAuther;
  }


  public String getBookPublish() {
    return bookPublish;
  }

  public void setBookPublish(String bookPublish) {
    this.bookPublish = bookPublish;
  }


  public int getBookPage() {
    return bookPage;
  }

  public void setBookPage(int bookPage) {
    this.bookPage = bookPage;
  }


  public double getBookPrice() {
    return bookPrice;
  }

  public void setBookPrice(double bookPrice) {
    this.bookPrice = bookPrice;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

}
