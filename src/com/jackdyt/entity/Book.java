package com.jackdyt.entity;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private Integer pages;
    private Double price;
    private BookCase bookCase;

    public Book(Integer id, String name, String author, String publisher, Integer pages, Double price, BookCase bookCase) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
        this.bookCase = bookCase;
    }

    public Book(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }
}
