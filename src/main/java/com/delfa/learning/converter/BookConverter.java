package com.delfa.learning.converter;

import com.delfa.learning.dto.BookDto;
import com.delfa.learning.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConverter {

    public BookDto entityToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setGenre(book.getGenre());
        bookDto.setPrice(book.getPrice());

        return bookDto;
    }

    public List<BookDto> listEntityToDto(List<Book> books) {
        return books.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Book dtoToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setPrice(bookDto.getPrice());

        return book;
    }

    public List<Book> listDtoToEntity(List<BookDto> bookDtoList) {
        return bookDtoList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
