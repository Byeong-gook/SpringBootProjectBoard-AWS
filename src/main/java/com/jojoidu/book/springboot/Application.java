package com.jojoidu.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//앞으로 만들프로젝트의 메인 클래스
//@SpringBootApplication으로 인해
// 1. 스프링 부트의 자동 설정, 2. 스프링 Bean 읽기와 생성이 모두 자동으로 설정됨
// 다음 어노테이션이 있는 위치부터 설정을 읽어가므로 이 클래스는 항 상 프로젝트 최상단에 위치해야한다.

