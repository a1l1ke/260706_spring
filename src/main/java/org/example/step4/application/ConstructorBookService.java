package org.example.step4.application;

import lombok.RequiredArgsConstructor;
import org.example.step4.domain.Book;
import org.example.step4.domain.BookRepository;
import org.example.step4.domain.BookService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final로 지정된 필드를 포함한 생성자를 자동으로 생성
public class ConstructorBookService implements BookService {
    private final BookRepository bookRepository;

    // 생성자가 1개라면 알아서 @Component 처리 시 @Autowired를 붙여줌
//    @Autowired // 생성자 1개 시 생략 가능
//    public ConstructorBookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @Override
    public void register(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(long bookId) {
        return bookRepository.findBook(bookId);
    }
}
