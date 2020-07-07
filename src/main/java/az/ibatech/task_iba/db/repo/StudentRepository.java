package az.ibatech.task_iba.db.repo;

import az.ibatech.task_iba.db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdStudent(long idStudent);
}
