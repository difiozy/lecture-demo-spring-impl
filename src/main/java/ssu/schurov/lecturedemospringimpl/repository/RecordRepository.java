package ssu.schurov.lecturedemospringimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.schurov.lecturedemospringimpl.entity.RecordEntity;

public interface RecordRepository extends JpaRepository<RecordEntity, Integer> {
}