package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.StudentCourse;
import az.ibatech.task_iba.db.repo.StudentCourseRepository;
import az.ibatech.task_iba.db.service.MySqlDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class StudentCourseDBService  implements MySqlDBService<StudentCourse> {
    private final StudentCourseRepository studentCourseRepository;

    public StudentCourseDBService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public Optional<StudentCourse> saveUpdate(StudentCourse studentCourse) {
        try {
            log.info("trying to save studentCourse to db...");
            studentCourseRepository.save(studentCourse);
            return Optional.of(studentCourse);
        } catch (Exception e) {
            log.error("error saving studentCourse to db...{}", e, e);
            return Optional.empty();
        }
    }


    @Override
    public boolean delete(StudentCourse studentCourse) {
        try {
            log.info("trying to delete studentCourse from db");
            studentCourseRepository.delete(studentCourse);
            return true;
        } catch (Exception e) {
            log.error("error from deleting studentCourse from db{}", e, e);
            return false;
        }
    }

    @Override
    public Optional<StudentCourse> getById(long idStuCourse) {
        try {
            log.info("trying to get student course by id from db");
            return studentCourseRepository.findById(idStuCourse);
        } catch (Exception e) {
            log.error("error getting by idStuCourse from Db{}{}", e, e);
            return Optional.empty();
        }
    }

    @Override
    public List<StudentCourse> getAll() {
        try {
            log.info("trying to getAll student course from db");
            return studentCourseRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all from db{}{}", e, e);
            return new ArrayList<>();
        }

    }

    @Override
    public List<StudentCourse> getAllBy(long id) {

        return null;
    }
}
