package kr.spartaclub.scheduleapp.controller;

import kr.spartaclub.scheduleapp.entity.Schedule;
import kr.spartaclub.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kr.spartaclub.scheduleapp.dto.ScheduleResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> create(@RequestBody Schedule request) {
        Schedule saved = scheduleRepository.save(
                new Schedule(
                        request.getTitle(),
                        request.getContent(),
                        request.getAuthor(),
                        request.getPassword()
                )
        );
        return ResponseEntity.ok(new ScheduleResponseDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> response = schedules.stream()
                .map(ScheduleResponseDto::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findOne(@PathVariable Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        return ResponseEntity.ok(new ScheduleResponseDto(schedule));
    }

}

