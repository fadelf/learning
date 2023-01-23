package com.delfa.learning.wrapper;

import com.delfa.learning.model.Book;

import java.util.List;

public class BookFilterWrapper {
    private Long count;
    private List<Book> result;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Book> getResult() {
        return result;
    }

    public void setResult(List<Book> result) {
        this.result = result;
    }
}
