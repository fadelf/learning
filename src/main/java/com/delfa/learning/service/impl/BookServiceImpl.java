package com.delfa.learning.service.impl;

import com.delfa.learning.model.Book;
import com.delfa.learning.repository.BookRepository;
import com.delfa.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book createNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Double> getPriceList() {
        return bookRepository.getPriceList();
    }
}
