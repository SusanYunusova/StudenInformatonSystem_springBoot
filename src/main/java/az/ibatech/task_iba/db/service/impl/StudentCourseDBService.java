package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.StudentCourse;
import az.ibatech.task_iba.db.service.MySqlDBService;

import java.util.List;
import java.util.Optional;

public class StudentCourseDBService  implements MySqlDBService<StudentCourse> {
    @Override
    public Optional<StudentCourse> saveUpdate(StudentCourse studentCourse) {
        return Optional.empty();
    }

    @Override
    public boolean delete(StudentCourse studentCourse) {

        return false;
    }

    @Override
    public Optional<StudentCourse> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<StudentCourse> getAll() {
        return null;
    }

    @Override
    public List<StudentCourse> getAllBy(long id) {
        return null;
    }
}
