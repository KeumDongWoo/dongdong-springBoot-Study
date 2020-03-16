package com.dongdong.springboot.service.posts;

import com.dongdong.springboot.domain.Posts;
import com.dongdong.springboot.domain.PostsRepository;
import com.dongdong.springboot.web.dto.PostsListResponseDto;
import com.dongdong.springboot.web.dto.PostsResponseDto;
import com.dongdong.springboot.web.dto.PostsSaveRequestDto;
import com.dongdong.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()   //stream : 람다식 쓰기위함
                .map(PostsListResponseDto::new)        //postsRepository 에서 넘어온 map -> postsListResponseDTO  -> list
                .collect(Collectors.toList());          //collect 자료형변환
    }
}
