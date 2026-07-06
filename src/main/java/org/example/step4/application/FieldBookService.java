package org.example.step4.application;

import org.example.step4.domain.Book;
import org.example.step4.domain.BookRepository;
import org.example.step4.domain.BookService;

//@Component
public class FieldBookService implements BookService {
    // 알아서 스프링이 주입해줄 거에요
//    @Autowired
    private BookRepository bookRepository; // 필드에 주입해줄 예정

    @Override
    public void register(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(long bookId) {
        return bookRepository.findBook(bookId);
    }
}
