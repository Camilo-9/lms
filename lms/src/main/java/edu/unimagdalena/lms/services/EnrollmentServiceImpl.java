
package edu.unimagdalena.lms.services;

import edu.unimagdalena.lms.api.dto.EnrollmentDtos.*;
import edu.unimagdalena.lms.entities.Course;
import edu.unimagdalena.lms.entities.Enrollment;
import edu.unimagdalena.lms.entities.Student;
import edu.unimagdalena.lms.repositories.CourseRepository;
import edu.unimagdalena.lms.repositories.EnrollmentRepository;
import edu.unimagdalena.lms.repositories.StudentRepository;
import edu.unimagdalena.lms.services.mapper.EnrollmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService{
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public EnrollmentResponse create(EnrollmentCreateRequest req){
        if(enrollmentRepository.existsByStudent_IdAndCourse_Id(req.studentId(), req.courseId())){
            throw new RuntimeException("Student %d is already enrolled in course %d"
                    .formatted(req.studentId(), req.courseId()));}
        Student student = studentRepository.findById(req.studentId())
                .orElseThrow(() -> new RuntimeException("Student %d not found".formatted(req.studentId())));
        Course course = courseRepository.findById(req.courseId())
                .orElseThrow(() -> new RuntimeException("Course %d not found".formatted(req.courseId())));
        Enrollment enrollment = EnrollmentMapper.toEntity(req);
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return EnrollmentMapper.toResponse(enrollmentRepository.save(enrollment));
    }

    @Override
    @Transactional(readOnly = true)
    public EnrollmentResponse get(Long id){
        return enrollmentRepository.findById(id).map(EnrollmentMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Enrollment %d not found".formatted(id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrollmentResponse> listByStudent(Long studentId){
        return enrollmentRepository.findByStudent_Id(studentId).stream().map(EnrollmentMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrollmentResponse> listByCourse(Long courseId){
        return enrollmentRepository.findByCourse_Id(courseId).stream().map(EnrollmentMapper::toResponse)
                .toList();
    }

    @Override
    public EnrollmentResponse update(Long id, EnrollmentUpdateRequest req){
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment %d not found".formatted(id)));
        enrollment.setStatus(req.status());

        return EnrollmentMapper.toResponse(enrollmentRepository.save(enrollment));
    }

    @Override
    public void delete(Long id){
        enrollmentRepository.deleteById(id);
    }
}
