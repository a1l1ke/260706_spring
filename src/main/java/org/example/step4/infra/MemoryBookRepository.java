package org.example.step4.infra;

import org.example.step4.domain.Book;
import org.example.step4.domain.BookRepository;

import java.util.HashMap;
import java.util.Map;

// 인터페이스(타입) o = new 클래스(구현)()
// 클래스(구현체)를 쓴다 - 인스턴스를 쓴다 - 힙 메모리 저장된 '상태'를 가지는 객체
// -> 자료구조 / 다른 주입된 의존성 객체 -> '포함'한다 / '합성' composition한다
public class MemoryBookRepository implements BookRepository {
    // 멀티 스레드 환경(tomcat)에서 하는 것이 아니기 때문에 동시성 신경 쓸 필요가 X
    private final Map<Long, Book> store = new HashMap<>(); // store는 데이터 창고, 저장소 의미

    @Override
    public void save(Book book) {
        store.put(book.bookId(), book);
    }

    @Override
    public Book findBook(long bookId) {
        return store.get(bookId);
    }
}
