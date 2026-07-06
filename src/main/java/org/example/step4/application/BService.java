package org.example.step4.application;

//@Component
public class BService {
    private final AService aService;

    public BService(AService aService) {
        this.aService = aService;
    }
}
