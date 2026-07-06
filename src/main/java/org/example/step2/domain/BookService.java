package org.example.step2.domain;

// 이걸 그냥 추상클래스로 만들기도 함 (1개로 이어지는 경우)
public interface BookService {
    void register(Book book);

    Book findBook(long bookId);
}
