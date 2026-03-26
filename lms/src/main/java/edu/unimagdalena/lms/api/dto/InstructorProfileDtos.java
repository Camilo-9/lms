
package edu.unimagdalena.lms.api.dto;

public class InstructorProfileDtos{
    public record InstructorProfileCreateRequest(String phone, String bio, Long instructorId){}
    public record InstructorProfileResponse(Long id, String phone, String bio, String instructorName){}
}
