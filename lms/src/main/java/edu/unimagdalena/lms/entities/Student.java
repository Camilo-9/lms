
package edu.unimagdalena.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column (name = "full_name", nullable = false)
    private String fullName;

    @Column (name = "created_at", nullable = false)
    private Instant createdAt;

    @Column (name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "student")
    private Set<Assessment> assessments;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getId() == student.getId() && Objects.equals(getEmail(), student.getEmail());
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
