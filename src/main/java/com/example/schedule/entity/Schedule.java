package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 일정(Schedule) 엔티티
 */
@Entity
@Table(name = "schedules") // schedules 테이블과 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 기본 생성자
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
}
