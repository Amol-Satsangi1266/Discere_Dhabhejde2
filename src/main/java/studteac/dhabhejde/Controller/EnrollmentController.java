package studteac.dhabhejde.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import studteac.dhabhejde.Model.Enrollment;
import studteac.dhabhejde.Service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Enrollment APIs", description = "APIs for managing Enrollments")
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment createEnrollment(
            @RequestBody Enrollment enrollment) {

        return enrollmentService.createEnrollment(enrollment);
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}