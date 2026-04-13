package com.example.schedule.dto;

import java.time.LocalDateTime;

/**
 * 일정 조회 응답 DTO
 * 서버가 클라이언트로 전송하는 데이터
 */
public class GetAllSchedulesResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    /**
     * 일정 응답 생성자
     *
     * @param id      아이디
     * @param title   일정 제목
     * @param content 일정 내용
     * @param author  작성자명
     */
    public GetAllSchedulesResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
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
     * @return 작성일
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @return 수정일
     */
    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
