package com.example.schedule.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 공통 생성일, 수정일 필드를 관리하는 부모 클래스
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Auditing 등록
public abstract class BaseEntity {

    // 작성일 (생성 시 자동)
    // 처음 저장할 때 값
    @CreatedDate
    private LocalDateTime createdAt;
    // 수정일 (수정 시 자동 갱신)
    // 처음 저장할 때, 수정할 때마다
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    /**
     * 작성일 반환
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * 수정일 반환
     */
    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

}
