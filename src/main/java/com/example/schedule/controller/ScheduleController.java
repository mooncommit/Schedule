package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 요청 / 응답
 */
@RestController
@RequiredArgsConstructor // 의존성 주입
public class ScheduleController {
    private final ScheduleService scheduleService;

    /**
     * 일정 생성
     * 클라이언트 요청을 받아 일정을 저장하고 결과를 반환
     */
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto request) {
        // Service에 요청 데이터를 넘겨서 저장
        ScheduleResponseDto responseDto = scheduleService.save(request);
        // 저장된 결과를 클라이언트에게 반환
        return ResponseEntity.ok(responseDto);
    }

}
