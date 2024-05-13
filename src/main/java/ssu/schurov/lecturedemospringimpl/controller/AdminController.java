package ssu.schurov.lecturedemospringimpl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ssu.schurov.lecturedemospringimpl.entity.Lecture;
import ssu.schurov.lecturedemospringimpl.entity.Person;
import ssu.schurov.lecturedemospringimpl.entity.RecordEntity;
import ssu.schurov.lecturedemospringimpl.repository.LectureRepository;
import ssu.schurov.lecturedemospringimpl.repository.PersonRepository;
import ssu.schurov.lecturedemospringimpl.repository.RecordRepository;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final LectureRepository lectureRepository;
    private final PersonRepository personRepository;
    private final RecordRepository recordRepository;

    @GetMapping("/admin/deleteAll")
    Boolean deleteAllInfo() {
        recordRepository.deleteAll();
        lectureRepository.deleteAll();
        personRepository.deleteAll();
        return true;
    }

    @PostMapping("/lecture")
    void createLecture(@RequestBody Lecture lecture) {
        lectureRepository.save(lecture);
    }

    @PostMapping("/lecturer")
    void createLecturer(@RequestBody Person person) {
        personRepository.save(person);
    }

    @PostMapping("/record")
    void createRecord(@RequestBody RecordEntity record) {
        recordRepository.save(record);
    }

    @GetMapping("/info")
    String info() {
        return "INFO";
    }
}
