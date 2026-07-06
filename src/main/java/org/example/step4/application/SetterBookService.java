package org.example.step4.application;

import org.example.step4.domain.Book;
import org.example.step4.domain.BookRepository;
import org.example.step4.domain.BookService;

//@Component
public class SetterBookService implements BookService {
    // 알아서 스프링이 주입해줄 거에요
    // @Autowired <- 여기에 달면 필드 주입
    private BookRepository bookRepository; // 필드에 주입해줄 예정

    //    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("SetterBookService.setBookRepository");
        this.bookRepository = bookRepository;
    } // 별도의 메서드 set을 통해서 주입 받음

    @Override
    public void register(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(long bookId) {
        return bookRepository.findBook(bookId);
    }
}
