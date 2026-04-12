package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Schedule 엔티티에 대한 데이터 접근 Repository
 * JpaRepository를 상속받아(extends) 기본 CRUD 메서드를 자동으로 제공
 * Schedule : 대상 엔티티
 * Long : 엔티티의 기본 키(PK) 타입
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    /**
     * 작성자(author) 기준 전체 조회 메서드
     * @param author 작성자명
     * @return 작성자에 해당하는 일정 목록
     */
    List<Schedule>findByAuthor(String author);

}
