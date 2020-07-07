package az.ibatech.task_iba.db.repo;

import az.ibatech.task_iba.db.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {
}
