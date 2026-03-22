
package edu.unimagdalena.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updtedAt;

    @OneToMany(mappedBy = "course")
    private Set<Lesson> lessons;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private Set<Assessment> assessments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id")
    private Instructor intructor;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getId() == course.getId();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }

    public long getId() {
        return id;
    }
}
