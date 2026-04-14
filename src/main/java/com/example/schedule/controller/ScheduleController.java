package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 요청 / 응답
 */
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor // 의존성 주입
public class ScheduleController {
    private final ScheduleService scheduleService;

    /**
     * 일정 생성
     * 클라이언트 요청을 받아 일정을 저장하고 결과를 반환
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto request) {
        // Service에 요청 데이터를 넘겨서 저장
        ScheduleResponseDto responseDto = scheduleService.save(request);
        // 저장된 결과를 클라이언트에게 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    /**
     * 전체 일정 조회
     * 작성자(author)가 있으면 해당 작성자의 일정만 조회
     * 없으면 전체 일정 조회
     */
    @GetMapping
    public ResponseEntity<List<GetAllSchedulesResponse>> getAllSchedule (@RequestParam (required = false)String author) {
        // Service에 author 조건을 넘겨서 일정 목록 조회
        List<GetAllSchedulesResponse> responseDtoList = scheduleService.getAllSchedules(author);
        // 조회된 결과를 200 OK 상태코드와 함께 반환
        return ResponseEntity.ok(responseDtoList);
    }

    /**
     * 선택 일정 조회
     * URL 경로의 id 값을 꺼내 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<GetSchedulesResponse> getOneSchedule (@PathVariable Long id) {
        // Service에 id를 넘겨 해당 일정 단건 조회
        GetSchedulesResponse responseListDto = scheduleService.getSchedule(id);
        // 조회된 결과를 200 OK 상태코드와 함께 반환
        return ResponseEntity.ok(responseListDto);
    }

    /**
     * 선택한 일정 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedul (
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto request) {
        // Service에 id를 넘겨 일정 제목, 작성자명 수정
        UpdateScheduleResponseDto responseDto = scheduleService.updateSchedule(id, request);
        return ResponseEntity.ok(responseDto);
    }

    /**
     * 선택한 일정 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            @RequestBody DeleteScheduleRequestDto result
    ) {
        scheduleService.deleteSchedule(id, result);
        return ResponseEntity.ok().build(); // 성공, 줄 body 없음
    }

}
