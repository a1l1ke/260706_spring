package org.example.step1;


import org.example.step1.application.BookServiceImpl;
import org.example.step1.domain.Book;
import org.example.step1.domain.BookService;

public class Main {
    // 진입점 -> entrypoint (실행 기준점 static main)
    public static void main(String[] args) {
        // BookService -> Book. -> 추상화.
//        BookService bookService;
        BookService bookService = new BookServiceImpl();
//        Book book = new Book(...);
        Book book = new Book(1, "윌리엄의 코딩비밀");
//        bookService.register(book);
        bookService.register(book);
        // bookService.findBook(...);
        Book registeredBook = bookService.findBook(1);
        // ...
        System.out.println("book = " + book);
        System.out.println("registeredBook = " + registeredBook);
        System.out.println("book == registeredBook : %b".formatted(book == registeredBook));
    }
}
