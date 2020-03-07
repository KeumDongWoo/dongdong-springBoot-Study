package com.dongdong.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON으로 반환하는 컨트롤러
public class HelloController {

    @GetMapping("/hello") //HTTP Method인 GET요청을 받을 수 있는 API를 만들어줌 (@RequestMapping(method = RequestMethod.GET) 이랑 같다)
    public String hello(){
        return "Hello";
    }
}
