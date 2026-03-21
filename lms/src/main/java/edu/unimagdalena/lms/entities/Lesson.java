
package edu.unimagdalena.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Lesson{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "order_index", nullable = false)
    private int orderIndex;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Lesson lesson)) return false;
        return getId() == lesson.getId();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }

    public long getId() {
        return id;
    }
}
