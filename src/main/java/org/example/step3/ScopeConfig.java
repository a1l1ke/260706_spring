package org.example.step3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 이게 핵심 (이름이 config? 중요하지 않음)
@ComponentScan("org.example.step3") // step3 아래의 패키지 중 component들을 등록하겠다
public class ScopeConfig {
}
