
package edu.unimagdalena.lms.api.dto;

public class LessonDtos{
    public record LessonCreateRequest(String title, int orderIndex, Long courseId){}
    public record LessonResponse(Long id, String title, int orderIndex, String courseTitle){}
}
