package com.dongdong.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //jpa 에노테이션 , 테이블과 링크될 클래스 , 카멜케이스 -> 언더스코어 네이밍으로 테이블 이름 매칭 ,
public class Posts extends BaseTimeEntity{

    @Id //해당 테이블 PK 필드 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 , GenerationType.IDENTITY -> auto increment
    private Long id;

    @Column(length = 500 , nullable = false)    //테이블 컬럼 , 선언하지않더라도 해당클래스의 필드는 모두 컬럼 ,기본값 추가변경 필요시 사용
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성 , 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함 ,
    // 생성자를 사용하면 new example(b,a) 처럼 a와 b의 위치를 변경하여도 코드를 실행전까지 문제를 찾을수 없기때문에
    // 명확히 파악하기위해 builder 사용
    @Builder
    public Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }

}
