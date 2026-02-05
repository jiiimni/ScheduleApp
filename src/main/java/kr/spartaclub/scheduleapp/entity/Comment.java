package kr.spartaclub.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    // 댓글의 고유 ID (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 일정과의 연관관계는 사용하지 않고 일정 ID(Long)만 저장
    @Column(nullable = false)
    private Long scheduleId;

    // 댓글 내용 (필수, 최대 100자)
    @Column(nullable = false, length = 100)
    private String content;

    // 댓글 작성자
    @Column(nullable = false)
    private String author;

    // 댓글 비밀번호 (응답에는 절대 포함하지 않음)
    @Column(nullable = false)
    private String password;

    // 댓글 생성 시간
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 댓글 수정 시간
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // 댓글 생성 시 사용하는 생성자
    public Comment(Long scheduleId, String content, String author, String password) {
        this.scheduleId = scheduleId;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 댓글 내용 수정 + 수정 시간 갱신
    public void updateContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }
}
