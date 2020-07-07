package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.Course;
import az.ibatech.task_iba.db.service.MySqlDBService;

import java.util.List;
import java.util.Optional;

public class CourseDBService  implements MySqlDBService<Course> {
    @Override
    public Optional<Course> saveUpdate(Course course) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Course course) {
        return false;
    }

    @Override
    public Optional<Course> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Course> getAll() {
        return null;
    }

    @Override
    public List<Course> getAllBy(long id) {
        return null;
    }
}
