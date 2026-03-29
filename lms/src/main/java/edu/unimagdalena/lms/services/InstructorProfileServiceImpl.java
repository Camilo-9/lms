
package edu.unimagdalena.lms.services;

import edu.unimagdalena.lms.api.dto.InstructorProfileDtos.*;
import edu.unimagdalena.lms.entities.Instructor;
import edu.unimagdalena.lms.entities.InstructorProfile;
import edu.unimagdalena.lms.repositories.InstructorProfileRepository;
import edu.unimagdalena.lms.repositories.InstructorRepository;
import edu.unimagdalena.lms.services.mapper.InstructorProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorProfileServiceImpl implements InstructorProfileService{
    private final InstructorProfileRepository instructorProfileRepository;
    private final InstructorRepository instructorRepository;

    @Override
    public InstructorProfileResponse create(InstructorProfileCreateRequest req){
        Instructor instructor = instructorRepository.findById(req.instructorId())
                .orElseThrow(() -> new RuntimeException("Instructor %d not found".formatted(req.instructorId())));
        InstructorProfile profile = InstructorProfileMapper.toEntity(req);
        profile.setInstructor(instructor);

        return InstructorProfileMapper.toResponse(instructorProfileRepository.save(profile));
    }

    @Override
    @Transactional(readOnly = true)
    public InstructorProfileResponse get(Long id){
        return instructorProfileRepository.findById(id).map(InstructorProfileMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("InstructorProfile %d not found".formatted(id)));
    }

    @Override
    @Transactional(readOnly = true)
    public InstructorProfileResponse getByInstructor(Long instructorId){
        return instructorProfileRepository.findByInstructor_Id(instructorId)
                .map(InstructorProfileMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Profile for instructor %d not found".formatted(instructorId)));
    }

    @Override
    public InstructorProfileResponse update(Long id, InstructorProfileUpdateRequest req){
        InstructorProfile profile = instructorProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InstructorProfile %d not found".formatted(id)));
        profile.setPhone(req.phone());
        profile.setBio(req.bio());

        return InstructorProfileMapper.toResponse(instructorProfileRepository.save(profile));
    }

    @Override
    public void delete(Long id) {
        instructorProfileRepository.deleteById(id);
    }
}
