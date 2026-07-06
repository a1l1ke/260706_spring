package org.example.step4.config;

import org.example.step4.application.BookServiceImpl;
import org.example.step4.domain.BookRepository;
import org.example.step4.domain.BookService;
import org.example.step4.infra.MemoryBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 컴파일 과정에서 스프링 컨테이너가 이 클래스를 읽고, 이 클래스에 정의된 빈을 등록
public class AppConfig {

    // @Bean <- 스프링 컨테이너에서 관리하는 객체
    @Bean
    public BookRepository bookRepository() {
        return new MemoryBookRepository(); // 업캐스팅으로 다형성 활용하여 등록
        // SupabaseBookRepository? SQLBookRepository? <- BookRepository Interface Impl
        // 스프링컨테이너에 'BookRepository'라는 타입의 빈이 등록되었는데
        // 실제로는 MemoryBookRepository라는 구체적인 구현체가 등록
    }

    @Bean
    public BookService bookService() {
        // BookService가 주입이 될 때 bookRepository(MemoryBookRepository)를 주입받아서
        return new BookServiceImpl(bookRepository());
    }
}
