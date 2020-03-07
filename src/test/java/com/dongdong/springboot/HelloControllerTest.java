package com.dongdong.springboot;

import com.dongdong.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //Spring Runner 라는 스프링 실행자를 사용
@WebMvcTest(controllers = HelloController.class)//여러 테스트 에노테이션중 Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired  //빈 주입
    private MockMvc mvc; //웹 API를 테스트할 때 사용 , 스프링 MVC 테스트의 시작점 , 이 클래스를 통해 HTTP GET , POST 등에 관한 API 테스트를 할 수 있음.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "Hello";

        mvc.perform(get("/hello"))          //MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
                .andExpect(status().isOk())             //mvc.perform의 결과를 검증함 , 200,404,500 등의 상태를 검증
                .andExpect(content().string(hello));    //mvc.perform의 결과를 검증함 , 응답 본문의 내용을 검증 , controller 결과값이 맞는지 검증    }
    }
}

