package Student.lms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Student.lms.Entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { }