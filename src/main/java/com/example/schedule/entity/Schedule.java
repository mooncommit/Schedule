package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 일정(Schedule) 엔티티
 */
@Entity
@Table(name = "schedules") // schedules 테이블과 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 기본 생성자
@EntityListeners(AuditingEntityListener.class) // Auditing 등록
public class Schedule {
    // 기본 키(PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 생성 (auto increment)
    private Long id;

    // 일정 제목
    private String title;
    // 일정 내용
    private String content;
    // 작성자
    private String author;
    // 작성자 비밀번호
    private String password;

    // 작성일 (생성 시 자동)
    // 처음 저장할 때 값
    @CreatedDate
    private LocalDateTime createdAt;
    // 수정일 (수정 시 자동 갱신)
    // 처음 저장할 때, 수정할 때마다
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    protected Schedule(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
