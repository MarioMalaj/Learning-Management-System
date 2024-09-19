package Student.lms.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationDate;
}
