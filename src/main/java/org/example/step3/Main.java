package org.example.step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                ScopeConfig.class
        );
        // context -> 어떤 것을 bean을 등록할 것인가?
        // 1. 생성할 때나 생성하고 나서 Configuration을 등록 ***
        // 2. xml로 진행 (<- 옛날 방식임. Spring을 쓴다면 적어도 2 버전. 2버전에는 어노테이션 다 지원)
    }
}
