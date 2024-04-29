package ssu.schurov.lecturedemospringimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.schurov.lecturedemospringimpl.entity.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
}