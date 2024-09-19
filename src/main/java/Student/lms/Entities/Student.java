package Student.lms.Entities;

import Student.lms.Role;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private String profilePictureUrl;

    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;

    private double averageGrade;
    private boolean isPromoted;
    private boolean notificationsEnabled;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public void calculateAverageGrade() {
        this.averageGrade = grades.stream()
                .mapToDouble(Grade::getScore)
                .average().orElse(0.0);
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public Role getRole() {
        return role;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void checkPromotion() {
        this.isPromoted = grades.stream().allMatch(g -> g.getScore() > 45);
    }
}
