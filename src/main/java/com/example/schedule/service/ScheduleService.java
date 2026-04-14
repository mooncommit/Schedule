package com.example.schedule.service;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 전체 일정 조회
     * @param author 클라이언트가 전달한 작성자명 (선택값)
     * @return 일정 목록 DTO 리스트 반환
     */
    @Transactional(readOnly = true) // 조회 전용
    public List<GetAllSchedulesResponse> getAllSchedules(String author) {
        // author 조건에 따라 DB 조회
        List<Schedule> schedules;
        if (author != null) {
             schedules = scheduleRepository.findByAuthor(author);
        } else {
            schedules = scheduleRepository.findAll();
        }

        // Entity → DTO 변환 (stream 사용)
        List<GetAllSchedulesResponse> responses = schedules.stream()
                // 변환
                .map(schedule -> new GetAllSchedulesResponse(
                        schedule.getId(), schedule.getTitle(), schedule.getContent(),
                        schedule.getAuthor(), schedule.getCreatedAt(), schedule.getModifiedAt()))
                .collect(Collectors.toList());
        // 변환된 DTO 리스트 반환
        return responses;
    }

    /**
     * 선택 일정 조회
     * @param id 조회할 일정의 Key
     * @return 단건 일정 DTO 반환
     */
    @Transactional(readOnly = true) // 조회 전용
    public GetSchedulesResponse getSchedule(Long id) {
        // id로 일정 조회 (없으면 예외 발생)
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        // Entity → DTO 변환
        GetSchedulesResponse response = new GetSchedulesResponse(schedule.getId(), schedule.getTitle(),
                 schedule.getContent(), schedule.getAuthor(), schedule.getCreatedAt(), schedule.getModifiedAt());
        // DTO 반환
        return response;
    }

    /**
     * 일정 수정
     * @param id 수정할 일정의 ID
     * @param result 수정할 데이터 (제목, 작성자명, 비밀번호)
     * @return 수정된 일정 정보 (비밀번호 제외)
     */
    @Transactional
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto result) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("해당 일정이 없습니다!"));
        // 클라이언트가 입력한 비밀번호 검증
        if (!schedule.getPassword().equals(result.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 값 수정
        schedule.updateData(result);
        // Entity → DTO 변환
        UpdateScheduleResponseDto responseDto = new UpdateScheduleResponseDto(
                schedule.getId(), schedule.getTitle(),schedule.getContent(),
                schedule.getAuthor(),schedule.getCreatedAt(),schedule.getModifiedAt());

        return responseDto;
    }
}
