package Student.lms.Service;

import Student.lms.Exception.ResourceNotFoundException;
import Student.lms.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Student.lms.Entities.Student;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) {
        student.setRegistrationDate(new Date());
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student update(Long id, Student updatedStudent) {
        Student existingStudent = findById(id);
        existingStudent.setFullName(updatedStudent.getFullName());
        existingStudent.setEmail(updatedStudent.getEmail());
        return studentRepository.save(existingStudent);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
