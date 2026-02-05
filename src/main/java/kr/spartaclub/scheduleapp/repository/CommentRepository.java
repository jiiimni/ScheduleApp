package kr.spartaclub.scheduleapp.repository;

import kr.spartaclub.scheduleapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 일정에 달린 댓글 개수 조회 - 일정당 댓글 10개 제한 체크용
    long countByScheduleId(Long scheduleId);

    // 특정 일정에 달린 댓글 목록 조회 - Lv6에서 사용 예정
    List<Comment> findAllByScheduleIdOrderByUpdatedAtDesc(Long scheduleId);
}
