package az.ibatech.task_iba.db.repo;

import az.ibatech.task_iba.db.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository  extends JpaRepository<Passport,Long> {


}
