package Student.lms.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Test> tests;

    @ElementCollection
    private List<String> lessonSlideshowUrls;

    private int totalLessons;
    private int completedLessons;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficulty;

    public enum DifficultyLevel {
        EASY, MEDIUM, HARD
    }

    public void markLessonComplete() {
        this.completedLessons++;
    }

    public double calculateProgress() {
        return (double) completedLessons / totalLessons * 100;
    }
}
