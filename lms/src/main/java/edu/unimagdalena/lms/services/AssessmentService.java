
package edu.unimagdalena.lms.services;

import edu.unimagdalena.lms.api.dto.AssessmentDtos.*;
import java.util.List;

public interface AssessmentService{
    AssessmentResponse create(AssessmentCreateRequest req);
    AssessmentResponse get(Long id);
    List<AssessmentResponse> list();

    void delete(Long id);
}
