package com.delfa.learning.repository;

import com.delfa.learning.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT price FROM Book")
    List<Double> getPriceList();
}
