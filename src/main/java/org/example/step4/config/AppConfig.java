package org.example.step4.config;

import org.example.step4.domain.BookRepository;
import org.example.step4.infra.MemoryBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.step4") // @Component라는 애너테이션이 달린 클래스를 빈으로 알아서 등록
public class AppConfig {

    @Bean
    public BookRepository bookRepository() {
        return new MemoryBookRepository();
    }

//    @Bean
//    public BookService bookService() {
//        return new BookServiceImpl(bookRepository());
//    }
}
