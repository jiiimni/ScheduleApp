package kr.spartaclub.scheduleapp.controller;

import kr.spartaclub.scheduleapp.entity.Schedule;
import kr.spartaclub.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;

    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody Schedule request) {
        Schedule saved = scheduleRepository.save(
                new Schedule(
                        request.getTitle(),
                        request.getContent(),
                        request.getAuthor(),
                        request.getPassword()
                )
        );
        return ResponseEntity.ok(saved);
    }
}

