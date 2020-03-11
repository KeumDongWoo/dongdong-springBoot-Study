package com.dongdong.springboot.service.posts;

import com.dongdong.springboot.domain.Posts;
import com.dongdong.springboot.domain.PostsRepository;
import com.dongdong.springboot.web.dto.PostsResponseDto;
import com.dongdong.springboot.web.dto.PostsSaveRequestDto;
import com.dongdong.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto reqDto) {
        return postsRepository.save(reqDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당게시글이없습니다. id=" + id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이없습니다. id =" + id));

        return new PostsResponseDto(entity);
    }
}
