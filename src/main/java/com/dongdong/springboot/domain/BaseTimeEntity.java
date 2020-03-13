package com.dongdong.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JAP Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드도 칼럼으로 인식하도록함.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate //entity가 저장될때 시간이 자동으로 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할때 시간이 자동으로저장됨
    private LocalDateTime modifiedDate;
}
