package org.example.step3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// 직접적으로 bean로 하지 않아도 특정한 경로를 지정하면 알아서 읽어서 bean으로 만들어주는 어노테이션
// bean은 @Configuration 안에 @Bean으로 등록
// @Component로 해놓으면 스프링한테 해당 컴포넌트가 존재하는 '경로 패키지'를 알려주면 알아서 인식
@Component
public class SingletonBean {

    // 생애주기
    @PostConstruct // 생성시
    public void init() {
        System.out.println("SingletonBean.init %s".formatted(this));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SingletonBean.destroy %s".formatted(this));
    }
}
