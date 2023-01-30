package com.delfa.learning.controller;

import com.delfa.learning.converter.BookConverter;
import com.delfa.learning.function.SimpleAction;
import com.delfa.learning.function.SimpleActionParameter;
import com.delfa.learning.model.Book;
import com.delfa.learning.service.BookService;
import com.delfa.learning.wrapper.BookFilterWrapper;
import com.delfa.learning.wrapper.BookWrapper;
import com.delfa.learning.wrapper.SalesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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

        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @RequestMapping(path = "/list-dto",
            method = RequestMethod.GET)
    public ResponseEntity<?> getAllBookDto() {
        List<Book> bookList = bookService.getAllBook();

        return new ResponseEntity<>(bookConverter.listEntityToDto(bookList), HttpStatus.OK);
    }

    @RequestMapping(path = "/list-formatted",
            method = RequestMethod.GET)
    public ResponseEntity<?> getAllBookFormatted() {
        List<Book> bookList = bookService.getAllBook();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        // Create new formatted list by mapping each data using stream API
        List<BookWrapper> bookListFormatted = bookList.stream().map(x -> {
            BookWrapper bookWrapper = new BookWrapper();
            bookWrapper.setTitle(x.getTitle());
            bookWrapper.setAuthor(x.getAuthor());
            bookWrapper.setGenre(x.getGenre());
            bookWrapper.setPrice(x.getPrice());
            bookWrapper.setUpdatedOn(x.getUpdatedOn().format(formatters));
            return bookWrapper;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(bookListFormatted, HttpStatus.OK);
    }

    @RequestMapping(path = "/list-by-title/{title}",
            method = RequestMethod.GET)
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
        List<Book> bookList = bookService.getAllBook();

        // Count using filter stream API
        long count = bookList.stream().filter(x -> x.getTitle().toLowerCase().contains(title.toLowerCase())).count();

        // Create new filtered list using stream API
        List<Book> bookListFiltered = bookList.stream().filter(x -> x.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());

        BookFilterWrapper result = new BookFilterWrapper();
        result.setCount(count);
        result.setResult(bookListFiltered);

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
        Function<DoubleSummaryStatistics, SalesWrapper> toWrapper = x -> {
            SalesWrapper salesWrapper = new SalesWrapper();
            salesWrapper.setCheapestPrice(x.getMin());
            salesWrapper.setMostExpensivePrice(x.getMax());
            salesWrapper.setTotalSales(x.getSum());
            salesWrapper.setTotalBookSold(x.getCount());
            salesWrapper.setAveragePrice(x.getAverage());

            return salesWrapper;
        };

        SalesWrapper bookSales = toWrapper.apply(summaryStatistics);

        return new ResponseEntity<>(bookSales, HttpStatus.OK);
    }
}
