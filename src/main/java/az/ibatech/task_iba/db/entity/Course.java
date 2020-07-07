package az.ibatech.task_iba.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    private long idCourse;
    private String name;
    private String phone;
}
