
package edu.unimagdalena.lms.api.dto;

import java.time.Instant;

public class CourseDtos{
    public record CourseCreateRequest(String title, String status, boolean active, Instant createdAt, Instant updatedAt, Long instructorId){}
    public record CourseResponse(Long id, String title, String status, boolean active, Instant createdAt, Instant updatedAt, String instructorName){}
}
