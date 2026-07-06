package org.example.step2.domain;

public interface BookRepository {
    void save(Book book);

    Book findBook(long bookId);
}
