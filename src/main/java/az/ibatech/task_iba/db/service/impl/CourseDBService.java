package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.Course;
import az.ibatech.task_iba.db.entity.StudentCourse;
import az.ibatech.task_iba.db.repo.CourseRepository;
import az.ibatech.task_iba.db.service.MySqlDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class CourseDBService  implements MySqlDBService<Course> {

    private final CourseRepository courseRepository;

    public CourseDBService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> saveUpdate(Course course) {
        try {
            log.info("trying to save course to db...");
            courseRepository.save(course);
            return Optional.of(course);
        } catch (Exception e) {
            log.error("error saving course to db...{}", e, e);
            return Optional.empty();
        }
    }


    @Override
    public boolean delete(Course course) {
        try {
            log.info("trying to delete course from db");
            courseRepository.delete(course);
            return true;
        } catch (Exception e) {
            log.error("error from deleting course from db{}", e, e);
            return false;
        }
    }

    @Override
    public Optional<Course> getById(long idCourse) {
        try {
            log.info("trying to get  course by id from db");
            return courseRepository.findById(idCourse);
        } catch (Exception e) {
            log.error("error getting by idCourse from Db{}{}", e, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Course> getAll() {
        try {
            log.info("trying to getAll  course from db");
            return courseRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all from db{}{}", e, e);
            return new ArrayList<>();
        }

    }

    @Override
    public List<Course> getAllBy(long id) {
        return null;
    }
}
