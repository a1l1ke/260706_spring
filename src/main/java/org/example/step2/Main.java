package org.example.step2;


import org.example.step2.config.AppConfig;
import org.example.step2.domain.Book;
import org.example.step2.domain.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 스프링 컨테이너 가동
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        BookService bookService = new BookServiceImpl();
        BookService bookService = applicationContext.getBean(BookService.class);
        BookService bookService2 = applicationContext.getBean(BookService.class);
        System.out.println("같은가? %b".formatted(bookService == bookService2));
        Book book = new Book(1, "윌리엄의 코딩비밀");
        bookService.register(book);
        Book registeredBook = bookService.findBook(1);
        System.out.println("book = " + book);
        System.out.println("registeredBook = " + registeredBook);
    }
}
