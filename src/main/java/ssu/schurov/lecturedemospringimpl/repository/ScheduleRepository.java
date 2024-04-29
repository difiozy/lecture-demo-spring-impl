package ssu.schurov.lecturedemospringimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.schurov.lecturedemospringimpl.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}