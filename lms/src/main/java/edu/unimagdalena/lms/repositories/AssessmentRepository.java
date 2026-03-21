
package edu.unimagdalena.lms.repositories;

import edu.unimagdalena.lms.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AssessmentRepository extends JpaRepository<Assessment, Long>{
    Optional<Assessment> findByType(String type);
    List<Assessment> findByIdIn(List<Long> ids);
}
