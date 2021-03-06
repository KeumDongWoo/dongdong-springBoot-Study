package com.dongdong.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/* JpaRepository<Entity클래스,PK타입> 기본적인 CRUD 메소드 자동생성
*  Entity 클래스와 함께위치해야함 */
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("select p from Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
