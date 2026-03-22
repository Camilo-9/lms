
package edu.unimagdalena.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "enrollments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Enrollment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String status;

    @Column(name = "enrolled_at", nullable = false)
    private Instant enrolledAt;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Enrollment that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }

    public long getId() {
        return id;
    }
}
