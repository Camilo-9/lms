
package edu.unimagdalena.lms.api.dto;

import java.time.Instant;

public class AssessmentDtos{
    public record AssessmentCreateRequest(String type, int score, Instant takenAt, Long studentId, Long courseId){}
    public record AssessmentResponse(Long id, String type, int score, Instant takenAt, String studentName, String courseTitle){}
}
