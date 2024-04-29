package ssu.schurov.lecturedemospringimpl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_id_gen")
    @SequenceGenerator(name = "lecturer_id_gen", sequenceName = "lecturer_lecturer_id_seq", allocationSize = 1)
    @Column(name = "lecturer_id", nullable = false)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = Integer.MAX_VALUE)
    private String fullName;

    @OneToMany(mappedBy = "lecturer")
    private Set<RecordEntity> recordEntities = new LinkedHashSet<>();

}