package org.example.step4;

import org.example.step4.application.AService;
import org.example.step4.application.BService;
import org.example.step4.application.CService;
import org.example.step4.application.DService;
import org.example.step4.config.AppConfig;
import org.example.step4.domain.Book;
import org.example.step4.domain.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1. 실제 로직 부분에서 바꿔치기를 안해도 Scan이나 Configuration에서 바꾸는 것만으로도 구현체를 쉽게 의존성 꼬임 없이 바꿔칠 수 있음
        // 2. 필드나 생성자 등을 통해 하위 의존성도 쉽게 처리할 수 있음.

        // 스프링 컨테이너 가동
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class); // step4.config.AppConfig
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println("bookService = " + bookService);
        //        BookService bookService2 = new BookServiceImpl(); // 생성자이기 때문에 애초 컴파일 X.
//        BookService bookService2 = new FieldBookService(); // 필드 주입 시 (autowired) -> 스프링 컨테이너를 통하지 않은 객체 생성 및 주입을 대응할 수 X. // NPE
//        BookService bookService2 = new SetterBookService(); // NPE
//        BookService bookService2 = new ConstructorBookService(); //
//        System.out.println("bookService2 = " + bookService2);
        Book book = new Book(1, "윌리엄의 코딩비밀");
        bookService.register(book);
        Book registeredBook = bookService.findBook(1);
        System.out.println("book = " + book);
        System.out.println("registeredBook = " + registeredBook);
//        bookService2.register(book);

        // 생성자 주입을 쓸 경우의 순환 참조
        // UnsatisfiedDependencyException
        try {
            AService aService = applicationContext.getBean(AService.class);
            System.out.println("aService = " + aService);
            BService bService = applicationContext.getBean(BService.class);
            System.out.println("bService = " + bService);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 적절한 예외 처리 가능
        }
        // 필드, 세터 주입을 쓸 경우의 순환 참조
        try {
            CService cService = applicationContext.getBean(CService.class);
            System.out.println("cService = " + cService);
            DService dService = applicationContext.getBean(DService.class);
            System.out.println("dService = " + dService);
            cService.hello();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // critical한 stackoverflow 에러가 뜨면서 더 이상 진행할 수 X.
        }
    }
}
