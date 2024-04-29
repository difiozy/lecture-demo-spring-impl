package ssu.schurov.lecturedemospringimpl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_id_gen")
    @SequenceGenerator(name = "lecture_id_gen", sequenceName = "lecture_lecture_id_seq", allocationSize = 1)
    @Column(name = "lecture_id", nullable = false)
    private Integer id;

    @Column(name = "lecture_display_name", nullable = false, length = Integer.MAX_VALUE)
    private String lectureDisplayName;

    @OneToMany(mappedBy = "lecture")
    private Set<RecordEntity> recordEntities = new LinkedHashSet<>();

}