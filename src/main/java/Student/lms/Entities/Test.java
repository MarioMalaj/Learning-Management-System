package Student.lms.Entities;

import Student.lms.Entities.Course;
import Student.lms.Entities.Grade;
import Student.lms.Entities.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testName;
    private int maxMarks;
    private boolean isAutomated;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Grade> grades;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questions;


}
