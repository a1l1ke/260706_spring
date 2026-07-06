package org.example.step3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@Scope("prototype") // 변경
public class PrototypeBean {

    // 생애주기
    @PostConstruct // 생성시
    public void init() {
        System.out.println("PrototypeBean.init %s".formatted(this));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PrototypeBean.destroy %s".formatted(this));
    }
}
