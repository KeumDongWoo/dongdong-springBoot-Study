package com.dongdong.springboot.web;

import com.dongdong.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {

    private final PostsService postsService;

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model){   //서버 템플릿 엔진에서 사용할수 있는 객체를 저장
        model.addAttribute("posts",postsService.findAllDesc());//findAllDesc() 결과를 posts 로 index.mustache에 전달
        return "index";
    }
}
