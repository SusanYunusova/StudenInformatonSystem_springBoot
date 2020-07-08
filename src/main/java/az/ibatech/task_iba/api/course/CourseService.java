package az.ibatech.task_iba.api.course;

import az.ibatech.task_iba.db.entity.Course;
import az.ibatech.task_iba.db.entity.Passport;
import az.ibatech.task_iba.db.service.impl.CourseDBService;
import az.ibatech.task_iba.db.service.impl.PassportDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Slf4j
public class CourseService {
    private final CourseDBService courseDBService;

    public CourseService(CourseDBService courseDBService) {
        this.courseDBService = courseDBService;
    }

    /**
     * FunctionalProgramming for reducing code repeating and clean code
     */
    Function<Optional<?>, ResponseEntity<?>> dbFunction = (optionalData) ->
            optionalData
                    .map(data -> {
                        log.info(data + "found");
                        return new ResponseEntity<>(data, HttpStatus.OK);
                    })
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));


    /**
     * CRUD REPOSITORIES course to database by functional programming method
     * and search methods by selected parameters
     *
     * @param course
     * @return
     */
    public ResponseEntity<?> saveOrUpdate(Course course) {
        log.info("save or update courseService");
        return dbFunction.apply(courseDBService.saveUpdate(course));
    }

    public ResponseEntity<?> delete(Course course) {
        log.info("delete courseService");
        return dbFunction.apply(courseDBService.saveUpdate(course));
    }


    public ResponseEntity<?> getByID(long idCourse) {
        log.info("getById courseService");
        return dbFunction.apply(courseDBService.getById(idCourse));
    }

    public ResponseEntity<?> getAll(){
        log.info("getting All course    list");
        List<Course> passportList = courseDBService.getAll();
        if (passportList.isEmpty()){
            log.info("getAll is empty...");
            return new ResponseEntity<>(passportList,HttpStatus.NO_CONTENT);
        }else{
            log.info("list has found...");
            return new ResponseEntity<>(passportList,HttpStatus.OK);
        }
    }



}
