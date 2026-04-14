package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 일정(Schedule) 엔티티
 * schedules 테이블과 매핑되는 클래스
 */
@Entity
@Table(name = "schedules") // schedules 테이블과 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 기본 생성자
public class Schedule extends BaseEntity{
    // 기본 키(PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 생성 (auto increment)
    private Long id;

    private String title;
    private String content;
    private String author;
    private String password;

    /**
     * 일정 생성자
     * @param title 일정 제목
     * @param content 일정 내용
     * @param author 작성자명
     * @param password 비밀번호
     */
    public Schedule(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    /**
     * @return 아이디
     */
    public Long getId() {
        return id;
    }

    /**
     * @return 일정 제목
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return 일정 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * @return 작성자명
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return 비밀번호
     * 응답에 포함하지 말 것
     */
    public String getPassword() {
        return password;
    }
}
