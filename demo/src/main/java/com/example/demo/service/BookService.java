package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("bookDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        bookDao.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public Book getBookById(UUID id) {
        return bookDao.selectBookById(id);
    }

    public boolean deleteBookById(UUID id) {
        return bookDao.deleteBookById(id);

    }

    public void deleteAllBooks() {
        bookDao.deleteAllBooks();
    }

    public boolean updateBook(UUID id, Book updatedBook) {
        return bookDao.updateBookById(id, updatedBook);

    }

    public List<Book> getBooksByAuthor(String author) {
        return bookDao.selectBooksByAuthor(author);
    }

    public List<Book> getBooksByPublisher(String publisher) {
        return bookDao.selectBooksByPublisher(publisher);
    }
}
