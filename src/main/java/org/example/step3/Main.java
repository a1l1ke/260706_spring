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
        SingletonBean sb1 = applicationContext.getBean(SingletonBean.class);
        System.out.println("sb1 = " + sb1);
        SingletonBean sb2 = applicationContext.getBean(SingletonBean.class);
        System.out.println("sb2 = " + sb2);
        // 싱글톤이라면 일치함. -> 싱글톤 => 한 개의 객체를 공유공간에 만들어놓고 새로운 생성 없이 제공하는 패턴
        System.out.println("sb1 == sb2 : %b".formatted(sb1 == sb2));
        // 우리가 bean 을 @Bean이나 @Component로 등록해서 쓰는 것들은 일반적으로 Singleton임
        // 다른데서 써도 전혀 문제가 없음. <- 이 원칙을 준수하기 위해 Singleton은 데이터를 저장하는 필드를 두지 않음.
        PrototypeBean pb1 = applicationContext.getBean(PrototypeBean.class);
        System.out.println("pb1 = " + pb1);
        PrototypeBean pb2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println("pb2 = " + pb2);
        System.out.println("pb1 == pb2 : %b".formatted(pb1 == pb2));
        // 이후에 학습할 Spring Web MVC에서는 동시성, HTTP 무상태성 등을 고려하여 주로 Singleton만을 사용하는데, 그렇다고 해서 우리가 직접 사용하는 것 외에 여러 라이브러리나 내장 작용등은 프로토타입이 쓰임
        // 요청 객체, 세션 객체 -> 상태를 지님. (프로토타입 파생)
    }
}
