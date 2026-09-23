package studteac.dhabhejde.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import studteac.dhabhejde.Model.Assignment;
import studteac.dhabhejde.Service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Assignment APIs", description = "APIs for managing Assignments")
@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public Assignment createAssignment(
            @RequestBody Assignment assignment) {

        return assignmentService.createAssignment(assignment);
    }

    @GetMapping("/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @PutMapping("/{id}")
    public Assignment updateAssignment(
            @PathVariable Long id,
            @RequestBody Assignment assignment) {

        return assignmentService.updateAssignment(id, assignment);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
    }
}