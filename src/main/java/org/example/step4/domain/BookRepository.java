package org.example.step4.domain;

public interface BookRepository {
    void save(Book book);

    Book findBook(long bookId);
}
