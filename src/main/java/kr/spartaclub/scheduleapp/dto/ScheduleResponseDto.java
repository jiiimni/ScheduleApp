package kr.spartaclub.scheduleapp.dto;

import kr.spartaclub.scheduleapp.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.author = schedule.getAuthor();
    }
}
