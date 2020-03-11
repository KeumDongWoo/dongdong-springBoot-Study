package com.dongdong.springboot.web;

import com.dongdong.springboot.service.posts.PostsService;
import com.dongdong.springboot.web.dto.PostsResponseDto;
import com.dongdong.springboot.web.dto.PostsSaveRequestDto;
import com.dongdong.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //final로 선언된 모든 필드를 인자값으로 하는 생성자를 대신생성
@RestController
public class PostsApiController {

    private final PostsService postsService;    //autowired 대신 생성자로 Bean 주입

    @PostMapping("/api/v1/posts")
    public Long save (@RequestBody PostsSaveRequestDto reqDto){
        return postsService.save(reqDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id , @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
