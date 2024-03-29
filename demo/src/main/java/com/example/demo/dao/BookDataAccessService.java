package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository("bookDao")
public class BookDataAccessService implements BookDao {
    public static List<Book> DB = new ArrayList<>();

    @Override
    public void insertBook(Book book) {
        DB.add(book);
    }

    @Override
    public List<Book> selectAllBooks() {
        return DB;
    }

    @Override
    public Book selectBookById(UUID id) {
        return DB.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteBookById(UUID id) {
        Iterator<Book> iterator = DB.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId().equals(id)) {
                iterator.remove();
                return true; // Видалено успішно
            }
        }
        return false; // Книга з заданим id не була знайдена
    }

    @Override
    public void deleteAllBooks() {
        DB.clear();
    }

    @Override
    public boolean updateBookById(UUID id, Book updatedBook) {
        for (int i = 0; i < DB.size(); i++) {
            Book book = DB.get(i);
            if (book.getId().equals(id)) {
                DB.set(i, updatedBook);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> selectBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : DB) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    @Override
    public List<Book> selectBooksByPublisher(String publisher) {
        List<Book> booksByPublisher = new ArrayList<>();
        for (Book book : DB) {
            if (book.getPublisher().equals(publisher)) {
                booksByPublisher.add(book);
            }
        }
        return booksByPublisher;
    }
}
