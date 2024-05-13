package ssu.schurov.lecturedemospringimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.schurov.lecturedemospringimpl.entity.Person;

public interface LecturerRepository extends JpaRepository<Person, Integer> {
}