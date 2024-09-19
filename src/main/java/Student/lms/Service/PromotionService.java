package Student.lms.Service;

import Student.lms.Entities.Classroom;
import Student.lms.Entities.Student;
import Student.lms.Repositories.ClassroomRepository;
import Student.lms.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public void promoteStudents() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getClassroom().getYear() < 3) {
                student.checkPromotion();
                if (student.isPromoted()) {
                    Classroom nextYearClassroom = findNextYearClassroom(student.getClassroom());
                    student.setClassroom(nextYearClassroom);
                    studentRepository.save(student);
                }
            }
        }
    }

    private Classroom findNextYearClassroom(Classroom currentClassroom) {
        // Find the next year's classroom based on the current year
        int nextYear = currentClassroom.getYear() + 1;

        // Retrieve the next year's classroom from the repository
        return classroomRepository.findByYear(nextYear)
                .orElseThrow(() -> new RuntimeException("Next year's classroom not found"));
    }
}
