
package edu.unimagdalena.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "instructors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Instructor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses;

    @OneToOne(
            mappedBy = "instructor", optional = false
    )
    private InstructorProfile instructorProfile;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Instructor that)) return false;
        return getId() == that.getId() && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getEmail());
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
