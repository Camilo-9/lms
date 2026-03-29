
package edu.unimagdalena.lms.services.mapper;

import edu.unimagdalena.lms.api.dto.CourseDtos;
import edu.unimagdalena.lms.entities.Course;

public class CourseMapper{
    public static Course toEntity(CourseDtos.CourseCreateRequest req){
        return Course.builder().title(req.title()).status(req.status()).active(req.active()).createdAt(req.createdAt()).updatedAt(req.updatedAt()).build();
    }

    public static CourseDtos.CourseResponse toResponse(Course c){
        return new CourseDtos.CourseResponse(c.getId(), c.getTitle(), c.getStatus(), c.isActive(), c.getCreatedAt(), c.getUpdatedAt(), c.getIntructor() != null ? c.getIntructor().getId():null);
    }
}
