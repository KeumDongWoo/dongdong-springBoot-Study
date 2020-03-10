package com.dongdong.springboot.domain.posts;

import com.dongdong.springboot.domain.Posts;
import com.dongdong.springboot.domain.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  //junit 테스트가 끝날때마다 수행되는 메소드
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 타이틀";
        String content = "테스트 본문";

        //postsRepository.save 테이블 posts에 insert/update 쿼리를 실행 , id값이 있으면 update 있으면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("seletr96@gmail.com")
                .build());

        //테이블 posts에 있는 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
