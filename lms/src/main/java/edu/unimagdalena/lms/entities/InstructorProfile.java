
package edu.unimagdalena.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "instructor_profiles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InstructorProfile{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String bio;

    @OneToOne(optional = false)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof InstructorProfile that)) return false;
        return getId() == that.getId() && Objects.equals(getPhone(), that.getPhone());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getPhone());
    }

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }
}
