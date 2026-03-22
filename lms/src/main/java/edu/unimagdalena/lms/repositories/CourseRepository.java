
package edu.unimagdalena.lms.repositories;

import edu.unimagdalena.lms.entities.Assessment;
import edu.unimagdalena.lms.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long>{
    Optional<Course> findByTitle(String type);
    List<Course> findByStatus(String status);
}
