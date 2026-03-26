
package edu.unimagdalena.lms.api.dto;

import java.time.Instant;

public class InstructorDtos{
    public record InstructorCreateRequest(String email, String fullName, Instant createdAt, Instant updatedAt
    ){}
    public record InstructorResponse(Long id, String email, String fullName, Instant createdAt, Instant updatedAt, String phone, String bio){}
}
