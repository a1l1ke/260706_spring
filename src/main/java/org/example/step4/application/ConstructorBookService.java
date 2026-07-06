package org.example.step4.application;

import org.example.step4.domain.Book;
import org.example.step4.domain.BookRepository;
import org.example.step4.domain.BookService;
import org.springframework.stereotype.Component;

@Component
public class ConstructorBookService implements BookService {

    private final BookRepository bookRepository;

    // 생성자가 1개라면 알아서 @Component 처리 시 @Autowired를 붙여줌
//    @Autowired // 생성자 1개 시 생략 가능
    public ConstructorBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void register(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(long bookId) {
        return bookRepository.findBook(bookId);
    }
}
