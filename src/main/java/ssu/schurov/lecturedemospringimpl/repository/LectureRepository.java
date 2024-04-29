package ssu.schurov.lecturedemospringimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.schurov.lecturedemospringimpl.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}