package ssu.schurov.lecturedemospringimpl.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ssu.schurov.lecturedemospringimpl.entity.Lecture;
import ssu.schurov.lecturedemospringimpl.entity.Lecturer;
import ssu.schurov.lecturedemospringimpl.entity.RecordEntity;
import ssu.schurov.lecturedemospringimpl.entity.Schedule;
import ssu.schurov.lecturedemospringimpl.repository.LectureRepository;
import ssu.schurov.lecturedemospringimpl.repository.LecturerRepository;
import ssu.schurov.lecturedemospringimpl.repository.RecordRepository;
import ssu.schurov.lecturedemospringimpl.repository.ScheduleRepository;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final LectureRepository lectureRepository;
    private final LecturerRepository lecturerRepository;
    private final RecordRepository recordRepository;
    private final ScheduleRepository scheduleRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteAll")
    Boolean deleteAllInfo() {
        recordRepository.deleteAll();
        scheduleRepository.deleteAll();
        lectureRepository.deleteAll();
        lecturerRepository.deleteAll();
        return true;
    }

    @PermitAll
    @PostMapping("/lecture")
    void createLecture(@RequestBody Lecture lecture) {
        lectureRepository.save(lecture);
    }

    @PermitAll
    @PostMapping("/lecturer")
    void createLecturer(@RequestBody Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/schedule")
    void createSchedule(@RequestBody Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Secured("ROLE_USER")
    @PostMapping("/record")
    void createRecord(@RequestBody RecordEntity record) {
        recordRepository.save(record);
    }
}
