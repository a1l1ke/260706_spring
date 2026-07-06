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
        // 일반적인 객체면 registeredBook == book <- 저장한 객체와 꺼내는 객체가 같을 경우
        // 참조 이슈가 일어나서 수정 시 저장된 것도 수정하는 문제가 생기는데, record 경우에는 그럴 이슈 X.
    }
}
