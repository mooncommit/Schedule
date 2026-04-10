package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Schedule 엔티티에 대한 데이터 접근 Repository
 * JpaRepository를 상속받아(extends) 기본 CRUD 메서드를 자동으로 제공
 * Schedule : 대상 엔티티
 * Long : 엔티티의 기본 키(PK) 타입
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
