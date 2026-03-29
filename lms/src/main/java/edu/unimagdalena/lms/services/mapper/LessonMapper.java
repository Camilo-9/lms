
package edu.unimagdalena.lms.services.mapper;

import edu.unimagdalena.lms.api.dto.LessonDtos;
import edu.unimagdalena.lms.entities.Lesson;

public class LessonMapper{
    public static Lesson toEntity(LessonDtos.LessonCreateRequest req){
        return Lesson.builder().title(req.title()).orderIndex(req.orderIndex()).build();
    }

    public static LessonDtos.LessonResponse toResponse(Lesson l){
        return new LessonDtos.LessonResponse(l.getId(), l.getTitle(), l.getOrderIndex(), l.getCourse() != null ? l.getCourse().getId():null);
    }
}
