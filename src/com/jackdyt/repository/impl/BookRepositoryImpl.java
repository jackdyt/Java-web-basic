package com.jackdyt.repository.impl;

import com.jackdyt.utils.JDBCTools;
import com.jackdyt.entity.Book;
import com.jackdyt.entity.BookCase;
import com.jackdyt.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll(int index, int limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from book, bookcase where book.bookcaseid = bookcase.id limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        BookCase bookCase = null;
        List<Book> books = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, index);
            preparedStatement.setInt(2, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                bookCase = new BookCase(resultSet.getInt(9), resultSet.getString(10));
                book = new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), bookCase);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return books;

    }

    @Override
    public int count() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from book, bookcase where book.bookcaseid = bookcase.id";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return count;
    }

}
