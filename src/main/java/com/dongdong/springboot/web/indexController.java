package com.dongdong.springboot.web;

import com.dongdong.springboot.config.auth.LoginUser;
import com.dongdong.springboot.config.auth.dto.SessionUser;
import com.dongdong.springboot.service.posts.PostsService;
import com.dongdong.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class indexController {

    private final PostsService postsService;

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user){   //서버 템플릿 엔진에서 사용할수 있는 객체를 저장
        model.addAttribute("posts",postsService.findAllDesc());//findAllDesc() 결과를 posts 로 index.mustache에 전달

        if(user != null){   //세션에 저장된 값이 있을경우 model에 userName 으로 등록
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id , Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
