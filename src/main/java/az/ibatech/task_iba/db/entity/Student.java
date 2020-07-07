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
@Table(name = "student")
public class Student {
    private long idStudent;
    private String name;
    private String surname;
    private String email;
    private String address;

}
