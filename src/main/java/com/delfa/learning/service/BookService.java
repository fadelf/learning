package com.delfa.learning.service;

import com.delfa.learning.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    Book createNewBook(Book book);

    List<Double> getPriceList();
}
