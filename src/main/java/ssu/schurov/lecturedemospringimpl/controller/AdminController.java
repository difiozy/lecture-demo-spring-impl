package ssu.schurov.lecturedemospringimpl.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteAll")
    Boolean deleteAllInfo() {
        recordRepository.deleteAll();
        lectureRepository.deleteAll();
        personRepository.deleteAll();
        return true;
    }

    @PermitAll
    @PostMapping("/lecture")
    void createLecture(@RequestBody Lecture lecture) {
        lectureRepository.save(lecture);
    }

    @PermitAll
    @PostMapping("/lecturer")
    void createLecturer(@RequestBody Person person) {
        personRepository.save(person);
    }

    @Secured("ROLE_USER")
    @PostMapping("/record")
    void createRecord(@RequestBody RecordEntity record) {
        recordRepository.save(record);
    }
}
