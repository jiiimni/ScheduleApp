package kr.spartaclub.scheduleapp.controller;

import kr.spartaclub.scheduleapp.dto.CommentCreateRequestDto;
import kr.spartaclub.scheduleapp.dto.CommentResponseDto;
import kr.spartaclub.scheduleapp.entity.Comment;
import kr.spartaclub.scheduleapp.repository.CommentRepository;
import kr.spartaclub.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules/{scheduleId}/comments")
public class CommentController {

    // 댓글 Repository
    private final CommentRepository commentRepository;

    // 일정 존재 여부 확인용
    private final ScheduleRepository scheduleRepository;


     // 댓글 생성 API
     // POST /api/schedules/{scheduleId}/comments
    @PostMapping
    public ResponseEntity<?> create(
            @PathVariable Long scheduleId,
            @RequestBody CommentCreateRequestDto request
    ) {

        // 1️⃣ 일정 존재 여부 확인
        if (!scheduleRepository.existsById(scheduleId)) {
            return ResponseEntity
                    .status(404)
                    .body("해당 일정이 없습니다.");
        }

        // 댓글 10개 제한 체크
        long commentCount = commentRepository.countByScheduleId(scheduleId);
        if (commentCount >= 10) {
            return ResponseEntity
                    .badRequest()
                    .body("댓글은 일정당 최대 10개까지 작성할 수 있습니다.");
        }

        // 댓글 저장
        Comment saved = commentRepository.save(
                new Comment(
                        scheduleId,
                        request.getContent(),
                        request.getAuthor(),
                        request.getPassword()
                )
        );

        // 응답 (비밀번호 제외)
        return ResponseEntity.ok(new CommentResponseDto(saved));
    }
}
