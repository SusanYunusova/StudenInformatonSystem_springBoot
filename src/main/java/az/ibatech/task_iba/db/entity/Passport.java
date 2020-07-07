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
@Table(name = "passport")
public class Passport {
    private long idPassport;
    private long idStudent;
    private String pincode;
    private String serial;
    private int isActive;
}
