package com.delfa.learning.wrapper;

import com.delfa.learning.dto.BookDto;
import com.delfa.learning.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class BookFilterWrapper {
    private Long count;
    private List<BookDto> result;
}
