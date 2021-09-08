package com.jojoidu.book.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//SpringRunner 스프링 실행자?.. ( 스프링 부트테스트와 Junit 사이에 연결자 역할을 한다고함)
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 웹 API 테스트할때 사용 , 스프링 MVC 테스트의 시작점 , 이 클래스를 통해서 HTTP GET, POST 등에 대한 API 테스트가 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        //param : API 테스트할때 사용될 요청 파라미터를 설정 , 단 값은 Stirng만 허용한다. (숫자 날짜등의 데이터도 문자열로 변경해야 가능)
        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        //jsonPath : json응답값을 필드별로 검증할수있는 메서드
    }
    }
