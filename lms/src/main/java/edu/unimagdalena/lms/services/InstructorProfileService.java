
package edu.unimagdalena.lms.services;

import edu.unimagdalena.lms.api.dto.InstructorProfileDtos.*;

public interface InstructorProfileService{
    InstructorProfileResponse create(InstructorProfileCreateRequest req);
    InstructorProfileResponse get(Long id);
    InstructorProfileResponse getByInstructor(Long instructorId);
    InstructorProfileResponse update(Long id, InstructorProfileUpdateRequest req);

    void delete(Long id);
}
