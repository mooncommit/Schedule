package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ScheduleController
 * 요청/응답
 */
@RestController
@RequiredArgsConstructor // 의존성 주입
public class ScheduleController {
    private final ScheduleService scheduleService;

    /**
     * 이 부분은
     * @return 공부하러갈게요
     */
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule() {

    }

}
