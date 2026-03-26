
package edu.unimagdalena.lms.api.dto;

import java.time.Instant;

public class EnrollmentDtos{
    public record EnrollmentCreateRequest(String status, Instant enrolledAt, Long studentId, Long courseId){}
    public record EnrollmentResponse(Long id, String status, Instant enrolledAt, String studentName, String courseTitle){}
}
