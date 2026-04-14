package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비즈니스 로직 처리
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    /**
     * 일정 저장
     * @param request 클라이언트 요청 데이터
     * @return 저장된 일정 응답 데이터
     */
    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto request) {
        // 요청 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                 request.getPassword()
        );
        // Repository를 통해 DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);
        // 저장된 결과를 ResponseDto에 담아 반환 (password 제외)
        ScheduleResponseDto responseDto = new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
        return responseDto;
    }
}
