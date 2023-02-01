package com.delfa.learning.controller;

import com.delfa.learning.converter.BookConverter;
import com.delfa.learning.dto.BookDto;
import com.delfa.learning.dto.SalesDto;
import com.delfa.learning.function.SimpleAction;
import com.delfa.learning.function.SimpleActionParameter;
import com.delfa.learning.model.Book;
import com.delfa.learning.service.BookService;
import com.delfa.learning.wrapper.BookFilterWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookConverter bookConverter;

    @RequestMapping(path = "/list",
            method = RequestMethod.GET)
    public ResponseEntity<?> getAllBook() {
        List<Book> bookList = bookService.getAllBook();

        return new ResponseEntity<>(bookConverter.listEntityToDto(bookList), HttpStatus.OK);
    }

    @RequestMapping(path = "/list-by-title/{title}",
            method = RequestMethod.GET)
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
        List<Book> bookList = bookService.getAllBook();

        // Count using filter stream API
        long count = bookList.stream().filter(x -> x.getTitle().toLowerCase().contains(title.toLowerCase())).count();

        // Create new filtered list using stream API
        List<Book> bookListFiltered = bookList.stream().filter(x -> x.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());

        List<BookDto> bookDtoList = bookConverter.listEntityToDto(bookListFiltered);

        BookFilterWrapper result = new BookFilterWrapper();
        result.setCount(count);
        result.setResult(bookDtoList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        Book result = bookService.createNewBook(book);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/sales",
            method = RequestMethod.GET)
    public ResponseEntity<?> getBookSales() {
        List<Double> bookPrices = bookService.getPriceList();

        // Use Stream API to calculate some simple statistic summary
        DoubleSummaryStatistics summaryStatistics = bookPrices.stream().mapToDouble((x) -> x).summaryStatistics();

        // Create sales wrapper using Function interface
        Function<DoubleSummaryStatistics, SalesDto> toDto = x -> {
            SalesDto salesDto = new SalesDto();
            salesDto.setCheapestPrice(x.getMin());
            salesDto.setMostExpensivePrice(x.getMax());
            salesDto.setTotalSales(x.getSum());
            salesDto.setTotalBookSold(x.getCount());
            salesDto.setAveragePrice(x.getAverage());

            return salesDto;
        };

        SalesDto bookSales = toDto.apply(summaryStatistics);

        return new ResponseEntity<>(bookSales, HttpStatus.OK);
    }
}
