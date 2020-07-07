package az.ibatech.task_iba.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse {
    private long idStudentCourse;
    private long idStudent;
    private long idCourse;
    private Date startDate;
    private Date finishedDate;
}
