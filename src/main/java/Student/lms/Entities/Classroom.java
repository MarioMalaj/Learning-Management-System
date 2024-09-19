package Student.lms.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studyingField;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Course> courses;

    private String announcement;
}
