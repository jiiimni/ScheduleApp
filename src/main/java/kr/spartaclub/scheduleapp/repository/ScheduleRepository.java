package kr.spartaclub.scheduleapp.repository;

import kr.spartaclub.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
