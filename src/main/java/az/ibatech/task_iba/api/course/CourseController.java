package az.ibatech.task_iba.api.course;

import az.ibatech.task_iba.db.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping()
    public ResponseEntity<?> create(Course course){
        log.info("save...");
        return courseService.saveOrUpdate(course);

    }
    @PutMapping()
    public ResponseEntity<?> update(Course student){
        log.info("update...");
        return courseService.saveOrUpdate(student);

    }
    @DeleteMapping()
    public ResponseEntity<?> delete(Course course){
        log.info("delete...");
        return courseService.saveOrUpdate(course);

    }
    @GetMapping()
    public ResponseEntity<?> getAll(){
        log.info("getting All");
        return courseService.getAll();

    }
    @GetMapping("/{idCourse}")
    public ResponseEntity<?> getByID(@PathVariable long idCourse){
        log.info("getting by id:{}",idCourse);
        return courseService.getByID(idCourse);

    }



}
