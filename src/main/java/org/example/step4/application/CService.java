package org.example.step4.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CService {
    @Autowired
    private DService dService; // 필드 주입

    public void hello() {
        System.out.println("CService.hello");
        dService.hello();
    }
}
