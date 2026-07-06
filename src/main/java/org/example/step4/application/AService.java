package org.example.step4.application;

//@Component
public class AService {
    private final BService bService;

    public AService(BService bService) {
        this.bService = bService;
    }
}
