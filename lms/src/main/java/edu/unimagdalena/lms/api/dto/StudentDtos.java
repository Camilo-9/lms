
package edu.unimagdalena.lms.api.dto;
import java.time.Instant;

public class StudentDtos{
    public record StudentCreateRequest(String email, String fullName, Instant createdAt, Instant updatedAt){}
    public record StudentResponse(Long id, String email, String fullName, Instant createdAt, Instant updatedAt){}
}
