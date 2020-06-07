package com.jackdyt.repository;

import com.jackdyt.entity.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> findAll(int index, int limit);
    public int count();
}
