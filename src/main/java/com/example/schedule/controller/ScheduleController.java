package com.example.schedule.controller;

import com.example.schedule.dto.GetAllSchedulesResponse;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
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
     */
    @GetMapping
    public ResponseEntity<List<GetAllSchedulesResponse>> getAllSchedule (@RequestParam (required = false)String author) {
        List<GetAllSchedulesResponse> responseDtoList = scheduleService.getAllSchedules(author);
        return ResponseEntity.ok(responseDtoList);
    }

    /**
     * 선택 일정 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<GetAllSchedulesResponse>> getOneSchedule (@PathVariable Long id) {

    }
}
