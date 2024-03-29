package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookDao {
    void insertBook(Book book);
    List<Book> selectAllBooks();
    Book selectBookById(UUID id);
    public boolean deleteBookById(UUID id);
    void deleteAllBooks();
    boolean updateBookById(UUID id, Book book);
    List<Book> selectBooksByAuthor(String author);
    List<Book> selectBooksByPublisher(String publisher);

}
