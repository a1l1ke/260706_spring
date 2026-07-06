package org.example.step1.application;

import org.example.step1.domain.Book;
import org.example.step1.domain.BookRepository;
import org.example.step1.domain.BookService;
import org.example.step1.infra.MemoryBookRepository;

// 연관된 인프라나 api 등이 명확하지 않아서 Impl(구현체)라는 것을 클래스 이름에 명시
// 인터페이스를 써서 추상화를 하고 싶긴한데 다형성이 꼭 필요하진 않은 것
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository = new MemoryBookRepository();

    @Override
    public void register(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(long bookId) {
        return bookRepository.findBook(bookId);
    }
}
