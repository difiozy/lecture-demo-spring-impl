package ssu.schurov.lecturedemospringimpl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_id_gen")
    @SequenceGenerator(name = "schedule_id_gen", sequenceName = "schedule_schedule_id_seq", allocationSize = 1)
    @Column(name = "schedule_id", nullable = false)
    private Integer id;

    @Column(name = "schedule_name", length = Integer.MAX_VALUE)
    private String scheduleName;

    @OneToMany(mappedBy = "schedule")
    private Set<RecordEntity> recordEntities = new LinkedHashSet<>();

}