package com.example.schedule.dto;

/**
 * 일정 생성 요청 DTO
 * 클라이언트가 서버로 전송하는 데이터
 */
public class ScheduleRequestDto {

    private String title;
    private String content;
    private String author;
    private String password;

    /**
     * 일정 제목 반환
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 일정 내용 반환
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 작성자명 반환
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 비밀번호 반환
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
