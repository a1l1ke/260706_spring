package org.example.step1.domain;

public interface BookRepository {
    void save(Book book);
    Book findBook(long bookId);
}
