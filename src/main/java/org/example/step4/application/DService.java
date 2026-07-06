package org.example.step4.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DService {
    private CService cService;

    @Autowired
    public void setCService(CService cService) {
        this.cService = cService;
    } // 세터 주입

    public void hello() {
        System.out.println("DService.hello");
        cService.hello();
    }
}
