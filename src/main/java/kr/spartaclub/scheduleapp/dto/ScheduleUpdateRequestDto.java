package kr.spartaclub.scheduleapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleUpdateRequestDto {
    private String title;
    private String content;
    private String password;
}
