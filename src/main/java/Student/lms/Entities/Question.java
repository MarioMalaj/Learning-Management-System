package Student.lms.Entities;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;
    private String answer;
    private String[] options;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    private int marks;
}
