package org.example.repository;


import org.example.model.Book;

import java.util.*;

public class BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    public void save(Book book) {
        books.put(book.getId(), book);
    }

    public Book findById(String id) {
        return books.get(id);
    }

    public Collection<Book> findAll() {
        return books.values();
    }
}
