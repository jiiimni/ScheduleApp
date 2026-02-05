package kr.spartaclub.scheduleapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentCreateRequestDto {

    // 댓글 내용
    private String content;

    // 작성자명
    private String author;

    // 댓글 비밀번호
    private String password;
}
